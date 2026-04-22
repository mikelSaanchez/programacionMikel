package Modelo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlumnoDao {
	private ObservableList<Alumno> lista;

	public AlumnoDao() {
		lista = FXCollections.observableArrayList(cargarDesdeFichero());
	}

	public ObservableList<Alumno> getLista() {
		return lista;

	}

	public void añadirAlumno(Alumno alumnoAAñadir) {
		lista.add(alumnoAAñadir);
	}

	public void borrarAlumno(Alumno alumnoABorrar) {
		lista.remove(alumnoABorrar);
	}

	public void actualizarAlumno(Alumno alumno, String nombre, String apellido, double nota) {
		alumno.setNombre(nombre);
		alumno.setApellido(apellido);
		alumno.setNota(nota);
		guardarEnFichero();
	}

	private ArrayList<Alumno> cargarDesdeFichero() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		Gson gson = new Gson();
		Type tipo = new TypeToken<ArrayList<Alumno>>() {
		}.getType();
		File f = new File("alumnos. json");

		if (!f.exists())
			return alumnos;

		try {
			FileReader fr = new FileReader(f);
			alumnos = gson.fromJson(fr, tipo);
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
	}

	private void guardarEnFichero() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			FileWriter fw = new FileWriter("alumnos.json");
			gson.toJson(lista, fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
