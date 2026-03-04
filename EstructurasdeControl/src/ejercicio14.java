import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio14 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Precio inicial por kilo:");
		double precioInicial= Double.parseDouble(leer.readLine());
		System.out.println("Tipo de uva (A/B):");
		char tipo = leer.readLine().charAt(0);
		System.out.println("Tamaño (1/2):");
		int tamaño = Integer.parseInt(leer.readLine());
		System.out.println("Kilos de uva:");
		double kilos= Double.parseDouble(leer.readLine());
		double precioFinal;
		if(tipo =='A') {
			if(tamaño == 1) {
				precioFinal=precioInicial+0.20;
				System.out.println("Precio base:"+precioInicial);
				System.out.println("Tipo:"+tipo+"tamaño "+tamaño+":+0.20");
				System.out.println("Precio final:"+precioFinal);
				System.out.println("Total por 100kg:"+(kilos*100));
			}else if(tamaño==2) {
				precioFinal=precioInicial+0.30;
				System.out.println("Precio base:"+precioInicial);
				System.out.println("Tipo:"+tipo+"tamaño "+tamaño+":+0.30");
				System.out.println("Precio final:"+precioFinal);
				System.out.println("Total por 100kg:"+(kilos*100));
			}
		}else if (tipo=='B') {
			if(tamaño==1) {
				precioFinal=precioInicial-0.30;
				System.out.println("Precio base:"+precioInicial);
				System.out.println("Tipo:"+tipo+"tamaño "+tamaño+":-0.30");
				System.out.println("Precio final:"+precioFinal);
				System.out.println("Total por 100kg:"+(kilos*100));
			}else if(tamaño==2) {
				precioFinal=precioInicial-0.50;
				System.out.println("Precio base:"+precioInicial);
				System.out.println("Tipo:"+tipo+"tamaño "+tamaño+":-0.50");
				System.out.println("Precio final:"+precioFinal);
				System.out.println("Total por 100kg:"+(kilos*100));
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
