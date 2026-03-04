package ejerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio8 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
				boolean salir = false;
				System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
				do {
				//MOSTRAR MENU
				System.out.println("\n--- BIENVENIDO A TU BIBLIOTECA PERSONAL ---");
				System.out.println("1.Catalogar libro");
				System.out.println("2.  Sesión de lectura");
				System.out.println("3. Valorar saga completa");
				System.out.println("4. Recomendación aleatoria");
				System.out.println("5. Salir");
				System.out.print("Elige una opción: ");
				int opcion = Integer.parseInt(leer.readLine());
				switch (opcion) {
				case 1:
				System.out.println("Introduce el título del libro:");
				String titulo = leer.readLine();
				System.out.println("Introduce el número de páginas:");	
				int paginas =Integer.parseInt(leer.readLine());
				System.out.println("Introduce el año de publicación: ");
				String año =leer.readLine();
				System.out.println("Introduce el género::");	
				String genero =leer.readLine();
				
				genero= genero.toUpperCase();
				String añoDigito = año.substring(2);
				char letratitulo = titulo.toUpperCase().charAt(0);
				System.out.println("Su codgigo es: "+genero+añoDigito+letratitulo);
				
				int minutos = paginas *2;
				int hora = minutos/60;
				int minutosHora = minutos & 60;
				System.out.println("Los minutos que tardas son: "+minutos);
				System.out.println("Los horas que tardas son : "+hora+"minutos:"+minutosHora);
				break;
				case 2:
				System.out.println("=== SESIÓN DE LECTURA ===");
				System.out.println("¿Cuántos capítulos tiene el libro?");
				int numCapitulos = Integer.parseInt(leer.readLine());
				int numPaginaCapitulos = -1;
				int paginasTotales=0;
				int numeroCapitulosLeidos = 0;
				for (int i = 1; i<numCapitulos && numPaginaCapitulos !=0 ;i++ ) {
					System.out.println("Capítulo "+i+" Páginas leídas (0 para dejar de leer):");
					numPaginaCapitulos = Integer.parseInt(leer.readLine());
					paginasTotales+=numPaginaCapitulos;
					if(numPaginaCapitulos!=0) {
						numeroCapitulosLeidos++;
					}
				}
				System.out.println("Has completado "+numeroCapitulosLeidos+"capítulos");
				System.out.println("Te quedan estos capitulos "+(numCapitulos-numeroCapitulosLeidos));
				System.out.println("Has leido estas paginas:"+paginasTotales);
				break;
				case 3:
				System.out.println("=== VALORAR SAGA COMPLETA ===");
				System.out.println("Introduce el nombre de la saga:");
				String saga = leer.readLine();
				System.out.println("Introduce el número de libros de la saga:");	
				int librosSaga =Integer.parseInt(leer.readLine());
				System.out.println("Introduce el número de capitulos del libro:");	
				int capituloLibro =Integer.parseInt(leer.readLine());
				
				break;
				case 4:
				System.out.println("Opcion 4");
				//....
				break;
				case 5:
					salir = true;
					System.out.println("¡Hasta luego!");
					break;
					default:
					System.out.println("Opción no válida");
					}
					}while(!salir);
	}

}
