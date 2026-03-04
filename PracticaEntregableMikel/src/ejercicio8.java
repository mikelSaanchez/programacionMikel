import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio8 {
		public static int leerInt() throws NumberFormatException, IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(leer.readLine());
			return num;
		}
	public static void main(String[] args) {
		ArrayList <Integer> calificaciones = new ArrayList<>();
		int media = 0;
		boolean salir = false;
		do {
		try {
		System.out.println();
		System.out.println("-------Calificaciones-------");
		System.out.println();
		System.out.println("1. Añadir calificación (validar que esté entre 0 y 10)");
		System.out.println("2. Eliminar una calificación por posición");
		System.out.println("3. Mostrar todas las calificaciones");
		System.out.println("4. Calcular la media de las calificaciones");
		System.out.println("5. Mostrar cuántas calificaciones son aprobados (>=5)");
		System.out.println("6. Encontrar la calificación más alta y más baja");
		System.out.println("7. Contar cuántas calificaciones hay por encima de la media");
		System.out.println("8. Modificar una calificación (cambiar valor en una posición)");
		System.out.println("9. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(calificaciones);
		break;
		case 2:
			menu2(calificaciones);
		break;
		case 3:
			menu3(calificaciones);
		break;
		case 4:
			media = menu4(calificaciones);
		break;
		case 5:
			menu5(calificaciones);
		break;
		case 6:
			menu6(calificaciones);
		break;
		case 7:
			menu7(calificaciones, media);
		break;
		case 8:
			menu8(calificaciones);
		break;
		case 9:
			salir = true;
			System.out.println("¡Saliendo!");
		break;
			}
		}catch(IOException  | NumberFormatException e) {
			System.out.println("Introduce numero, no letras.");
		}
		}while(!salir);

	}
	public static void menu1(ArrayList<Integer> calificaciones) throws NumberFormatException, IOException {
		System.out.println("--- Añadir calificación ---");
		
		int nota;
		do {
		System.out.println("Añada una calificacion: ");
		 nota = leerInt();
		}while(nota<0||nota>10);
		
		calificaciones.add(nota);
	}
	public static void menu2(ArrayList<Integer> calificaciones) throws NumberFormatException, IOException {
		System.out.println("---  Eliminar una calificación por posición ---");
		
		System.out.println("Añada una posicion que quiera eliminar: ");
		int notposicionEliminar = leerInt();

		calificaciones.remove(notposicionEliminar);
	}
	public static void menu3(ArrayList<Integer> calificaciones) throws NumberFormatException, IOException {
		System.out.println("---  Mostrar todas las calificaciones ---");
		
		for(int n: calificaciones){
			System.out.println(n);
			}
	}
	public static int menu4(ArrayList<Integer> calificaciones) throws NumberFormatException, IOException {
		System.out.println("---  Calcular la media de las calificaciones ---");
		
		int sumaTotal = 0;
		for(int n: calificaciones){
			sumaTotal += n;
			}
		int media = sumaTotal/calificaciones.size();
		
		System.out.println("La media es: "+media);
		
		return media;
	}
	public static void menu5(ArrayList<Integer> calificaciones) throws NumberFormatException, IOException {
		System.out.println("---  Calcular la media de las calificaciones ---");
		
		
		for(int n: calificaciones){
			if(n >= 5) {
				System.out.println(n);
			}
		}
	}
	public static void menu6(ArrayList<Integer> calificaciones) throws NumberFormatException, IOException {
		System.out.println("---  Encontrar la calificación más alta y más baja ---");
		
		int calificacionAlta = 0;
		int calificacionBaja = 0;
		for(int n: calificaciones){
			
			if(n>calificacionAlta) {
				calificacionAlta=n;
			}
			if(n<calificacionBaja) {
				calificacionBaja=n;
			}
		}
		System.out.println("La calificacion mas alta es: "+calificacionAlta);
		System.out.println("La calificacion mas baja es: "+calificacionBaja);
	}
	public static void menu7(ArrayList<Integer> calificaciones, int media) throws NumberFormatException, IOException {
		System.out.println("---Contar cuántas calificaciones hay por encima de la media---");
		
		int contadorMedia = 0;
		for(int n: calificaciones){
			if (n>media) {
				contadorMedia++;
				}
			}
		System.out.println("Hay "+contadorMedia+" alumnos por encima de la media.");
	}
	public static void menu8(ArrayList<Integer> calificaciones) throws NumberFormatException, IOException {
		System.out.println("---Modificar una calificación---");
		int pos1 =-1;
		do {
		System.out.println("Posicion que quiera borrar: ");
		 pos1 = leerInt();
		}while(pos1<0 && pos1 > calificaciones.size());
		
		int pos2 =-1;
		do {
		System.out.println("Posicion que quiera borrar: ");
		pos2 = leerInt();
		}while(pos2<0 && pos2 > calificaciones.size());
		

		System.out.println(calificaciones);
		Collections.swap(calificaciones, pos1, pos2);
		System.out.println(calificaciones);
	}

}
