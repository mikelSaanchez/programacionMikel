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

public class LibroDAO {

	private ObservableList<Libro> listaLibros;

	public LibroDAO() {
		listaLibros = FXCollections.observableArrayList(cargarfichero());
	}

	public ObservableList<Libro> getListaLibros() {
		return listaLibros;
	}
	
	public void insertarLibro(Libro Libro) {
		listaLibros.add(Libro);
		guardar();
	}
	
	public void borrarLibro(Libro Libro) {
		listaLibros.remove(Libro);
		guardar();
	}
	
	public void actualizarLibro(Libro Libro,String titulo,String autor) {
		
		Libro.setTitulo(titulo);
		Libro.setAutor(autor);
		guardar();
	}
	
	

	// Metodos auxiliares de leer y escribir
	private ArrayList<Libro> cargarfichero() {

		ArrayList<Libro> libros = new ArrayList<>();

		File f = new File("libros.json");

		if (!f.exists()) {
			return libros;
		}

		Gson gson = new Gson();
		Type tipo = new TypeToken<ArrayList<Libro>>() {}.getType();
		FileReader fr;
		try {

			fr = new FileReader(f);
			libros = gson.fromJson(fr, tipo);
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return libros;
	}

	// Guardar datos Ficheros

	private void guardar() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			FileWriter fw = new FileWriter("libros.json");
			gson.toJson(listaLibros, fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
