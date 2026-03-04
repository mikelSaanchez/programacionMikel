package ejerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir= false;
		System.out.println("=== BIENVENIDO A LA CALCULADORA DE ENTRADAS DE CINE ===");
		
		int opcion;
		do {
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Calcular precio según edad");
			System.out.println("2. Calcular precio con descuento de miércoles (50%)");
			System.out.println("3.  Calcular precio con combo palomitas + refresco (+5€)");
			System.out.println("4.  Calcular precio para grupo de personas");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			 opcion = Integer.parseInt(leer.readLine());
			switch(opcion) {
				case 1:
					System.out.println("=== CALCULAR PRECIO POR EDAD ===");
					System.out.print("Introduce tu edad: ");
					int edad  = Integer.parseInt(leer.readLine());
					
					if(edad<16) {
						System.out.println("Categoría: niño");
						System.out.println("Precio de la entrada: 5.0€");
					}else if(edad>16 && edad < 65) {
						System.out.println("Categoría: adulto");
						System.out.println("Precio de la entrada: 8.0€");
					}else {
						System.out.println("Categoría: jubilado");
						System.out.println("Precio de la entrada: 6.0€");
							}
					break;
				case 2:
					System.out.println("=== DESCUENTO DE MIÉRCOLES ===");
					System.out.print("Introduce el precio normal de la entrada: ");
					int precio  = Integer.parseInt(leer.readLine());
					System.out.println("Precio normal:"+precio);
					double precioMiercoles = precio/2;
					System.out.println("Descuento del miércoles (50%):"+precioMiercoles);
					break;
				case 3:
					System.out.println("=== COMBO PALOMITAS + REFRESCO ===");
					System.out.print("Introduce el precio normal de la entrada: ");
					int precio1  = Integer.parseInt(leer.readLine());
					System.out.println("Precio entrada:"+precio1);
					System.out.print("Combo palomitas + refresco: 5.0€: ");
					double precioTotal = precio1+5;
					System.out.print("Precio tota: "+precioTotal);
					break;
				case 4:
					System.out.println("=== CALCULAR PRECIO PARA GRUPO ===");
					System.out.print("¿Cuántas personas van al cine?: ");
					int personas  = Integer.parseInt(leer.readLine());
					double totalPrecio = 0;
					for(int i = 1; i <= personas; i++) {
						System.out.println("Edad de la persona "+i+":");
						int contador  = Integer.parseInt(leer.readLine());
						
						if(contador<16) {
							System.out.println("Persona "+i+" (niño): 5.0€");
							totalPrecio=totalPrecio+5;
						}else if(contador>16 && contador < 65) {
							System.out.println("Persona "+i+" (adulto): 8.0€");
							totalPrecio=totalPrecio+8;
						}else {
							System.out.println("Persona "+i+" (jubilado): 6.0€");
							totalPrecio=totalPrecio+6;
								}
					}
					System.out.println("--- RESUMEN DEL GRUPO ---");
					System.out.println("Total de personas:"+personas);
					System.out.println("Precio total:"+totalPrecio);
					break;
				case 5:
					salir= true;
			}
		
		}while(!salir);
			
				System.out.println("Hasta luego!");
		}
}

	

