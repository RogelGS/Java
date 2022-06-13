package refrescos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Refresco r1 = new Refresco("Coca", "Cola", 40);
		Refresco r2 = new Refresco("Big cola", "Big", 35);
		Refresco r3 = new Refresco("Mirinda", "Cola", 20);
		Refresco cc = null;
		
		Implementacion imp = new Implementacion();
		
		imp.guardar(r1);
		imp.guardar(r2);
		imp.guardar(r3);
		
		imp.mostrar();
		
		
		cc = imp.buscar(1);
		System.out.println("El refresco encontrado es + " + cc);
		
		cc = imp.buscar(1);
		cc.setPrecio(50);
		imp.editar(1, cc);
		imp.mostrar();
		
		
		cc = imp.buscar(0);
		imp.eliminar(0);
		imp.mostrar();
	}

}
