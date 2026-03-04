import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ejercicio18 {
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
		Stack <String> navegador = new Stack<>();
		
		boolean salir = false;
		do {
		try {
		System.out.println();
		System.out.println("-------Navegador-------");
		System.out.println();
		System.out.println("1. Visitar nueva página (añadir URL a la pila)");
		System.out.println("2. Volver a página anterior (pop y mostrar)");
		System.out.println("3. Ver página actual sin retroceder (peek)");
		System.out.println("4. Mostrar todo el historial");
		System.out.println("5. Ir a página inicial (vaciar pila)");
		System.out.println("6. Contar páginas en el historial");
		System.out.println("7. Buscar si visitaste una URL específica (recorrer sin eliminar)");
		System.out.println("8. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(navegador);
		break;
		case 2:
			menu2(navegador);
		break;
		case 3:
			menu3(navegador);
		break;
		case 4:
			menu4(navegador);
		break;
		case 5:
			menu5(navegador);
		break;
		case 6:
			menu6(navegador);
		break;
		case 7:
			menu7(navegador);
		break;
		case 8:
			salir = true;
			System.out.println("¡Saliendo!");
		break;
			}
		}catch(IOException  | NumberFormatException e) {
			System.out.println("Introduce numero, no letras.");
		}
		}while(!salir);
	}
	public static void menu1(Stack<String> navegador) throws IOException {
		System.out.println("---Visitar nueva página---");
		
		System.out.println("Añada la pagina: ");
		String pagina = leerString();
		
		navegador.push(pagina);
	}
	public static void menu2(Stack<String> navegador) throws IOException {
		System.out.println("---Volver a página anterior---");
		
		System.out.println("El ultimo resultado es "+navegador.pop());
	}
	public static void menu3(Stack<String> navegador) throws IOException {
	System.out.println("--- Ver página actual sin retroceder---");
	
	System.out.println("El ultimo resultado es "+navegador.peek());
	}
	public static void menu4(Stack<String> navegador) throws IOException {
		System.out.println("--- Mostrar todo el historial ---");
		
		for(int i = 0; i < navegador.size();i++) {
			System.out.println(navegador.peek());
			}
		}
	public static void menu5(Stack<String> navegador) throws IOException {
		System.out.println("---  Ir a página inicial (vaciar pila) ---");
		
		navegador.removeAll(navegador);
		}
	public static void menu6(Stack<String> navegador) throws IOException {
		System.out.println("---  Contar páginas en el historial ---");
		
		System.out.println("Las paginas son"+navegador.size()); 	
		}
	public static void menu7(Stack<String> navegador) throws IOException {
		System.out.println("---  Buscar si visitaste una URL específica ---");
		
		System.out.println("Introduce URL");
		String url = leerString();
		for(String n : navegador) {
			if(url.equalsIgnoreCase(n) ) {
				System.out.println("Si que se ha visitado esa pagina.");
			}else {
				System.out.println("No se ha visitado esa  pagina.");
			}
		}
			
		}
}
