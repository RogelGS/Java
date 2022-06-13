
public class Principal {

	public static void main(String[] args) {
		Medico m = new Medico("Gregory", "House", "T01", "BUAP", "BLANCA", "Diagnosta");
		System.out.println(m);
		
		//METODO ABSTRACTO(PROFESIONISTA)
		System.out.println("Metodo abstracto");
		m.trabajar();
		
		//METODO NO ABSTRACTO(PROFESIONISTA)
		System.out.println("\nMetodo no abstracto");
		m.cobrar(2500, "NOMINA");
		
		//METODO PROPIO
		System.out.println("\nMetodo propio");
		m.consultar();
		
		IngenieroSistemas is = new IngenieroSistemas("MARK", "ZUCKERBERG", "T02", "HARDVARD", "PHP", "REACT");
		System.out.println(is);
		
		System.out.println("\n----SEGUNDO EJEMPLO----\n");
		//METODO ABSTRACTO(PROFESIONISTA)
		System.out.println("Metodo abstracto");
		is.trabajar();
		
		//METODO NO ABSTRACTO(PROFESIONISTA)
		System.out.println("\nMetodo no abstracto");
		is.cobrar(2000, "NOMINA");
		
		//METODO PROPIO
		System.out.println("\nMetodo propio");
		is.programando();
	}

}
