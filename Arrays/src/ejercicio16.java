import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio16 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añade el numero del array: ");
		int numeroArray = Integer.parseInt(leer.readLine());
		int [] numero = new int [numeroArray];
		
		for(int i = 0; i<numero.length;i++) {
			numero[i]=(int) ((Math.random()*100)+1);
		}
		boolean salir = false;
		do {
			System.out.println();
			System.out.println("1. Recorrer el array y mostrar sus valores en la consola");
			System.out.println("2. Sumar los elementos del array");
			System.out.println("3. Encontrar el numero maximo");
			System.out.println("4. Calcular la media");
			System.out.println("5. Buscar un elemento");
			System.out.println("6. Contar las veces que aparece un numero en el array");
			System.out.println("7. Invertir el array (y luego imprimirlo)");
			System.out.println("8. Crear un nuevo array pidiendo los valores al usuario y comparando si alguno de sus valores son iguales al primero");
			System.out.println("9. Salir");
			System.out.println();
			System.out.print("Elige una opción: ");
			int opcion =Integer.parseInt(leer.readLine());
			int contador = 0;
			switch (opcion) {
			case 1: 
				for(int i = 0; i<numero.length;i++) {
					System.out.print(numero[i]+" ");
				}
				break;
			case 2:
				
				for(int i = 0; i<numero.length;i++) {
				contador +=numero[i];	
			}
				System.out.println("La suma de los numeros es: "+contador);
				break;
			case 3:
				int numMayor = numero[0];
				for(int i = 0; i<numero.length;i++) {
					if(numero[i] > numMayor) {
						numMayor = numero[i];
					}
				}
				System.out.println("EL numero mayor es: "+numMayor);
				break;
			case 4:
				int mediaTotal = 0;
				for(int i = 0; i<numero.length;i++) {
					contador+=numero[i];
					mediaTotal = contador/numeroArray;
				}
				System.out.println("La media es: "+mediaTotal);
				break;
			case 5:
				System.out.println("Introduce el numero que quieras buscar: ");
				int buscarNumero = Integer.parseInt(leer.readLine());
				boolean encontrado = false;
				for(int i = 0; i<numero.length;i++) {
					if(buscarNumero == numero[i]) {
						encontrado = true;
						System.out.println("Su numero esta en la posicion: "+i);
					}
				}
				if(encontrado == false) {
					System.out.println("Su numero no esta.");
			
				}
				break;
			case 6:
				System.out.println("Introduce el numero que quieras buscar: ");
				 buscarNumero = Integer.parseInt(leer.readLine());
				 encontrado = false;
				 int contadorNumero =0;
				for(int i = 0; i<numero.length;i++) {
					if(buscarNumero == numero[i]) {
						encontrado = true;
						contadorNumero++;
					}
				}
				if(encontrado = true) {
					System.out.println("Su numero se ha repetido: "+contadorNumero+" veces.");
				}else {
					System.out.println("Su numero no esta.");
				}
				break;
			case 7:
				int temporal = 0;
				for(int i = 0; i<numero.length/2;i++) {
					temporal=numero[i];
					
					numero[i] = numero[numero.length-i-1];
					
					numero[numero.length-i-1]=temporal;
					
				
				}
				for(int i =0;i<numero.length;i++) {
					System.out.print(numero[i]+ " ");
				}
				
				
				break;
			case 8:
				
			
				int [] numero1 = new int [numeroArray];
				
				for(int i = 0; i<numero1.length;i++) {
					System.out.println("Añade el numero del array: ");
					int numeroArray1 = Integer.parseInt(leer.readLine());
				}
				
				boolean contadorNumero1 =false;
				
				for(int i = 0; i<numero.length;i++) {
						if(numero1[i] == numero[i]) {
							contadorNumero1=true;
					}
				}
				if(contadorNumero1 = true) {
					System.out.println("Si que coincide algun numero del array primero con el creado actual.");
				}else {
					System.out.println("No coincide nungun numero de los arrays.");
				}
				
				break;
			case 9:
				salir = true;
				break;
			}
		}while(!salir);
	}

}
