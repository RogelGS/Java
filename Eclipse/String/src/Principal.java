import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leer = null;
		System.out.println("Ingrese un numero o una letra");
		leer = new Scanner(System.in);
		char valor = leer.nextLine().charAt(0);
		if(Character.isDigit(valor)) {
			System.out.println("Es numero");
		} else if(Character.isLetter(valor)) {
			System.out.println("Es letra");
		}
	}

}
