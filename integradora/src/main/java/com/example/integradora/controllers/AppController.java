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

public class AppController {

    @FXML private TextField txt_buscar;
    @FXML private Label lbl_error;

    @FXML private TableView<Producto> tbl_productos;
    @FXML private TableColumn<Producto, String> col_id;
    @FXML private TableColumn<Producto, String> col_nombre;
    @FXML private TableColumn<Producto, Double> col_precio;
    @FXML private TableColumn<Producto, Integer> col_stock;
    @FXML private TableColumn<Producto, String> col_categoria;

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private ProductService service = new ProductService();


    @FXML
    public void initialize() {
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        col_categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        FilteredList<Producto> listaFiltrada = new FilteredList<>(listaProductos, p -> true);

        txt_buscar.textProperty().addListener((observable, oldValue, newValue) -> {
            listaFiltrada.setPredicate(producto -> {
                if (newValue == null || newValue.isEmpty()) return true;
                String filter = newValue.toLowerCase();
                return producto.getNombre().toLowerCase().contains(filter) ||
                        producto.getId().toLowerCase().contains(filter);
            });
        });

        SortedList<Producto> listaOrdenada = new SortedList<>(listaFiltrada);
        listaOrdenada.comparatorProperty().bind(tbl_productos.comparatorProperty());

        tbl_productos.setItems(listaOrdenada);
        onReload();
    }
    public void onOpenAddForm() {
        abrirFormulario(null);
    }

    @FXML
    public void onEditProduct() {
        Producto seleccionado = tbl_productos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            abrirFormulario(seleccionado);
        } else {
            lbl_error.setText("Selecciona un producto de la tabla para editar");
        }
    }

    private void abrirFormulario(Producto producto) {
        lbl_error.setText("");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/integradora/views/form-view.fxml"));
            Parent root = loader.load();

            FormController controller = loader.getController();
            controller.initData(producto, listaProductos, service);

            Stage stage = new Stage();
            stage.setTitle(producto == null ? "Agregar Nuevo Producto" : "Editar Producto");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            tbl_productos.refresh();

        } catch (IOException e) {
            lbl_error.setText("No se pudo abrir el formulario: " + e.getMessage());
        }
    }

    @FXML
    public void onReload() {
        try {
            lbl_error.setText("");
            listaProductos.setAll(service.loadProducts());
        } catch (IOException e) {
            lbl_error.setText("Error al cargar datos: " + e.getMessage());
        }
    }

    @FXML
    public void onDeleteProduct() {
        Producto seleccionado = tbl_productos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar Producto");
            alert.setHeaderText("¿Estás seguro de eliminar: " + seleccionado.getNombre() + "?");

            if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
                listaProductos.remove(seleccionado);
                 try {
                   service.saveAllProducts(listaProductos);
                    lbl_error.setText("Producto eliminado correctamente");
                } catch (IOException e) {
                    lbl_error.setText("Error al eliminar del archivo: " + e.getMessage());
                }
            }
        } else {
            lbl_error.setText("Selecciona un producto de la tabla para eliminar");
        }
    }
}