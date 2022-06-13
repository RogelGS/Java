
public abstract class Animal {
	protected String nombre, especie;
	
	public Animal() {
		
	}

	public Animal(String nombre, String especie) {
		this.nombre = nombre;
		this.especie = especie;
	}
	
	public void dormir() {
		System.out.println("Estoy descansando");
	}
	
	public abstract void comer();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	
}
