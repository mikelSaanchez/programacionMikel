import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio45 {
	public static String leerString() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String palabra = leer.readLine();
		return palabra;
	}
		public static int leerInt() throws NumberFormatException, IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(leer.readLine());
			return num;
		}
	public static void main(String[] args) throws NumberFormatException, IOException {
		String [] autorLibro = new String [4];
		String [] tituloLibro = new String [3];
		int [][] prestado = new int [4][3];
		
		
		boolean salir = false;
		
		do {
			System.out.println();
		System.out.println("1. Rellenar los arrays de titulo y autor");
		System.out.println("2. Registrar prestamos.");
		System.out.println("3. Mostrar tabla.");
		System.out.println("4. Las editoriales quieren saber que libros son best-sellers.");
		System.out.println("5. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(autorLibro,tituloLibro,prestado);
		break;
		case 2:
			
		break;
		case 3:
			
		break;
		case 4:
			
		break;
		case 5:
			salir = true;
			System.out.println("¡Hasta luego!");
		break;
			}
		}while(!salir);
	}
	public static void menu1(String[] autorLibro, String[] tituloLibro, int[][] prestado) throws IOException {
		System.out.println("---Rellenar los arrays de titulo y autor---");
		for (int i = 0; i < autorLibro.length; i++) {
			do {
			System.out.println("Introduce el nombre del alumno "+(i+1)+" :");
			autorLibro[i] = leerString();
			if (autorLibro[i].isEmpty()) {
				System.out.println("El nombre del alumno no puede estar vacío.");
					}
			}while (autorLibro[i].isEmpty() );
			}
	}

}
