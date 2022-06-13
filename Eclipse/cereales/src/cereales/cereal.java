package cereales;

public class cereal {
	
	//Variables
	String nombre, marca;
	int contNet;
	double precio;
	
	public cereal() {
		
	}

	public cereal(String nombre, String marca, int contNet, double precio) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.contNet = contNet;
		this.precio = precio;
	}

	

	@Override
	public String toString() {
		return "cereal [nombre=" + nombre + ", marca=" + marca + ", contNet=" + contNet + ", precio=" + precio + "]";
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

	public int getContNet() {
		return contNet;
	}

	public void setContNet(int contNet) {
		this.contNet = contNet;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
