package sanchezRomeroMikel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		do {
		System.out.println();
		System.out.println("=== CREADOR DE PERFIL DE USUARIO ===");
		System.out.println("Opción 1: Creador de perfil de usuario");
		System.out.println("Opción 2: Maratón de series ");
		System.out.println("Opción 3: Calificar series y capítulos");
		System.out.println("Opción 4: Sistema de recomendaciones");
		System.out.println("Opción 5: Salir");
		System.out.print("Elige una opción: ");
		int opcion = Integer.parseInt(leer.readLine());
		switch (opcion) {
		case 1:
			System.out.println("Introduce tu nombre:");
			String nombre = leer.readLine();
			System.out.println("Introduce tu género favorito:");
			String generoFavorito = leer.readLine();
			System.out.println("Introduce tu edad:");
			int edad = Integer.parseInt(leer.readLine());
			System.out.println("Introduce el precio base mensual:");
			int precio = Integer.parseInt(leer.readLine());
			System.out.println("Introduce el número de perfiles:");
			int numeroPerfil = Integer.parseInt(leer.readLine());
			System.out.println("¿Quieres calidad 4K? (S/N):");
			char calidad = leer.readLine().toUpperCase().charAt(0);
			
			System.out.println("--- PERFIL CREADO ---");
			
			//ID
			
			String nombre1 = nombre.toUpperCase().substring(0,3);
			String genero1 = generoFavorito.toLowerCase().substring(0,2);
			System.out.println("ID de usuario: "+nombre1+genero1+edad);
			//Precio Mensual
			
			double precioMensual = 0;
			double descuento = 0.10;
			double precio1= precio+(3*numeroPerfil);
			if(calidad=='S') {
				if(numeroPerfil>5) {
				precioMensual=(precio1+5)*descuento;
				}else {
					precioMensual=precio1+5;
				}
			}else if(numeroPerfil>5) {
				precioMensual=precio1*descuento;
			}else {
				precioMensual=precio1;
			}			
			System.out.println("Precio mensual: "+precioMensual);
			// Contenido
			
			if(edad<7) {
				System.out.println("Tipo de contenido: Infantil");
			}else if(edad>8 && edad<12) {
				System.out.println("Tipo de contenido: Familiar");
			}else if(edad>13 && edad<17) {
				System.out.println("Tipo de contenido: juvenil");
			}else {
				System.out.println("Tipo de contenido: Todas las peliculas");
			}
			//plan
			
			if(precioMensual<10) {
				System.out.println("Tipo de plan: Plan Basico");
			}else if(precioMensual>10 && precioMensual<15) {
				System.out.println("Tipo de plan: Plan Estandar");
			}else {
				System.out.println("Tipo de plan: Plan Premium");
			}
			break;
			
		case 2:
			System.out.println("=== MARATÓN DE SERIES ===");
			System.out.println("Introduce el número total de capítulos de la serie:");
			int capitulosSerie = Integer.parseInt(leer.readLine());
			int totalMinutos=0;
			int numeroCapitulosLeidos=0;
			boolean salirBucle = true;
			for(int i = 0; i<capitulosSerie && salirBucle;i++) {
				System.out.println("Reproduciendo episodio "+(i+1)+" de un total de "+capitulosSerie);
				System.out.println("Introduce la duración en minutos del capítulo "+(i+1)+" (0 para parar):");
				int munutosCapitulosSerie = Integer.parseInt(leer.readLine());
				totalMinutos +=munutosCapitulosSerie;
				
				if(munutosCapitulosSerie !=0) {
					numeroCapitulosLeidos++;
				}else {
					salirBucle=false;
				}
			}
			System.out.println("--- RESUMEN ---");
			if(numeroCapitulosLeidos==capitulosSerie) {
				System.out.println("Has visto toda la serie");
			}else {
				System.out.println("Te faltan por ver: "+(capitulosSerie-numeroCapitulosLeidos));
			}
			System.out.println("Hoy has visto un total de "+numeroCapitulosLeidos+" capítulos, con una duración total de "+totalMinutos+" minutos");
			break;
			
		case 3:
			System.out.println("=== PUNTUACION DE CAPITULOS ===");
			System.out.println("Introduce el nombre de la serie:");
			String nombreSerie = leer.readLine();
			System.out.println("Introduce el número de temporadas:");
			int numeroTemporadas = Integer.parseInt(leer.readLine());
			System.out.println("Introduce el número de capítulos por temporada:");
			int numeroCapitulosTemporada = Integer.parseInt(leer.readLine());
			int mediaTotal = 0;
			for(int i = 0;i<numeroTemporadas;i++) {
				System.out.println("--- TEMPORADA "+(i+1)+" ---");
				for(int j = 0; j<numeroCapitulosTemporada;j++) {
					int notaCap =-1;
					while (notaCap < 0 || notaCap > 10) {
					System.out.println("Introduce la nota del capítulo "+(j+1)+" (0-10):");
					notaCap = Integer.parseInt(leer.readLine());
					if (notaCap < 0 || notaCap > 10) {
						System.out.println("Nota no valida. Tiene que ser entre 1 y 10");
					}
					mediaTotal +=notaCap;
				}
			}
				double mediaFinal = mediaTotal/numeroCapitulosTemporada;
				System.out.println("Nota media de la temporada "+(i+1)+" :"+mediaFinal);
		}
			
			System.out.println("--- NOTA MEDIA FINAL DE LA SERIE "+nombreSerie+ " :"  );
			break;
			
		case 4:
			System.out.println("=== SISTEMA DE RECOMENDACIONES ==="); 
			
			char quiereMas = 'S';
			do {
			int numAdjetivo = (int) (Math.floor(Math.random() * 5) + 1);
			int numSustantivo= (int) (Math.floor(Math.random() * 5) + 1);
			int notaAleatoria= (int) (Math.floor(Math.random() * 10) + 1);
			String adjetivo="";
			switch(numAdjetivo) {
			case 1:
				adjetivo = "Increible";
				break;
			case 2:
				adjetivo = "Epico";
				break;
			case 3:
				adjetivo = "Misterioso";
				break;
			case 4:
				adjetivo = "Oscuro";
				break;
			case 5:
				adjetivo = "Último";
				break;
			}			
			String sustantivo="" ;
			switch(numSustantivo) {
			case 1:
				sustantivo = "Viaje";
				break;
			case 2:
				sustantivo = "Secreto";
				break;
			case 3:
				sustantivo = "Destino";
				break;
			case 4:
				sustantivo = "Horizonte";
				break;
			case 5:
				sustantivo = "Reino";
				break;
			}
			String codigoAleatorio =adjetivo+" "+sustantivo;
			System.out.println("Recomendación: "+codigoAleatorio);
			System.out.println("Puntuación: "+notaAleatoria+"/10");
			System.out.println("¿Quieres otra recomendación? (S/N):");
			quiereMas = leer.readLine().toUpperCase().charAt(0);
			}while(quiereMas !='N');
			break;
			
		case 5:
			salir = true;
			System.out.println("Gracias por usar CALASANZ+. ¡Nos vemos en tu próxima maratón!");
			break;
			default:
			System.out.println("Opción no válida");
		}
		}while(!salir);
	}

}
