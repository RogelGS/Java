
public class Factorial {
	public int factorial(int numero) {
		int fact =1;
		for(int i = 1; i <= numero; i++) {
			fact *= i;
		}
		return fact;
	}
}
