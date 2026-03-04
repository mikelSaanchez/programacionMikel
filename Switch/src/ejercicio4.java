import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1. Calcular área de un círculo");
		System.out.println("2. Calcular área de un cuadrado");
		System.out.println("3. Calcular área de un triángulo");
		System.out.println("4.Salir");
		int numero = Integer.parseInt(leer.readLine());
		
		switch(numero) {
		case 1:
			System.out.println("Añada el radio del circulo:");
			int radio = Integer.parseInt(leer.readLine());
			double radioCirculo = Math.PI*(radio*radio);
			System.out.println("El area del circulo es:"+radioCirculo);
		break;
		case 2:
			System.out.println("Añada el lado del cuadrado:");
			int lado = Integer.parseInt(leer.readLine());
			double areaCuadrado= lado*lado;
			System.out.println("El area del cuadrado es:"+areaCuadrado);
		break;
		case 3:
			System.out.println("Añada la base del triangulo:");
			int base = Integer.parseInt(leer.readLine());
			System.out.println("Añada la altura del triangulo:");
			int altura = Integer.parseInt(leer.readLine());
			double areaTriangulo = (base * altura)/2;
			System.out.println("El area del triangulo es:"+areaTriangulo);
		break;
		case 4:
			System.out.println("Saliendo");
		break;
		default:
			System.out.println("Opcion no valida");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
