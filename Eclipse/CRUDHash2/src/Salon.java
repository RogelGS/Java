
public class Salon {
	int clave;
	String estatus;
	
	public Salon() {
		
	}
	
	public Salon(int clave) {
		this.clave = clave;
	}
	
	public Salon(int clave, String estatus) {
		super();
		this.clave = clave;
		this.estatus = estatus;
	}
	
	@Override
	public String toString() {
		return "Salon [clave=" + clave + ", estatus=" + estatus + "]\n";
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
