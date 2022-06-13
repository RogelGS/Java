import java.util.Iterator;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese el tamaño: ");
		int tamanio = leer.nextInt();
		leer.close();
		
		System.out.println();
		for(int high = 1; high <= tamanio; high++) {
			for(int blank = 1; blank <= tamanio-high; blank++) {
				System.out.print(" ");
			}
			
			for(int black = 1; black <= (high*2)-1; black++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
