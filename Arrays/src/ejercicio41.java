import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio41 {
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
			
			String [] nombres = new String [6];
			int [][] notas = new int [6][5];
			String [] nombresAsig = new String [5];
			boolean salir = false;
			do {
				System.out.println();
			System.out.println("1. Introducir nombres de alumnos y asignaturas");
			System.out.println("2. Introducir todas las notas (validar 0-10)");
			System.out.println("3. Mostrar tabla completa (nombres de alumnos en filas, asignaturas en columnas)");
			System.out.println("4. Calcular y mostrar media de cada alumno con su nombre");
			System.out.println("5. Buscar alumno por nombre y mostrar todas sus notas");
			System.out.println("6. Mostrar la asignatura con menor media");
			System.out.println("7. Contar alumnos que tienen todas las asignaturas aprobadas");
			System.out.println("8. Mostrar qué alumnos suspendieron una asignatura específica (pedir asignatura)");
			System.out.println("9. Modificar nota (pedir nombre de alumno y asignatura)");
			System.out.println("10. Salir");
			System.out.println();
			System.out.print("Elige una opción: ");
			int opcion = leerInt();
			switch (opcion) {
			case 1:
				menu1(nombres,nombresAsig);
			break;
			case 2:
				menu2(nombres,nombresAsig, notas);
			break;
			case 3:
				menu3(nombres,nombresAsig, notas);
			break;
			case 4:
				menu4(nombres,nombresAsig, notas);
			break;
			case 5:
				menu5(nombres,nombresAsig, notas);
			break;
			case 6:
				menu6(nombres,nombresAsig, notas);
			break;
			case 7:
				menu7(nombres,nombresAsig, notas);
			break;
			case 8:
			
			break;
			case 9:
				
			break;
			case 10:
			salir = true;
				System.out.println("¡Hasta luego!");
			break;
				}
			}while(!salir);
	}
		public static void menu1(String [] nombre, String [] nombreAsig) throws IOException {
			
			for(int i = 0; i<nombre.length;i++) {
				System.out.println("Añade el nombre del alumno "+(i+1)+" :");
				nombre [i]= leerString();	
					}
			for(int i = 0; i<nombreAsig.length;i++) {
				System.out.println("Añade el nombre de la asignatura "+(i+1)+" :");
				nombreAsig [i]= leerString();	
				}
		}
		public static void menu2(String [] nombre, String [] nombreAsig, int[][] notas) throws IOException {
			
			for(int i = 0; i<notas.length;i++) {
				for(int j = 0; j<notas[i].length;j++) {
					System.out.println(i +" "+ j);
						System.out.println("Añada la nota de "+nombre[i]+" en "+nombreAsig[j]+":");
						notas[i][j]=leerInt();
					}	
				}
	}
		public static void menu3(String [] nombre, String [] nombreAsig, int[][] notas) {
			for(int i = 0; i<notas.length;i++) {
				for(int j = 0; j<notas[i].length;j++) {
					System.out.print(nombre[i]+"--"+notas[i][j]+"en "+nombreAsig[j]);
				}
				System.out.println();
				}
		}
		public static void menu4(String [] nombre, String [] nombreAsig, int[][] notas) {
			int [] mediaAlumno = new int [nombre.length];
			double mediaTotal =0;
			for(int i = 0; i<notas.length;i++) {
				for(int j = 0; j<notas[i].length;j++) {
					 mediaTotal+=notas[i][j];
				}
				mediaTotal = mediaTotal/notas[i].length;
				System.out.println("La media de "+nombre[i]+" es :"+mediaTotal);
			}
		}	
		public static void menu5(String [] nombre, String [] nombreAsig, int[][] notas) throws IOException {
			System.out.println("Introduce el nombre que quieras buscar: ");
			String nombreABuscar = leerString();
			
			for(int i = 0; i<nombre.length;i++) {
				
				if (nombre[i].equals(nombreABuscar)) {
					System.out.println("Las notas de "+nombreABuscar+" son:");
					for (int j = 0; i<nombreAsig.length;j++) {
						System.out.println(nombreAsig[j] +" " +notas[i][j]);
					}
				}
				
			}
		}
		public static void menu6(String [] nombre, String [] nombreAsig, int[][] notas) throws IOException {
		
			System.out.println("\n--- ASIGNATURA CON MENOR MEDIA ---\n");
			double menorMedia = -1;
			int posicion = -1;
				for (int i = 0; i < notas[0].length; i++) {
					double media = 0;
						for (int j = 0; j < notas.length; j++) {
							media += notas[j][i];
						}
					media /= notas.length;
					if (media < menorMedia) {
						menorMedia = media;
						posicion = i;
					}
					
					}
			System.out.println(nombreAsig[posicion] + ": " + menorMedia);
		}
		public static void menu7(String [] nombre, String [] nombreAsig, int[][] notas) throws IOException {
			int contadorAprobado = 0;
			int contadorSuspenso = 0;
			for(int i = 0; i<notas.length;i++) {
				for(int j = 0; j<notas[i].length;j++) {
					
					if(notas[i][j]>5) {
						contadorAprobado++;
					}else if (notas[i][j]<5){
						contadorSuspenso++;
					}
				}
			}
			System.out.println("Alumnos que lo tienen aprobado: "+contadorAprobado);
			System.out.println("Alumnos que lo tienen suspenso: "+contadorSuspenso);
		}
}
