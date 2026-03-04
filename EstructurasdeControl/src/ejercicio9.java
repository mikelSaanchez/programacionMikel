import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio9 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada el saldo de su cuenta:");
		long saldo=Long.parseLong(leer.readLine());
		if(saldo<100000) {
			double interes1= saldo *0.05;
			System.out.println("1:"+interes1);
		}else if(saldo>1000001 && saldo<2000000) {
			double interes2= saldo*0.07;
			System.out.println("2:"+interes2);
		}else if(saldo>2000001 && saldo<5000000) {
			double interes3=saldo*0.08;
			System.out.println("3:"+interes3);
		}else {
			double interes4 = saldo *0.08;
			System.out.println("4:"+interes4);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
