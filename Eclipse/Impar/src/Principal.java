import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leer = null;
		System.out.println("Ingrese un numero");
		leer = new Scanner(System.in);
		int numero = leer.nextInt();
		if(numero % 2 == 0) {
			System.out.println("Es par");
		} else {
			System.out.println("Es impar");
		}
	}

}
