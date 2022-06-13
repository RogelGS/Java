import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//INICIAR ESCANNER DE CONSOLA
		Scanner leer = null;
		//CONTENEDOR DEL NUMERO
		String numero;
		int rotaciones;
		//LISTA DE NUMEROS
		List<String> list = new ArrayList<>();
		List<String> rotar = new ArrayList<>();
		System.out.println("INGRESA LOS NUMEROS, PARA FINALIZAR PRESIONA *");
		do {
			leer = new Scanner(System.in);
			numero = leer.next();
			
			if(numero.equals("*")) {
				break;
			}
			list.add(numero);
		}while(true);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+")"+list.get(i));
		}
		System.out.println();
		System.out.println("INGRESA LAS VECES QUE SE DEBEN DE ROTAR LOS NUMEROS");
		leer = new Scanner(System.in);
		rotaciones = leer.nextInt();
		System.out.println();
		
		for(int i = list.size()-rotaciones; i < list.size(); i++) {
			rotar.add(list.get(i));
		}
		
		for(int i = 0; i < list.size()-rotaciones; i++) {
			rotar.add(list.get(i));
		}
		
		for(int i = 0; i < rotar.size(); i++) {
			System.out.println(i+")"+rotar.get(i));
		}
	}

}
