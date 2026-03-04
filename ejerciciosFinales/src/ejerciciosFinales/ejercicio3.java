package ejerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir= false;
		System.out.println("=== BIENVENIDO A LA CALCULADORA DE ENTRADAS DE CINE ===");
		
		int opcion;
		double saldoPrincipal= 0;
		do {
			System.out.println();
			System.out.println("--- BIENVENIDO A TU CUENTA BANCARIA ---");
			System.out.println("1. Ingresar dinero");
			System.out.println("2. Retirar dinero");
			System.out.println("3.  Consultar saldo actual");
			System.out.println("4.  Comprobar si puedes comprar videojuego (60€)");
			System.out.println("5. Simular ahorro mensual");
			System.out.println("6. Salir");
			System.out.print("Elige una opción: ");
			 opcion = Integer.parseInt(leer.readLine());
			 switch(opcion) {
				case 1:
					System.out.println("=== INGRESAR DINERO ===");
					System.out.println("Introduce la cantidad a ingresar:");
					double  cantidadNueva= Double.parseDouble(leer.readLine());
					System.out.println("Has ingresado:"+cantidadNueva);
					 saldoPrincipal =saldoPrincipal+cantidadNueva;
					System.out.println("Tu nuevo saldo es:"+saldoPrincipal);
					break;
				case 2:
					System.out.println("===  RETIRAR DINERO ===");
					System.out.println("Introduce la cantidad a retiras:");
					double  cantidadRetirar= Double.parseDouble(leer.readLine());
					System.out.println("Has retirado:"+cantidadRetirar);
					 saldoPrincipal =saldoPrincipal-cantidadRetirar;
					System.out.println("Tu nuevo saldo es:"+saldoPrincipal);
					break;
				case 3:
					System.out.println("===  CONSULTAR SALDO ===");
					System.out.println("Tu saldo actual es:"+saldoPrincipal);
					break;
				case 4:
					System.out.println("===  COMPRAR VIDEOJUEGO ===");
					if(saldoPrincipal<60) {
						System.out.println("No tienes suficiente dinero para el videojuego");
						System.out.println("Precio videojuego: 60.0€");
						System.out.println("Tu saldo:"+saldoPrincipal);
						double faltaVideojuego=60-saldoPrincipal;
						System.out.println("Te faltan:"+faltaVideojuego);
					}else {
						System.out.println("Tienes dinero para comprarlo :)");
					}
					break;
				case 5:
					System.out.println("===   SIMULAR AHORRO MENSUAL ===");
					System.out.println("¿Cuánto quieres ahorrar cada mes?");
					double ahorro1 = Double.parseDouble(leer.readLine());
					System.out.println("¿Para cuántos meses?");
					int meses = Integer.parseInt(leer.readLine());
					System.out.println("--- SIMULACIÓN DE AHORRO ---");
					double ahorro = saldoPrincipal;
					for(int i = 0 ; meses>i;i++) {
						ahorro= ahorro1+ ahorro;
						System.out.println("Mes "+(i+1)+":"+ahorro);
					}
					System.out.println("Resumen:");
					System.out.println("Saldo actual:"+saldoPrincipal);
					System.out.println("Total ahorrado en "+meses+" meses:"+(ahorro-saldoPrincipal));
					System.out.println("Saldo final proyectado:"+ahorro);
					break;
				case 6:
					System.out.println("Hasta luego!");
					salir = true;
			}
			}while(!salir);
	}

}
