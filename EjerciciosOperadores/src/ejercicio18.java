import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio18 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nombre del primer producto:");
		String nombre1= leer.readLine();
		System.out.println("Nombre del segundo producto:");
		String nombre2= leer.readLine();
		System.out.println("Nombre del terecer producto:");
		String nombre3= leer.readLine();
		System.out.println("Precio del primer producto:");
		float precio1= Float.parseFloat(leer.readLine());
		System.out.println("Precio del segundo producto:");
		float precio2= Float.parseFloat(leer.readLine());
		System.out.println("Precio del tercer producto:");
		float precio3= Float.parseFloat(leer.readLine());
		System.out.println("Descuento que quieras aplicar:");
		float descuento= Float.parseFloat(leer.readLine());
	
		double sumaPrecios = precio1 + precio2 + precio3;
		double descuentoPrecios= sumaPrecios*(descuento/100); 
		double iva = sumaPrecios*0.21;
		double total = (sumaPrecios-descuentoPrecios)+ iva;
		System.out.println("El total de la compra es:" + total );
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
