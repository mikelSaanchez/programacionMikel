package ejerciciosAdicionalesEstructuras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Añada el precio:");
		int precio=Integer.parseInt(leer.readLine());
		System.out.println("Tiene la tarjeta de socio:S/N");
		char socio=leer.readLine().charAt(0);
		double descuento;
		double formula;
		if(precio<50) {
			if(socio=='s') {
				descuento =0.05;
				 formula=precio * descuento;
				System.out.println("Tiene un descuento del 5%,el descuento es de:"+formula);
			}else if(socio=='n') {
				System.out.println("No tiene descuento, su compra le cuesta:"+precio);
			}
		}else if(precio >50 && precio <100) {
			if(socio=='s') {
				descuento =0.15;
				 formula=precio * descuento;
				System.out.println("Tiene un descuento del 15%, el descuento es:"+formula);
			}else if(socio=='n') {
				descuento =0.10;
				 formula=precio * descuento;
				System.out.println("Tiene un descuento del 10%, el descuento es:"+formula);
		}else if(precio>100) {
			if(socio=='s') {
				descuento =0.20;
				 formula=precio * descuento;
				System.out.println("Tiene un descuento del 20%, el descuento es:"+formula);
			}else if(socio=='n') {
				descuento =0.15;
				 formula=precio * descuento;
				System.out.println("Tiene un descuento del 15%, el descuento es:"+formula);
				}	
		}
		}
	}
}
		
	



