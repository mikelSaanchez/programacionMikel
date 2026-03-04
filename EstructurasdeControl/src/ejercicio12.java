import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio12 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int mes;
		int dia;
		System.out.println("Añada el mes de su nacimiento(Del uno al doce):");
		mes = Integer.parseInt(leer.readLine());
		System.out.println("Añada el dia que ha nacido:");
		dia=Integer.parseInt(leer.readLine());
		
		if(mes ==3 ) {
			if(dia >21) {
				System.out.println("Eres Aries");
			}else {
				System.out.println("Eres piscis");
			}
			
		}else if(mes == 4){
			if(dia<19) {
				System.out.println("Eres Aries");
			}else {
				System.out.println("Eres Tauro");
			}
		}else if(mes ==5) {
			if(dia>21) {
				System.out.println("Eres Geminis");
			}else {
				System.out.println("Eres Tauro");
			}
		}else if(mes==6) {
			if(dia<20) {
				System.out.println("Eres Geminis");
			}else {
				System.out.println("Eres Cancer");
			}
		}
	}

}
