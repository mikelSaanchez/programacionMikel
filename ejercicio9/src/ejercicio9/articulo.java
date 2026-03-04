package ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class articulo {
	private int id;
	private String nombre;
	private int precio;
	private int stock;
	
	public void pedirDatos( ArrayList<articulo> articulos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		int idGenerado = -1;
		do {
		 idGenerado = rand.nextInt(100)+1;
		}while(estaRepetido(articulos, idGenerado));
		id = idGenerado;
		
		System.out.println("Añada el nombre del artuculo que quiera añadir: ");
		 nombre = leer.readLine();
		System.out.println("Añada el precio del artuculo: ");
		 precio =Integer.parseInt(leer.readLine());
		System.out.println("Añada el stock del artuculo: ");
		 stock =Integer.parseInt(leer.readLine());
		
	}
	
	private boolean estaRepetido(ArrayList<articulo> articulos,int idGenerado) {
		
		for(int i=0;i<(articulos.size()-1);i++) {
			
			if(articulos.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}
	public boolean realizarVenta(int canVender) {
		if(stock >= canVender) {
			return true;
		}else {
			return false;
		}
	}
	public int getId() {
		return id;
	}
	public int getStock() {
		return stock;
	}
	public String toString() {
		return "articulo [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
}
