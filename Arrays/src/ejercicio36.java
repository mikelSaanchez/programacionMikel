import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio36 {
	public static char leerChar() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		char palabra = leer.readLine().toUpperCase().charAt(0);
		return palabra;
	}
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		char [][]butacas= new char [6][8];
		
		for(int i = 0; i< butacas.length;i++) {
			for(int j = 0;j< butacas[i].length;j++) {
				butacas[i][j]='L';
			}
		}

		boolean salir = false;
		do {
			System.out.println();
		System.out.println("1. Mostrar mapa de asientos (usar 'L'=libre, 'X'=ocupado en formato visual)");
		System.out.println("2. Reservar asiento (pedir fila y asiento, validar que esté libre)");
		System.out.println("3. Cancelar reserva (pedir fila y asiento, validar que esté ocupado)");
		System.out.println("4. Contar asientos libres y ocupados");
		System.out.println("5. Mostrar qué fila tiene más asientos libres");
		System.out.println("6. Comprobar si una fila específica está completamente llena");
		System.out.println("7. Mostrar porcentaje de ocupación del cine");
		System.out.println("8. Reiniciar sala (todos libres)");
		System.out.println("9. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(butacas);
		break;
		case 2:
			menu2(butacas);
		break;
		case 3:
			menu3(butacas);
		break;
		case 4:
			menu4(butacas);
		break;
		case 5:
			menu5(butacas);
		break;
		case 6:
		
		break;
		case 7:
			
		break;
		case 8:
		
		break;
		case 9:
			salir = true;
			System.out.println("¡Hasta luego!");
		break;
			}
		}while(!salir);
	}
	public static void menu1(char butacas[][]) {
		for(int i = 0; i< butacas.length;i++) {
			for(int j = 0;j< butacas[i].length;j++) {
				System.out.print(butacas [i][j]+" ");
				}
			System.out.println();
		}
	}
	public static void menu2(char butacas[][]) throws NumberFormatException, IOException {
		System.out.println("Añade fila: ");
		int fila=leerInt();
		System.out.println("Añade columna: ");
		int columna=leerInt();
		boolean encontrado = false;
		for(int i = 0; i< butacas.length;i++) {
			for(int j = 0;j< butacas[i].length;j++) {
				if(i==fila && j==columna) {
					if(butacas[i][j]=='L') {
						butacas[i][j]='X';
						encontrado = true;
						System.out.println("Asiento reservado.");
					}else {
						System.out.println("Asiento ocupado.");
					}
				}
			}
		}	
		if(encontrado == false) {
				System.out.println("Su asiento no existe.");
			}
	}
	public static void menu3(char butacas[][]) throws NumberFormatException, IOException {
		System.out.println("Añade fila: ");
		int fila=leerInt();
		System.out.println("Añade columna: ");
		int columna=leerInt();
		boolean encontrado = false;
		for(int i = 0; i< butacas.length;i++) {
			for(int j = 0;j< butacas[i].length;j++) {
				if(i==fila && j==columna) {
					if(butacas[i][j]=='X') {
						butacas[i][j]='L';
						encontrado = true;
						System.out.println("Reserva cancelada.");
					}else {
						System.out.println("Asiento Libre.");
					}
				}
			}
		}	
		if(encontrado == false) {
				System.out.println("Su asiento no existe.");
			}
	}
	public static void menu4(char butacas[][]) {
		int contadorL = 0;
		int contadorX = 0;
		for(int i = 0; i< butacas.length;i++) {
			for(int j = 0;j< butacas[i].length;j++) {
				
				if(butacas[i][j]=='L') {
					contadorL++;
				}else if(butacas[i][j]=='X'){
					contadorX++;
				}
			}
		}
		System.out.println("Total asientos libres: "+contadorL);
		System.out.println("Total asientos ocupados: "+contadorX);
	}
	public static void menu5(char butacas[][]) {
		
		int[]total = new int[butacas[0].length];
		int contadorLibre = 0;
		
		for(int i = 0; i< butacas.length;i++) {
			for(int j = 0;j< butacas[i].length;j++) {
			
				if(butacas[i][j]=='L') {
				total[i]+=butacas[i][j];
			}
			}
		}
		System.out.println("La fila que tiene mas asientos es: ");
	}
	public static void menu6(char butacas[][]) throws NumberFormatException, IOException {
		System.out.println("la fila que quieres comprobar es: ");
		int comprobar =leerInt();
		for(int i = 0; i< butacas.length;i++) {
			for(int j = 0;j< butacas[i].length;j++) {
				
			}
		}
	}
}

	


