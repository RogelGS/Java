import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ImplementacionSalon impSalon = new ImplementacionSalon();

		Salon s1 = new Salon(1, "Abierto");
		Salon s2 = new Salon(2, "Abierto");
		Salon s3 = new Salon(3, "Abierto");
		Salon s = null;
		
		impSalon.agregar(s1.getClave(), s1);
		impSalon.agregar(s2.getClave(), s2);
		impSalon.agregar(s3.getClave(), s3);
		impSalon.mostrar();
		System.out.println("");
		
		s = new Salon(1, "Cerrado");
		impSalon.editar(s.getClave(), s);
		impSalon.mostrar();
		
		System.out.println("");
		impSalon.eliminar(1);
		impSalon.mostrar();
		System.out.println("");
		
		s = new Salon();
		s.setClave(2);
		s = (Salon) impSalon.buscar(s.getClave());
		System.out.println(s);
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		ImplementacionDesayuno impDesayuno = new ImplementacionDesayuno();
		
		Desayuno d1 = new Desayuno(1, 200, "Ensalada", 22);
		Desayuno d2 = new Desayuno(2, 220, "Huevos", 30);
		Desayuno d3 = new Desayuno(3, 230, "Torta", 25);
		Desayuno d = null;
		
		
		impDesayuno.agregar(d1.getClave(), d1);
		impDesayuno.agregar(d1.getClave(), d2);
		impDesayuno.agregar(d1.getClave(), d3);
		impDesayuno.mostrar();
		System.out.println("");
		
		d = new Desayuno(1, 200, "Ensalada", 23);
		
		impDesayuno.editar(d.getClave(), d);
		impDesayuno.mostrar();
		System.out.println("");
		
		impDesayuno.eliminar(2);
		impDesayuno.mostrar();
		System.out.println("");
		
		d = new Desayuno();
		d.setClave(1);
		d = (Desayuno) impDesayuno.buscar(d.getClave());
		System.out.println(d);
	}

}
