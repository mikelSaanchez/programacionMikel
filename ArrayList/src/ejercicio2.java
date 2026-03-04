import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ejercicio2 {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String>nombres = new ArrayList<>();
		
		for(int i = 0;i<5;i++) {
			System.out.println("Añade el nombre "+(i+1)+" :");
			String n= leer.readLine();
			nombres.add(n);
		}
		for(String n: nombres) {
			System.out.print(n + " ");
		}
		System.out.println();
		System.out.println("Añada una posicion para eliminar: ");
		int pos = Integer.parseInt(leer.readLine());
		nombres.remove(pos);
		
		for(String n: nombres) {
			System.out.print(n + " ");
		}
	}

}
