import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio25 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int [][]matriz= new int [4][4];
		int contador= 0;
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				System.out.println("Añade los numeros de la matriz: "+i+"x"+j);
				matriz[i][j]=Integer.parseInt(leer.readLine());
			}
		}
		System.out.println("Numero a buscar: ");
		int numBuscar = Integer.parseInt(leer.readLine());
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				if(matriz[i][j]==numBuscar) {
					contador++;
					System.out.println("El numero esta en la posicion[ "+i+"x"+j+ " ]");
				}
			}
		
		}
		if(contador == 0 ) {
			System.out.println("Su numero no esta.");
		}else {
			System.out.println("Su numero a aparecido estas veces: "+contador);
		}
			
	}

}
