package com.example.integradora.controllers;

import com.example.integradora.Models.Producto;
import com.example.integradora.services.ProductService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormController {

    @FXML private TextField txt_id;
    @FXML private TextField txt_nombre;
    @FXML private TextField txt_precio;
    @FXML private TextField txt_stock;
    @FXML private TextField txt_categoria;
    @FXML private Label lbl_error;

    private ProductService service;
    private ObservableList<Producto> listaProductos;
    private Producto productoEdicion;

    public void initData(Producto producto, ObservableList<Producto> listaProductos, ProductService service) {
        this.listaProductos = listaProductos;
        this.service = service;
        this.productoEdicion = producto;

        // Si viene un producto, es modo edicion: llenamos los campos
        if (producto != null) {
            txt_id.setText(producto.getId());
            txt_id.setDisable(true); // no se puede cambiar el id
            txt_nombre.setText(producto.getNombre());
            txt_precio.setText(String.format("%.2f", producto.getPrecio()));
            txt_stock.setText(String.valueOf(producto.getStock()));
            txt_categoria.setText(producto.getCategoria());
        }
    }

    @FXML
    public void onSave() {
        lbl_error.setText("");

        // Validar campos vacios
        if (txt_id.getText().isBlank()) {
            lbl_error.setText("El codigo es obligatorio.");
            return;
        }
        if (txt_nombre.getText().isBlank()) {
            lbl_error.setText("El nombre es obligatorio.");
            return;
        }
        if (txt_nombre.getText().trim().length() < 3) {
            lbl_error.setText("El nombre debe tener al menos 3 caracteres.");
            return;
        }
        if (txt_precio.getText().isBlank()) {
            lbl_error.setText("El precio es obligatorio.");
            return;
        }
        if (txt_stock.getText().isBlank()) {
            lbl_error.setText("El stock es obligatorio.");
            return;
        }
        if (txt_categoria.getText().isBlank()) {
            lbl_error.setText("La categoria es obligatoria.");
            return;
        }

        // Validar que precio y stock sean numeros validos
        double precio;
        int stock;
        try {
            precio = Double.parseDouble(txt_precio.getText().trim());
        } catch (NumberFormatException e) {
            lbl_error.setText("El precio debe ser un numero valido. Ej: 12.50");
            return;
        }
        try {
            stock = Integer.parseInt(txt_stock.getText().trim());
        } catch (NumberFormatException e) {
            lbl_error.setText("El stock debe ser un numero entero. Ej: 10");
            return;
        }

        // Validar rangos
        if (precio <= 0) {
            lbl_error.setText("El precio debe ser mayor a 0.");
            return;
        }
        if (stock < 0) {
            lbl_error.setText("El stock no puede ser negativo.");
            return;
        }

        try {
            if (productoEdicion == null) {
                // Verificar que el codigo no este duplicado
                for (Producto p : listaProductos) {
                    if (p.getId().equalsIgnoreCase(txt_id.getText().trim())) {
                        lbl_error.setText("Ese codigo ya existe. Usa uno diferente.");
                        return;
                    }
                }
                // Agregar nuevo producto
                Producto nuevo = new Producto(
                        txt_id.getText().trim(),
                        txt_nombre.getText().trim(),
                        precio,
                        stock,
                        txt_categoria.getText().trim()
                );
                listaProductos.add(nuevo);

            } else {
                // Actualizar producto existente
                productoEdicion.setNombre(txt_nombre.getText().trim());
                productoEdicion.setPrecio(precio);
                productoEdicion.setStock(stock);
                productoEdicion.setCategoria(txt_categoria.getText().trim());
            }

            service.saveAllProducts(listaProductos);
            cerrarVentana();

        } catch (Exception e) {
            lbl_error.setText("Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    public void onCancel() {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txt_id.getScene().getWindow();
        stage.close();
    }
}