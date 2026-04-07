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

        if (producto != null) {
            txt_id.setText(producto.getId());
            txt_id.setDisable(true);
            txt_nombre.setText(producto.getNombre());
            txt_precio.setText(String.valueOf(producto.getPrecio()));
            txt_stock.setText(String.valueOf(producto.getStock()));
            txt_categoria.setText(producto.getCategoria());
        }
    }

    @FXML
    public void onSave() {
        try {
            validarCampos();

            if (productoEdicion == null) {
                for (Producto p : listaProductos) {
                    if (p.getId().equalsIgnoreCase(txt_id.getText())) {
                        throw new IllegalArgumentException("El ID ya existe Usa uno diferente");
                    }
                }

                Producto nuevo = new Producto(
                        txt_id.getText(), txt_nombre.getText(),
                        Double.parseDouble(txt_precio.getText()),
                        Integer.parseInt(txt_stock.getText()),
                        txt_categoria.getText()
                );
                listaProductos.add(nuevo);
            } else {
                productoEdicion.setNombre(txt_nombre.getText());
                productoEdicion.setPrecio(Double.parseDouble(txt_precio.getText()));
                productoEdicion.setStock(Integer.parseInt(txt_stock.getText()));
                productoEdicion.setCategoria(txt_categoria.getText());
            }

            service.saveAllProducts(listaProductos);
            cerrarVentana();

        } catch (IllegalArgumentException e) {
            lbl_error.setText(e.getMessage());
        } catch (Exception e) {
            lbl_error.setText("Error al guardar: " + e.getMessage());
        }
    }

    private void validarCampos() {
        if (txt_id.getText().isBlank() || txt_nombre.getText().isBlank()) {
            throw new IllegalArgumentException("El ID y Nombre son obligatorios");
        }
        if (txt_nombre.getText().trim().length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        try {
            double precio = Double.parseDouble(txt_precio.getText());
            int stock = Integer.parseInt(txt_stock.getText());
            if (precio <= 0) throw new IllegalArgumentException("El precio debe ser mayor a 0");
            if (stock < 0) throw new IllegalArgumentException("El stock no puede ser negativo");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Precio y Stock deben ser numeros validos");
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
