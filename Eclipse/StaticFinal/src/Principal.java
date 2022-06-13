
public class Principal {

	public static void main(String[] args) {
		Perro p = new Perro();
		System.out.println("El perro se llama "+ p.nombre);
		System.out.println("El perro su raza es " + Perro.raza);
		
		p.ladrar();
		
		Perro.correr();
		
		System.out.println("Edad " + p.edad);{
		
		System.out.println("El perro es " + Perro.genero);
		}
	}
	
}
