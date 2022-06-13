
public class Hijo extends Padre {
	String hobby, estudio;
	double estatura;
	
	public Hijo() {
		
	}

	public Hijo(String nombre, String apellido, int edad, String hobby, String estudio, double estatura) {
		super(nombre, apellido, edad);
		this.hobby = hobby;
		this.estudio = estudio;
		this.estatura = estatura;
	}
	
	public void mostrar() {
		System.out.println("nombre " + nombre);
	}

	@Override
	public String toString() {
		return "Hijo [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", hobby=" + hobby
				+ ", estudio=" + estudio + ", estatura=" + estatura + "]\n";
	}
	
	public void jugar() {
		System.out.println("Hechando el LOL");
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	
	
}
