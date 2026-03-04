import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio27 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int [][]matriz= new int [5][3];
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				System.out.println("Añade los numeros de la matriz: "+i+"x"+j);
				matriz[i][j]=Integer.parseInt(leer.readLine());
			}
		}
		
		int []suma= new int [matriz[0].length];
		for(int i = 0; i< matriz.length;i++) {	
			for(int j = 0;j< matriz[i].length;j++) {
				suma[j]+=matriz[i][j];
			}
		}
		for(int i = 0 ; i<suma.length;i++) {
			System.out.println("Columna "+(i+1)+": suma: "+suma[i]);
		}
	}

}
