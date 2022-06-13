
public class Principal {

	public static void main(String[] args) {
		Hijo h = new Hijo("Gohan", "Son", 16, "Estudiante", "Prepa", 1.8);
		System.out.println(h);
		
		//Hijo
		h.setEstatura(1.85);
		
		//Padre
		h.setEdad(18);
		
		System.out.println(h);
		
		//Metodo Hijo
		h.jugar();
		
		//Metodo Padre
		h.trabajar();
	}

}
