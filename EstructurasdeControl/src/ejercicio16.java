import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio16 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el día:");
		int dia=Integer.parseInt(leer.readLine());
		System.out.println("Introduce el mes:");
		int mes=Integer.parseInt(leer.readLine());
		System.out.println("Introduce el año:");
		int año=Integer.parseInt(leer.readLine());
		
	if(año <=2025) {	
		if(mes>=1 && mes<=12) {	
			if(mes==2 && dia<28) {
				System.out.println("La fecha es valida");
			}else if (mes ==2 && dia>=28) {
				System.out.println("La fecha es invalida");
			}
			if((mes == 1 || mes ==3 || mes == 5 || mes== 7 || mes == 9|| mes == 11) && dia<31) {
				System.out.println("La fecha es valida");
			}else if((mes == 1 || mes ==3 || mes == 5 || mes== 7 || mes == 9|| mes == 11) && dia>=31) {
				System.out.println("La fecha es invalida");
			}
			if(mes == 4 || mes ==6 || mes == 8 || mes== 10 || mes == 12 && dia<30) {
				System.out.println("La fecha es valida");
			}else if((mes == 4 || mes ==6 || mes == 8 || mes== 10 || mes == 12) && dia>=30) {
				System.out.println("La fecha es invalida");
			}
		}else {
			System.out.println("La fecha es invalida");
				}	
	}else {
			System.out.println("La fecha es invalida");
		}
	
	}
	
}

