import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int numero1;
		int numero2;
		int numero3;
		System.out.println("Añada un numero");
		numero1=Integer.parseInt(leer.readLine());
		System.out.println("Añada un segundo numero");
		numero2=Integer.parseInt(leer.readLine());
		System.out.println("Añada un tercer numero");
		numero3=Integer.parseInt(leer.readLine());
		if(numero1<numero2 && numero2<numero3) {
			System.out.println("numero tres es mayor");
		}else if(numero1>numero2 && numero3<numero1) {
			System.out.println("numero uno es mayor");
		}else {
			System.out.println("numero dos es mayor");
		}
	}

}
