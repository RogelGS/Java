
public class Perro extends Animal {
	String color, raza;
	
	public Perro() {
		
	}
	
	public Perro(String nombre, String especie, String color, String raza) {
		super(nombre, especie);
		this.color = color;
		this.raza = raza;
	}

	@Override
	public void comer() {
		System.out.println("Esta comiendo croquetas");
		
	}
	
	public void marcar() {
		System.out.println("Esta marcando su territorio");
	}
	
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", especie=" + especie + ", color=" + color + ", raza=" + raza + "]";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
}
