
public class Principal {

	public static void main(String[] args) {
		Leon l = new Leon("Leon", "Felino", "Frondoso", "si");
		
		//NO ABSTRACTO
		l.dormir();
		
		//ABSTRACTO
		l.comer();
		
		//PROPIO
		l.cazar();
		
		System.out.println("\n-----------SEGUNDA CLASE----------\n");
		Perro p = new Perro("Perro", "Canino", "Rizado", "si");
		
		//NO ABSTRACTO
		p.dormir();
		
		//ABSTRACTO
		p.comer();
		
		//PROPIO
		p.marcar();
	}

}
