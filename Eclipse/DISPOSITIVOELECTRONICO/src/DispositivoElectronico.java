
public class DispositivoElectronico {
	int clave;
	String nombre, marca;
	double precio;
	
	public DispositivoElectronico(int clave) {
		this.clave = clave;
	}
	
	public DispositivoElectronico(int clave, String nombre, String marca, double precio) {
		super();
		this.clave = clave;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "DispositivoElectronico [clave=" + clave + ", nombre=" + nombre + ", marca=" + marca + ", precio="
				+ precio + "]\n";
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
