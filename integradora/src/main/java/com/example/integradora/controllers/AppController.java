package com.example.integradora.controllers;

import com.example.integradora.Models.Producto;
import com.example.integradora.services.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Comparator;

public class AppController {

    @FXML private TextField txt_buscar;
    @FXML private Label lbl_error;
    @FXML private Label lbl_status;
    @FXML private ComboBox<String> cmb_ordenar;

    @FXML private TableView<Producto> tbl_productos;
    @FXML private TableColumn<Producto, String>  col_id;
    @FXML private TableColumn<Producto, String>  col_nombre;
    @FXML private TableColumn<Producto, Double>  col_precio;
    @FXML private TableColumn<Producto, Integer> col_stock;
    @FXML private TableColumn<Producto, String>  col_categoria;

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private ProductService service = new ProductService();

    @FXML
    public void initialize() {

        // Configurar columnas de la tabla
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        col_categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        // Filtro de busqueda en tiempo real
        FilteredList<Producto> listaFiltrada = new FilteredList<>(listaProductos, p -> true);

        txt_buscar.textProperty().addListener((obs, oldVal, newVal) -> {
            listaFiltrada.setPredicate(producto -> {
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }
                String filtro = newVal.toLowerCase();
                return producto.getNombre().toLowerCase().contains(filtro)
                    || producto.getId().toLowerCase().contains(filtro);
            });
        });

        // Ordenamiento por clic en columnas
        SortedList<Producto> listaOrdenada = new SortedList<>(listaFiltrada);
        listaOrdenada.comparatorProperty().bind(tbl_productos.comparatorProperty());
        tbl_productos.setItems(listaOrdenada);

        // Opciones del combobox de ordenamiento
        cmb_ordenar.setItems(FXCollections.observableArrayList(
                "Sin ordenar",
                "Nombre A-Z",
                "Nombre Z-A",
                "Precio menor a mayor",
                "Precio mayor a menor",
                "Stock mayor a menor"
        ));
        cmb_ordenar.getSelectionModel().selectFirst();
        cmb_ordenar.setOnAction(e -> ordenarLista());

        onReload();
    }

    // Ordena la lista segun lo que eligio el usuario en el combobox
    private void ordenarLista() {
        String opcion = cmb_ordenar.getValue();

        if (opcion.equals("Nombre A-Z")) {
            FXCollections.sort(listaProductos, Comparator.comparing(Producto::getNombre));

        } else if (opcion.equals("Nombre Z-A")) {
            FXCollections.sort(listaProductos, Comparator.comparing(Producto::getNombre).reversed());

        } else if (opcion.equals("Precio menor a mayor")) {
            FXCollections.sort(listaProductos, Comparator.comparingDouble(Producto::getPrecio));

        } else if (opcion.equals("Precio mayor a menor")) {
            FXCollections.sort(listaProductos, Comparator.comparingDouble(Producto::getPrecio).reversed());

        } else if (opcion.equals("Stock mayor a menor")) {
            FXCollections.sort(listaProductos, Comparator.comparingInt(Producto::getStock).reversed());
        }
    }

    @FXML
    public void onOpenAddForm() {
        abrirFormulario(null);
    }

    @FXML
    public void onEditProduct() {
        Producto seleccionado = tbl_productos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            abrirFormulario(seleccionado);
        } else {
            lbl_error.setText("Selecciona un producto de la tabla para editar.");
            lbl_status.setText("");
        }
    }

    private void abrirFormulario(Producto producto) {
        lbl_error.setText("");
        lbl_status.setText("");
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/integradora/views/form-view.fxml")
            );
            Parent root = loader.load();

            FormController controller = loader.getController();
            controller.initData(producto, listaProductos, service);

            Stage stage = new Stage();
            if (producto == null) {
                stage.setTitle("Agregar Producto");
            } else {
                stage.setTitle("Editar Producto");
            }
            stage.setScene(new Scene(root));
            stage.showAndWait();

            tbl_productos.refresh();

        } catch (IOException e) {
            lbl_error.setText("No se pudo abrir el formulario: " + e.getMessage());
        }
    }

    @FXML
    public void onReload() {
        lbl_error.setText("");
        lbl_status.setText("");
        try {
            listaProductos.setAll(service.loadProducts());
            lbl_status.setText("Productos cargados: " + listaProductos.size());
        } catch (IOException e) {
            lbl_error.setText("Error al cargar el archivo: " + e.getMessage());
        }
    }

    @FXML
    public void onDeleteProduct() {
        Producto seleccionado = tbl_productos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            lbl_error.setText("Selecciona un producto para eliminar.");
            lbl_status.setText("");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Eliminar Producto");
        confirmacion.setHeaderText("¿Deseas eliminar: " + seleccionado.getNombre() + "?");

        if (confirmacion.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            listaProductos.remove(seleccionado);
            try {
                service.saveAllProducts(listaProductos);
                lbl_status.setText("Producto eliminado correctamente.");
                lbl_error.setText("");
            } catch (IOException e) {
                lbl_error.setText("Error al guardar: " + e.getMessage());
            }
        }
    }
}