import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ejercicio16 {
	public static String leerString() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String palabra = leer.readLine();
		return palabra;
	}
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
	public static void main(String[] args) {
		Stack <Integer> calculadora = new Stack<>();
		
		boolean salir = false;
		do {
		try {
		System.out.println();
		System.out.println("-------Calculadora-------");
		System.out.println();
		System.out.println("1. Realizar operación (pedir dos números y operación, guardar resultado en pila)");
		System.out.println("2. Ver último resultado (peek)");
		System.out.println("3. Recuperar y eliminar último resultado (pop)");
		System.out.println("4. Mostrar todo el historial (recorrer sin eliminar)");
		System.out.println("5. Limpiar historial");
		System.out.println("6. Mostrar cantidad de operaciones realizadas (size)");
		System.out.println("7. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(calculadora);
		break;
		case 2:
			menu2(calculadora);
		break;
		case 3:
			menu3(calculadora);
		break;
		case 4:
			menu4(calculadora);
		break;
		case 5:
			menu5(calculadora);
		break;
		case 6:
			menu6(calculadora);
		break;
		case 7:
			salir = true;
			System.out.println("¡Saliendo!");
		break;
			}
		}catch(IOException  | NumberFormatException e) {
			System.out.println("Introduce numero, no letras.");
		}
		}while(!salir);
	}
	public static void menu1(Stack<Integer> calculadora) throws IOException {
		System.out.println("--- Realizar operación---");
		
		System.out.println("Que operacion quiere realizar: ");
		char operacion = leerString().charAt(0);
		
		System.out.println("Introduce el numero 1:");
		int numero1 = leerInt();
		System.out.println("Introduce el numero 2:");
		int numero2 = leerInt();
		
		int resultado = -1;
		switch (operacion) {
		case '+': 
			resultado = numero1+numero2;
		break;
		case '-': 
			resultado = numero1-numero2;
		break;
		case '/': 
			resultado = numero1/numero2;
		break;	
		case '*': 
			resultado = numero1*numero2;
		break;
		
		}

		if(resultado != -1) {
			calculadora.push(resultado);
		}
	}

	public static void menu2(Stack<Integer> calculadora) {
		System.out.println("--- Ver último resultado---");
		
		System.out.println("El ultimo resultado es "+calculadora.peek());
	}
	public static void menu3(Stack<Integer> calculadora) {
		System.out.println("--- Recuperar y eliminar último resultado---");
		
		System.out.println("El ultimo resultado es "+calculadora.pop());
		
	}
	public static void menu4(Stack<Integer> calculadora) {
		System.out.println("--- Mostrar todo el historial ---");
		
		for(int i = 0; i < calculadora.size();i++) {
			System.out.println(calculadora.peek());
		}
		
	}
	public static void menu5(Stack<Integer> calculadora) {
		System.out.println("--- Limpiar historial---");
		
		calculadora.removeAllElements();
		
	}
	public static void menu6(Stack<Integer> calculadora) {
		System.out.println("--- Mostrar cantidad de operaciones realizadas---");
		
		System.out.println(calculadora.size()); 	
	}

}
