package ejerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir= false;
		System.out.println("=== BIENVENIDO A GESTIÓN DE VENTAS ===");
		
		int opcion;
		do {
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Calcular IVA (21%)");
			System.out.println("2. Calcular descuento por comprar más de 3 figuras (10%)");
			System.out.println("3. Calcular cuánto falta para envío gratis (50€)");
			System.out.println("4. Mostrar tabla de precios (1-10 unidades)");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			 opcion = Integer.parseInt(leer.readLine());
			
			switch(opcion) {
			case 1: 
				System.out.println("=== CALCULAR IVA ===");
				System.out.println("Introduce el precio del producto:");
				double precio= Double.parseDouble(leer.readLine());
				System.out.println("Precio sin IVA:"+precio);
				double iva = precio *0.21;
				System.out.println("IVA (21%): "+iva+"€");
				double precioFinal = precio + iva;
				System.out.println("Precio final con IVA: "+precioFinal+"€");
				break;
			case 2:
				System.out.println("=== CALCULAR DESCUENTO POR FIGURAS ===");
				System.out.println("Introduce el número de figuras:");
				int numeroFiguras= Integer.parseInt(leer.readLine());
				System.out.println("Introduce el precio total:");
				int precioFigura= Integer.parseInt(leer.readLine());
				
				if(numeroFiguras<3) {
					System.out.println("No se aplica descuento (necesitas más de 3 figuras)");
				}else {
					System.out.println("¡Descuento aplicado!");
					System.out.println("Precio original: "+precioFigura);
					double descuentoFigura = precioFigura*0.10;
					System.out.println("Descuento (10%): "+descuentoFigura);
					double precioFinal1 = precioFigura-descuentoFigura;
					System.out.println("Precio final:"+precioFinal1+"€");
				}
				break;
			case 3:
				System.out.println("=== CALCULAR ENVÍO GRATIS ===");
				System.out.println("Introduce el precio total:");
				int precio3= Integer.parseInt(leer.readLine());
				
				if(precio3>=50) {
					System.out.println("¡Felicidades! Tu pedido tiene envío gratis.");
				}else if(precio3<50) {
					double precioRestante = 50-precio3;
					System.out.println("Te faltan "+ precioRestante+" para conseguir envío gratis");
				}
				break;
			case 4:
				System.out.println("=== TABLA DE PRECIOS ===");
				System.out.println("Introduce el precio unitario:");
				double precioUnitario= Double.parseDouble(leer.readLine());
				System.out.println("--- Tabla de precios (sin IVA) ---");
				double precioTotalIva=0;
				double sumaPrecio;
				for(int i = 0; i<10;i++) {
					double precioIva = precioUnitario *0.21;
					precioTotalIva = precioIva +precioUnitario;
					sumaPrecio= precioUnitario*i;
					System.out.println(i+" unidades:"+sumaPrecio+"€(con IVA: "+precioTotalIva+"€)");
				}
				break;
			case 5:
				System.out.println("¡Hasta luego!");
				salir= true;
			}
		}while(!salir);	
		
		
	}
}
