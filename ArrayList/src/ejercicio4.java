import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio4 {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String>nombres = new ArrayList<>();
		
		for(int i = 0;i<5;i++) {
			System.out.println("Añade el nombre "+(i+1)+" :");
			String n= leer.readLine();
			nombres.add(n);
		}
		System.out.print(nombres);
		
		Collections.sort(nombres);
		
		System.out.print(nombres);
		
	}

}
