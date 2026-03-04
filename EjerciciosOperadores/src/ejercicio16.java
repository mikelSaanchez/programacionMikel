import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio16 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada el destino de su viaje:");
		String destino = leer.readLine();
		System.out.println("Añada la distancia hasta su destino:");
		float distancia = Float.parseFloat(leer.readLine());
		System.out.println("Añada el consumo de su coche:");
		float consumo = Float.parseFloat(leer.readLine());
		System.out.println("Añada el precio dle combustible:");
		float precioCombustible =Float.parseFloat(leer.readLine());
		
		double litros=  (consumo/100)*distancia;
		double tiempoEstimado=distancia/90;
		double costeCombustible= (distancia/consumo)*precioCombustible;
		double costeKm=distancia/costeCombustible;
		System.out.println("Los litros necesarios son:"+litros);
		System.out.println("El coste de combustuble es:"+ costeCombustible);
		System.out.println("El tiempo estimado es:"+tiempoEstimado);
		System.out.println("El coste por km:"+costeKm);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
