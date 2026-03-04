import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int horas;
		System.out.println("Añada el numero de horas que trabaja:");
		horas=Integer.parseInt(leer.readLine());
		
		if(horas<=40) {
			double sueldo= horas*1000;
			System.out.println("Su sueldo es:"+sueldo);
		}else if(horas>40) {
			double horaExtra= horas - 40;
			double sueldo1= 40 *1000;
			double sueldoExtra = horaExtra* 1500;
			double sueldo3= sueldoExtra+sueldo1;
			System.out.println("Su sueldo extra es:"+sueldo3);
		}
		
		
		
	}

}
