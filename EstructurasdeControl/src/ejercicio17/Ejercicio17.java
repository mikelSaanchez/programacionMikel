package ejercicio17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio17 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int duracionLlamadaMin;
		BufferedReader lector =  new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduce la duracion llamada en min: ");
		duracionLlamadaMin = Integer.parseInt(lector.readLine());
		
		System.out.print("Introduce  el día de la semana (1= Lunes, 7= Domingo): ");
        int dia =  Integer.parseInt(lector.readLine());

        System.out.print("Introduce la hora de la llamada en formato de 24 horas (HH): ");
        int hora =  Integer.parseInt(lector.readLine());
		
		
        // Calcular el costo base de la llamada
        double precio = 0;

        // Primeros 5 minutos
       if (duracionLlamadaMin > 0) {
            int minutos;
            if (duracionLlamadaMin >= 5) {
                minutos = 5;
            } else {
                minutos = duracionLlamadaMin;
            }
            precio = minutos * 1.00;
            duracionLlamadaMin = duracionLlamadaMin - minutos;
        }


        // Siguientes 3 minutos
        if (duracionLlamadaMin > 0) {
        	int minutos;
            if (duracionLlamadaMin >= 3) {
                minutos = 3;
            } else {
                minutos = duracionLlamadaMin;
            }
            precio = precio + minutos * 0.80;
            duracionLlamadaMin = duracionLlamadaMin - minutos;
        }

        // Siguientes 2 minutos
        if (duracionLlamadaMin > 0) {
        	int minutos;
            if (duracionLlamadaMin >= 2) {
                minutos = 2;
            } else {
                minutos = duracionLlamadaMin;
            }
            precio = precio + minutos * 0.70;
            duracionLlamadaMin = duracionLlamadaMin - minutos;
        }

        // A partir del décimo minuto
        if (duracionLlamadaMin > 0) {
        	 precio = precio + duracionLlamadaMin * 0.50; 
        }
        
        // Calcular el impuesto dependiendo del día y la hora
        double impuesto = 0;

        // Impuesto 3% si es domingo
        if (dia == 7) {
            impuesto = 0.03; //3/100
        } 
        // Impuesto de 15% si es turno de mañana (6 a 12)
        else if (hora >= 6 && hora < 12) {
            impuesto = 0.15; //15/100
        } 
        // Impuesto de 10% si es turno de tarde (12 a 18)
        else if (hora >= 12 && hora < 18) {
            impuesto = 0.10;
        }
        
        double precioFinal = precio + (precio * impuesto);
        System.out.println("Precio sin impuesto: " + precio);
        System.out.println("Impuesto aplicado: " + (impuesto * 100) + "%");
        System.out.println("Precio total a pagar: " + precioFinal);
        
	}

}
