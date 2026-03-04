package bucles;

public class ejercicio39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int suma=0;
		int suma1=0;
		for(int i = 0; i<=165;i++) {
			if(i % 2 == 0) {
				suma=i+suma;
			}else {
				suma1=i+suma1;
			}
			
		}
		System.out.println("La suma de los numeros pares es: "+suma);
		System.out.println("La suma de los numeros impares es: "+suma1);
	}

}
