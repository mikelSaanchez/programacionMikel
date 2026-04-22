package Controlador;

import Modelo.Alumno;
import Modelo.AlumnoDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controlador {

	@FXML
	private TableColumn<Alumno, String> colNombre;

	@FXML
	private TableColumn<Alumno, String> colApellido;

	@FXML
	private TableColumn<Alumno, Double> colNota;

	@FXML
	private TableView<Alumno> tablaAlumnos;

	@FXML
	private TextField campoNombre;

	@FXML
	private TextField campoApellido;

	@FXML
	private TextField campoNota;

	// 1. Creamos un objeto de la clase AlumnoDAO
	private AlumnoDao AlumnoDao = new AlumnoDao();

	@FXML
	public void initialize() {
		// Decimos a cada columna que atributo del modelo mostrar
		colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		colNota.setCellValueFactory(new PropertyValueFactory<>("nota"));

		tablaAlumnos.setItems(AlumnoDao.getLista());

		tablaAlumnos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Alumno>() {
			@Override
			public void changed(ObservableValue<? extends Alumno> observable, Alumno anterior, Alumno seleccionado) {
				if (seleccionado != null) {
					campoNombre.setText(seleccionado.getNombre());
					campoApellido.setText(seleccionado.getApellido());
					campoNota.setText(String.valueOf(seleccionado.getNota()));
				}
			}
		});
	}

	// METOOD DE PRUEBA PARA AÑADIR UN ALUMNO
	@FXML
	public void añadirAlumno() {
		// Recuperamos los datos de los textfield
		String nombre = campoNombre.getText();
		String apellido = campoApellido.getText();
		double nota = Double.parseDouble(campoNota.getText());

		Alumno nuevo = new Alumno(nombre, apellido, nota);
		AlumnoDao.añadirAlumno(nuevo);

		limpiarFormulario();

	}

	@FXML
	public void controladorBorrar() {
		// Obtenemos el alumno seleccionado en la tabla
		Alumno seleccionado = tablaAlumnos.getSelectionModel().getSelectedItem();

		if (seleccionado != null) {
			AlumnoDao.borrarAlumno(seleccionado);
		}
	}

	@FXML
	public void modificarAlumno() {
		Alumno seleccionado = tablaAlumnos.getSelectionModel().getSelectedItem();

		if (seleccionado == null) {
			return;
		}

		// Recuperamos los datos de los textfield
		String nombre = campoNombre.getText();
		String apellido = campoApellido.getText();
		double nota = Double.parseDouble(campoNota.getText());
		
		
		AlumnoDao.actualizarAlumno(seleccionado, nombre, apellido, nota);

		tablaAlumnos.refresh();
		
		limpiarFormulario();
	}

	private void limpiarFormulario() {
		// Con clear se borra lo que el usuario haya introducido en
		campoNombre.clear();
		campoApellido.clear();
		campoNota.clear();
	}

}
