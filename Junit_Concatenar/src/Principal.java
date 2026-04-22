import main.concatenar.Concatenar;

public class Principal {

	public static void main(String[] args) {
	
		String nombre = Lecturas.leerString("Introduce un nombre");
		String nombre1 = Lecturas.leerString("Introduce un segundo nombre");
		
		Concatenar cont = new Concatenar();
		
		System.out.println(cont.concatenar(nombre, nombre1));
	}

}
