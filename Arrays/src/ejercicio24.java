import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio24 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int [][]matriz= new int [3][5];
		int contadorPositivos = 0;
		int contadorNegativos = 0;
		int contadorCero = 0;
		for(int i = 0; i< matriz.length;i++) {
			for(int j = 0;j< matriz[i].length;j++) {
				System.out.println("Añade los numeros de la matriz: "+i+"x"+j);
				matriz[i][j]=Integer.parseInt(leer.readLine());
				
				if(matriz[i][j]==0) {
					contadorCero++;
				}else if(matriz[i][j]<0) {
					contadorNegativos++;
				}else if(matriz[i][j]>0) {
					contadorPositivos++;
				}
			}
		}
		System.out.println("Numeros Positivos: "+contadorPositivos);
		System.out.println("Numeros Negativos: "+contadorNegativos);
		System.out.println("Ceros: "+contadorCero);
	}

}
