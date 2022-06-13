
public class Libro {
	String nombre, editorial;
	int hojas;
	double precio;
	
	public Libro() {
		
	}
	
	public Libro(String nombre) {
		this.nombre = nombre;
	}
	
	public Libro(String nombre, String editorial, int hojas, double precio) {
		super();
		this.nombre = nombre;
		this.editorial = editorial;
		this.hojas = hojas;
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Libro [nombre=" + nombre + ", editorial=" + editorial + ", hojas=" + hojas + ", precio=" + precio + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getHojas() {
		return hojas;
	}

	public void setHojas(int hojas) {
		this.hojas = hojas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
