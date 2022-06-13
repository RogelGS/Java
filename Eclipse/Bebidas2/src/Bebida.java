
public class Bebida {
	String nombre, alcohol, color;
	int precio;
	
	public Bebida() {
		
	}

	
	public Bebida(String nombre, String alcohol, String color, int precio) {
		super();
		this.nombre = nombre;
		this.alcohol = alcohol;
		this.color = color;
		this.precio = precio;
	}
	

	@Override
	public String toString() {
		return "Bebida [nombre=" + nombre + ", alcohol=" + alcohol + ", color=" + color + ", precio=" + precio + "]\n";
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
