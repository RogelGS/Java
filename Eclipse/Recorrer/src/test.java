
public class test {

	public static void main(String[] args) {
		test();

	}
	
	public static  void test(){
	    int posInicial = 3;
	    int posFinal = 7;
	    //crear el array inicial
	    int[] arrayInicial = {20,5,7,4,32,9,2,14,11,6};
	    int[] arrayFinal = desplazamiento(arrayInicial,posInicial,posFinal);
	    System.out.println("RESULTADO:");
	    //mostrar resultados
	    for (int i = 0; i < arrayFinal.length; i++) {
	        System.out.println(i+") "+arrayFinal[i]);
	    }
	}

	private static int[] desplazamiento(int[] arrayInicial, int posInicial, int posFinal){
	    int[] arrayFinal = new int[10];

	    //Hacer una copia de tu array original, para que en caso de no cumplirse alguna condición devolver el array original
	    for (int i = 0; i < arrayInicial.length; i++) {
	        arrayFinal[i] = arrayInicial[i];
	    }

	    // condiciones del problema
	    if(posInicial >=0 && posFinal <10 && posInicial < posFinal){
	        int numInicial = arrayInicial[posInicial];
	        arrayFinal[posFinal] = numInicial; // hacer el remplazo del numero inicial por el final
	        for (int i = posFinal; i < arrayInicial.length-1; i++) { // hacer los desplazamientos de la posicion final a la derecha
	            arrayFinal[i+1] = arrayInicial[i];
	        }
	        arrayFinal[0] = arrayInicial[arrayInicial.length-1]; // indicar la ultima posicion del array original, como la primera del nuevo array
	        for (int i = 1; i <= posInicial; i++) { // indicar los desplazamientos de la primera posicion del array hasta la posicion inicial
	            arrayFinal[i] = arrayInicial[i - 1];
	        }
	    }
	    return arrayFinal;
	}

}
