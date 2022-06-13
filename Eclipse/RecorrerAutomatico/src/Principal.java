import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leer = null;
		List<String> elementos = new ArrayList<>();
		List<String> rotados = new ArrayList<>();
		int i = 0;
		int rotar = 0;
		String num;
		System.out.println("Ingresa los numeros, para finalizar presiona *");
		do {
			leer = new Scanner(System.in);
			num = leer.nextLine();
			
			if(num.equals("*")) {
				break;
			}
			
			elementos.add(num);
		}while(true);
		
		for(int j = 0; j < elementos.size(); j++) {
			System.out.println(j+") "+elementos.get(j));
		}
		
		System.out.println("Ingresa el numero de rotaciones");
		leer = new Scanner(System.in);
		rotar = leer.nextInt();
		
		for(int j = elementos.size()-rotar; j < elementos.size(); j++) {
			rotados.add(elementos.get(j));
		}
		
		for(int j = 0; j < elementos.size()-rotar; j++) {
			rotados.add(elementos.get(j));
		}
		
		for(int j = 0; j < rotados.size(); j++) {
			System.out.println(j+") "+rotados.get(j));
		}
	}

}
