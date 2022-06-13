
public class Pet {
	String nombre, raza;
	double precio;
	
	public Pet() {
		
	}
	
	public Pet(String nombre) {
		this.nombre = nombre;
	}

	public Pet(String nombre, String raza, double precio) {
		this.nombre = nombre;
		this.raza = raza;
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Pet [nombre=" + nombre + ", raza=" + raza + ", precio=" + precio + "]\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
