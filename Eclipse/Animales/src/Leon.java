
public class Leon extends Animal{
	
	String pelaje, eslider;
	
	public Leon() {
		
	}
	
	public Leon(String nombre, String especie, String pelaje, String eslider) {
		super(nombre, especie);
		this.pelaje = pelaje;
		this.eslider = eslider;
	}

	@Override
	public void comer() {
		System.out.println("Esta comiendo una cebra");
		
	}
	
	public void cazar() {
		System.out.println("Esta cazando una cebra");
	}
	
	@Override
	public String toString() {
		return "Leon [nombre=" + nombre + ", especie=" + especie + ", pelaje=" + pelaje + ", eslider=" + eslider + "]";
	}

	public String getPelaje() {
		return pelaje;
	}

	public void setPelaje(String pelaje) {
		this.pelaje = pelaje;
	}

	public String getEslider() {
		return eslider;
	}

	public void setEslider(String eslider) {
		this.eslider = eslider;
	}
	
}
