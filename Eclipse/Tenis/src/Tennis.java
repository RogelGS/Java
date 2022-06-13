
public class Tennis {
	String modelo, marca;
	double precio, numero;
	
	public Tennis() {
		
	}
	
	public Tennis(String modelo, String marca, double precio, double numero) {
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return "Tennis [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", numero=" + numero + "]\n";
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
	
	public double getNumero() {
		return numero;
	}
	
	public void setNumero(double numero) {
		this.numero = numero;
	}
}
