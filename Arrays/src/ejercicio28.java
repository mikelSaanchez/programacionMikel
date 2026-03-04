import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio28 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int [][]matriz= new int [5][5];
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				System.out.println("Añade los numeros de la matriz: "+i+"x"+j);
				matriz[i][j]=Integer.parseInt(leer.readLine());
			}
		}
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				
				if(i==j) {
					System.out.print(matriz[i][j]+" ");
				}
			}
		}
	}
}
