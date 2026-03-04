package ejerciciosAdicionalesEstructuras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nombre de la peli:");
		String peli = leer.readLine();
		System.out.println("Añada la edad:");
		int edad = Integer.parseInt(leer.readLine());
		
		
		boolean puedeVerla;
		
		if(edad>=18) {
			puedeVerla=true;
			System.out.println("Tiena mas de 18 años y puede verla:"+puedeVerla);
		}else if(edad>13 && edad<17) {
			System.out.println("Añada si tiene permiso del adulto:(S/N)");
			char permiso =leer.readLine().charAt(0);
			if(permiso=='s') {
				puedeVerla=true;
				System.out.println("Tiene entre 13 y 17 años, le ha firmado la autorizacion su papa puede verla:"+puedeVerla);
			}else if(permiso=='n') {
				puedeVerla=false;
				System.out.println("Tiene entre 13 y 17 años, le ha firmado la autorizacion su papa puede verla:"+puedeVerla);
			}
		}else if(edad<13) {
			puedeVerla=false;
			System.out.println("Tiene menos de 13 años y puede verla:"+puedeVerla);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
