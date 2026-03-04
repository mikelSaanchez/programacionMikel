package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Alumno {
	
	private int id;
	private String nombre;
	private String asignatura;
	private double [] Notas = new double[6];
	private int numNotas;
	
	
	public void pedirDatos(ArrayList<Alumno>alumnos) throws IOException{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(1000) + 1;
		} while (estaRepetido(alumnos, idGenerado));
		id = idGenerado;
		
		System.out.println("Introduce el nombre del alumno:");
		nombre = leer.readLine();
		System.out.println("Introduce la asignatura:");
		asignatura = leer.readLine();	
		System.out.println("El id del estudiante es: "+id);
	}

	public void amadirNota() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		if (numNotas >= Notas.length - 1)
			System.out.println("No se puede anadir mas notas a ese alumno");
		else {
			try {
				do {
					System.out.println("Introduce la nota " + (numNotas + 1) + " del alumno " + nombre);
					Notas[numNotas] = Integer.parseInt(leer.readLine());
					if (Notas[numNotas] < 0 || Notas[numNotas] > 10)
						System.out.println("La nota tiene que estar entre 1 y 10");
				} while (Notas[numNotas] < 0 || Notas[numNotas] > 10);
				numNotas++;
			} catch (NumberFormatException | IOException e) {
				System.out.println("Introduce una nota valida");

			}
		}
	}
	private boolean estaRepetido(ArrayList<Alumno> alumnos, int idGenerado) {

		for (int i = 0; i < (alumnos.size() - 1); i++) {

			if (alumnos.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	
	public void verCalificaciones() {
		
		double notaMin = 11;
		double notaMax= -1;
		
		if(numNotas>0) {
			System.out.println("Nostrando notas de "+nombre);
		for(int i = 0; i<numNotas;i++) {
			System.out.print(Notas[i]+" , ");
			if(Notas[i]<notaMin) {
				notaMin = Notas[i];
			}
			
			if(Notas[i]>notaMax) {
				notaMax= Notas[i];
			}
		}
		System.out.println("Nota maxima "+notaMax);
		System.out.println("Nota minima "+notaMin);
		}else {
			System.out.println("El alumno no tiene notas aun.");
		}
	}
	
	public void mostrarMedia() {	
		if(numNotas>0) {
			double media = 0 ;
			System.out.println("Nostrando media de "+nombre);
		for(int i = 0; i<numNotas;i++) {
			media+=Notas[i];
			}
		media = media/numNotas;
		System.out.println("La media es: "+media);
		}else {
			System.out.println("El alumno no tiene notas aun.");
		}
		
	}
	public double devolverMedia() {
		if(numNotas>0) {
			double media = 0 ;

		for(int i = 0; i<numNotas;i++) {
			media+=Notas[i];
			}
		return media;
		}else {
			return -1;
		}
	}
	public int getId() {
		return id;
	}

	public double[] getNotas() {
		return Notas;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumNotas() {
		return numNotas;
	}


	

}
