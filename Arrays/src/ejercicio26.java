import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio26 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int [][]matriz= new int [4][5];
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				System.out.println("Añade los numeros de la matriz: "+i+"x"+j);
				matriz[i][j]=Integer.parseInt(leer.readLine());
			}
		}
		int suma= 0;
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				suma+=matriz[i][j];
			}
			System.out.println("Fila "+i+": suma: "+suma);	
			suma=0;
		}
		
	}
	

}
