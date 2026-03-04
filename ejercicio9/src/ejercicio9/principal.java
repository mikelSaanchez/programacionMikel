package ejercicio9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;	
		ArrayList<articulo>articulos = new ArrayList<articulo>();
		do {
		
		System.out.println();
		System.out.println("Opción 1: Añadir artículo:");
		System.out.println("Opción 2: Mostrar todos:");
		System.out.println("Opción 3:Buscar por código:");
		System.out.println("Opción 4: Vender artículo:");
		System.out.println("Opcion 5: Mostrar códigos pares:");
		System.out.println("Opcion 6: Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = Integer.parseInt(leer.readLine());
		switch (opcion) {
		case 1:
			añadirArticulo(articulos);
		break;
		case 2:
			mostrarDatos(articulos);
		break;
		case 3:
			codiagoAbuscar(articulos);
		break;
		case 4:
			venderArticulo(articulos);
		break;
		case 5:
		
		break;
		case 6:
			salir = true;
			System.out.println("Montoya, por favor");
			System.out.println("Nos vemos en la próxima edición");
		break;
			}
		}while(!salir);
	}
	public static void  añadirArticulo(ArrayList<articulo> articulos) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean parar = false;
		while (parar == false) {
			articulos.add(new articulo());
			articulos.getLast().pedirDatos(articulos);
			System.out.println("¿Desea introducir otro estudiante? (S/N)");
			char opcion1 = leer.readLine().toUpperCase().charAt(0);
			if (opcion1 == 'N') {
				parar = true;
			}
		}
	}
	public static void mostrarDatos(ArrayList<articulo> articulos) throws NumberFormatException, IOException {
		for(articulo e : articulos) {
			System.out.println(e.toString());
		}
	}
	public static int codiagoAbuscar(ArrayList<articulo> articulos) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean enc = false;
		System.out.println("Añada el codigo que quiera buscar: ");
		int codigoABuscar = Integer.parseInt(leer.readLine());
		for(int i = 0; i <articulos.size();i++) {
			if (articulos.get(i).getId() == codigoABuscar) {
				System.out.println(articulos.get(i).toString()); 
				enc = true;
				return articulos.get(i).getId();
			}
		}
		if(enc == false) {	
			System.out.println("Su id no se ha localizado.");
		}	
		return -1;
	}
		public static void venderArticulo(ArrayList<articulo> articulos) throws NumberFormatException, IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			codiagoAbuscar(articulos);
			
			System.out.println("Añada la cantidad que quiera vender:");
			int cantVender = Integer.parseInt(leer.readLine());
			int nuevoStock=0;
			boolean enc = true;
			for(int i = 0; i <articulos.size() && enc == false;i++ ) {
				
				if(articulos.get(i).realizarVenta(cantVender)== true && codiagoAbuscar(articulos) == articulos.get(i).getId()) {
					 nuevoStock = articulos.get(i).getStock()-cantVender;
					enc = false;
				}
			}
			System.out.println("EL nuevo stock de este producto es: "+nuevoStock);
		
	}
		

}
