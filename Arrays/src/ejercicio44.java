import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio44 {
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
		String [] alumno = new String [4];
		String [] modulos = new String [5];
		int [][] faltas = new int [4][5];
		
		
		boolean salir = false;
		
		do {
			System.out.println();
		System.out.println("1. Rellenar los arrays de nombre y modulo");
		System.out.println("2. Registrar una falta");
		System.out.println("3. Mostrar tabla");
		System.out.println("4. 5 o más faltas supone perdida de evaluación continua");
		System.out.println("5. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(alumno,faltas,modulos);
		break;
		case 2:
			menu2(alumno,faltas,modulos);
		break;
		case 3:
			menu3(alumno,faltas,modulos);
		break;
		case 4:
			menu4(alumno,faltas,modulos);
		break;
		case 5:
			salir = true;
			System.out.println("¡Hasta luego!");
		break;
			}
		}while(!salir);

	}
	public static void menu1(String[] alumno, int[][] faltas, String[] modulos) throws IOException {
		
		System.out.println("---Rellanar nombre y modulos---");
		for (int i = 0; i < alumno.length; i++) {
		do {
		System.out.println("Introduce el nombre del alumno "+(i+1)+" :");
		alumno[i] = leerString();
		if (alumno[i].isEmpty()) {
			System.out.println("El nombre del alumno no puede estar vacío.");
				}
		}while (alumno[i].isEmpty() );
		}
		
		for (int i = 0; i < modulos.length; i++) {
			do {
			System.out.println("Introduce el nombre del modulo "+(i+1)+" :");
			modulos[i] = leerString();
			
			if (modulos[i].isEmpty()) {
				System.out.println("El nombre del alumno no puede estar vacío.");
					}
			}while (modulos[i].isEmpty() );
			
			}
		for(int f = 0; f<faltas.length;f++){
			for(int c = 0;c<faltas[f].length;c++) {
				faltas[f][c]=0;
			}
		}
		
	}
	public static void menu2(String[] alumno, int[][] faltas, String[] modulos) throws IOException {
		System.out.println("---Registrar una falta---");
		System.out.println();
		String nombresAlumno;
		System.out.println("Introduce el nombre del alumno: ");
		nombresAlumno = leerString();
		int indiceAlumno = -1;
		for (int i = 0; i < alumno.length; i++) {
			if(nombresAlumno.equalsIgnoreCase(alumno[i])) {
				indiceAlumno=i;
				System.out.println("Su alumno si que existe.");
			}
		}	
		if(indiceAlumno==-1) {
			System.out.println("Su alumno no existe.");
		}
		System.out.println("Introduce el modulo que quiera poner falta: ");
		String nombreModulo = leerString();
		int indiceModulo = -1;
		for (int i = 0; i < modulos.length; i++) {
			if(nombreModulo.equalsIgnoreCase(modulos[i])) {
				indiceModulo=i;
				}
		}
		if(indiceModulo==-1) {
			System.out.println("Su alumno no existe.");
		}
		
	if(indiceAlumno != -1 && indiceModulo != -1) {
		System.out.println("Introduce el numero de faltas que quiera poner: ");
		faltas[indiceAlumno][indiceModulo] = leerInt();
		System.out.println("Falta registrada correctamente");
		}else {
		System.out.println("No se ha pdido registrar la falta por que no se ha encontrado el alumno o el modulo");
		}
	}
	public static void menu3(String [] alumno, int[][] faltas, String[] modulos) {
		System.out.println("--- TABLA DE CLASIFICACIÓN ---");
		
		System.out.print("\t\t");
		for(int i=0; i<modulos.length; i++) {
			System.out.print(modulos[i] +"\t\t");
		}
		System.out.println("");
		for(int f=0; f<faltas.length; f++) {
			System.out.print(alumno[f] +"\t\t");
			for(int c=0; c<faltas[f].length; c++) {
				System.out.print(faltas[f][c] +"\t\t" );
				}
			System.out.println();
			}
		int posConMasFaltas = -1;
		int faltasMayor = -1;
		for(int f=0; f<faltas.length; f++) {
			int sumaFaltas= 0;
			for(int c=0; c<faltas[f].length; c++) {
				sumaFaltas += faltas[f][c];
					if(sumaFaltas > faltasMayor) {
						posConMasFaltas = f;
						faltasMayor = sumaFaltas;
				}
			}
		}
		int moduloMayor = -1;
		int posConModuloMasFaltas = -1;
		for(int c=0; c<faltas[0].length; c++) {
			int sumaFaltas = 0;
			for(int f=0; f<faltas.length; f++) {
				sumaFaltas += faltas[f][c];
				if(sumaFaltas > moduloMayor) {
					posConModuloMasFaltas = f;
					moduloMayor = sumaFaltas;
				}
			}
		}
		
		System.out.println("El modulo que más faltas tiene es " + modulos[posConModuloMasFaltas] + " con " 
                + moduloMayor);
		
	}
		public static void menu4(String [] alumno, int[][] faltas, String[] modulos) {
			System.out.println("---Perdida evaluacion continua---");
			boolean perdida = false;
			for(int f = 0; f<faltas.length;f++){
				for(int c = 0;c<faltas[f].length;c++) {
					if(faltas[f][c]>=5) {
						System. out.println("El alumno " + alumno[f] + "en la asignatura"+ modulos[c] + " ha perdido la evaluacion contunua pq tiene " +faltas[f][c] + "faltas");
						perdida = true;
					}
				}
			}
			if(perdida == false) {
				System.out.println("Nadie ha perdido la evaluacion continua. Aun");
			}
		}
	}




