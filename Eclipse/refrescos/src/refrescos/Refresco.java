package refrescos;

public class Refresco {
	String nombre, marca;
	double precio;
	
	public Refresco(){
		
	}

	
	
	public Refresco(String nombre, String marca, double precio) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
	}

	

	@Override
	public String toString() {
		return "refresco [nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + "]";
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
