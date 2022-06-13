
public class Desayuno {
	int clave, calorias;
	String nombre;
	double precio;
	
	public Desayuno() {
		
	}
	
	public Desayuno(int clave, int calorias, String nombre, double precio) {
		super();
		this.clave = clave;
		this.calorias = calorias;
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Desayuno [clave=" + clave + ", calorias=" + calorias + ", nombre=" + nombre + ", precio=" + precio
				+ "]";
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
