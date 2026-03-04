import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio29 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int [][]matriz= new int [4][6];
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				System.out.println("Añade los numeros de la matriz: "+i+"x"+j);
				matriz[i][j]=Integer.parseInt(leer.readLine());
			}
		}
		int numMayor = 0;
		int posiscion = 0;
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				
				if(matriz[i][j]>numMayor) {
					numMayor = matriz[i][j];
					posiscion = j;
				} 
			}
		}
		System.out.println("El numero mayor es: "+numMayor);
		System.out.println("Esta en la columna: "+posiscion);
	}

}
