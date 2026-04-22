package controlador;



import Modelo.Libro;
import Modelo.LibroDAO;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controlador {

	@FXML
	private TableView<Libro> tablaLibros;

	@FXML
	private TableColumn<Libro, String> colTitulo;

	@FXML
	private TableColumn<Libro, String> colAutor;

	@FXML
	private TextField campoTitulo;

	@FXML
	private TextField campoAutor;

	private LibroDAO libroDAO = new LibroDAO();

	@FXML
	public void initialize() {
		colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		tablaLibros.setItems(libroDAO.getListaLibros());

		tablaLibros.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Libro>() {
			@Override
			public void changed(ObservableValue<? extends Libro> observable, Libro anterior, Libro seleccionado) {
				if (seleccionado != null) {
					campoTitulo.setText(seleccionado.getTitulo());
					campoAutor.setText(seleccionado.getAutor());

				}
			}
		});

	}

	@FXML
	public void insertarLibro() {
		String tiulo = campoTitulo.getText();
		String autor = campoAutor.getText();

		Libro nuevoLibro = new Libro(tiulo, autor);
		libroDAO.insertarLibro(nuevoLibro);
		limpiarFormulario();
	}

	@FXML
	public void borrarLibro() {

		Libro seleccionado = tablaLibros.getSelectionModel().getSelectedItem();

		if (seleccionado == null) {
			return;
		}
		libroDAO.borrarLibro(seleccionado);

	}

	@FXML
	public void modificarLibro() {
		Libro seleccionado = tablaLibros.getSelectionModel().getSelectedItem();

		if (seleccionado == null) {
			return;
		}
		
		String tiulo = campoTitulo.getText();
		String autor = campoAutor.getText();
		
		libroDAO.actualizarLibro(seleccionado, tiulo, autor);
		
		tablaLibros.refresh();
		
		limpiarFormulario();
		
		
	}

	private void limpiarFormulario() {
		campoTitulo.clear();
		campoAutor.clear();
	}
}
