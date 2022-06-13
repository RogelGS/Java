
public class Principal {

	public static void main(String[] args) {
		Mueble m1 = null;
		Implementacion imp = new Implementacion();
		
		m1 = new Mueble("Ropero", "Dico", 15000);
		imp.guardar(m1);
		m1 = new Mueble("Sillon", "Dico", 15000);
		imp.guardar(m1);
		m1 = new Mueble("Cama", "Dico", 15000);
		imp.guardar(m1);
		
		imp.mostrar();
		
		m1 = new Mueble("Sillon");
		m1 = (Mueble) imp.buscar(m1);
		System.out.println("Mueble encontrado "+m1);
		
		
		m1 = (Mueble) imp.buscar(new Mueble("Cama"));
		m1.setPrecio(300000);
		imp.editar(m1);
		imp.mostrar();
		
		
		imp.eliminar(new Mueble("Ropero"));
		imp.mostrar();
	}

}
