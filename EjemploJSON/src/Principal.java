import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Principal {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Alumno> lista = new ArrayList<>();
		lista.add(new Alumno("Juan", "García", 7.5));
		lista.add(new Alumno("María", "López", 9.0));
		lista.add(new Alumno("Pedro", "Martínez", 5.5));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		FileWriter fw = new FileWriter("alumnos.json");
		
		gson.toJson(lista,fw);
		fw.close();
		
		
		
		Gson gson1 = new Gson();
		Type tipo = new TypeToken<ArrayList<Alumno>> () {}.getType();

		try {
			FileReader fr = new FileReader("alumnos.json");
			ArrayList<Alumno> listaAlumnos = gson.fromJson(fr, tipo);
			for(Alumno a:listaAlumnos) {
				System.out.println(a.toString());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
