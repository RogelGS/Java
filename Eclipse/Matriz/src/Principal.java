import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner leer = null;
		System.out.println("Escriba el tamaño de la matriz");
		leer = new Scanner(System.in);
		int tamanio = leer.nextInt();
		
		int[][] matriz = new int [tamanio][tamanio];
		
		int valor = 1;
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				matriz[i][j] = valor++;
			}
		}
		System.out.println();
		for(int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}
		System.out.println();
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				if(i == j) {
					System.out.println(matriz[i][j]);
				}
			}
		}
	}

}
