
public class Computadora {
	int clave;
	String modelo, marca;
	double precio;
	int ram;
	
	public Computadora() {
		
	}
	
	public Computadora(int clave) {
		this.clave = clave;
	}
	
	public Computadora(int clave, String modelo, String marca, double precio, int ram) {
		super();
		this.clave = clave;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.ram = ram;
	}
	
	@Override
	public String toString() {
		return "Computadora [clave=" + clave + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio
				+ ", ram=" + ram + "]\n";
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}
	
}
