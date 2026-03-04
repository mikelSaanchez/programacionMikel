import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int [] numero = new int [10];
		int contadorPositivo = 0;
		int contadorNegativo = 0;
		int contadorCero = 0;
		for(int i = 0 ; i< numero.length;i++) {
			System.out.println("Introduce el numero "+(i+1)+": " );
			numero[i]=Integer.parseInt(leer.readLine());
			
			if (numero[i] == 0) {
				contadorCero++;
			}else if(numero[i]> 0) {
				contadorPositivo++;
			}else {
				contadorNegativo++;
			}
		}
		System.out.println("Total numeros positivos: "+contadorPositivo);
		System.out.println("Total numeros negativos: "+contadorNegativo);
		System.out.println("Total numeros ceros: "+contadorCero);

	}

}
