import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leer = null;
		System.out.println("Escriba un numero");
		leer = new Scanner(System.in);
		int numero = leer.nextInt();
		
		Factorial f = new Factorial();
		System.out.println("El factorial del numero: " + numero + " es: " + f.factorial(numero));
	}

}
