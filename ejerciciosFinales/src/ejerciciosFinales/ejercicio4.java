package ejerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir= false;
		System.out.println("=== BIENVENIDO AL GESTOR DE NOTAS DE EXAMEN ===");
		
		int opcion;
		double notaPrincipal= 0;
		do {
			System.out.println();
			System.out.println("---  MENÚ PRINCIPAL ---");
			System.out.println("1. Introducir nota del examen");
			System.out.println("2. Comprobar si está aprobado o suspenso");
			System.out.println("3. Calcular nota con extra de participación (+0.5)");
			System.out.println("4. Comparar nota con la media del grupo");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			 opcion = Integer.parseInt(leer.readLine());
			 switch(opcion) {
			 	case 1:
			 		System.out.println("=== INTRODUCIR NOTA ===");
					System.out.println("Introduce la nota del examen (0-10):");
					notaPrincipal = Double.parseDouble(leer.readLine());
					System.out.println("Nota registrada:"+notaPrincipal);
					break;
			 	case 2:
			 		System.out.println("=== COMPROBAR APROBADO/SUSPENSO ===");
					if(notaPrincipal<5) {
						System.out.println("Suspenso. Tu nota es:"+notaPrincipal);
					}else {
						System.out.println("Aprobado. Tu nota es:"+notaPrincipal);
					}
					break;
			 	case 3:
			 		System.out.println("=== CALCULAR CON EXTRA DE PARTICIPACIÓN ===");
			 		System.out.println("Nota original:"+notaPrincipal);
			 		System.out.println("Extra de participación: +0.5");
			 		if(notaPrincipal>=9.6) {
			 			System.out.println("No se puede sumar el 0.5 por que supera el 10.");
			 		}else {
			 			System.out.println("Nota final "+(notaPrincipal+0.5));
			 		}
					break;
			 	case 4:
			 		System.out.println("=== COMPARAR CON MEDIA DEL GRUPO ===");
			 		System.out.println("Introduce la media del grupo:");
					double notaGrupo = Double.parseDouble(leer.readLine());
					System.out.println("Tu nota es:"+notaPrincipal);
					System.out.println("Media del grupo:"+notaGrupo);
					if(notaGrupo>notaPrincipal) {
						System.out.println("Estás por debajo de la media");
						System.out.println("Diferencia:"+(notaPrincipal-notaGrupo));
					}
					
			 }
		}while(!salir);
	}

}
