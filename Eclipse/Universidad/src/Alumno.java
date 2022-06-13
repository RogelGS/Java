
public class Alumno extends Persona{
	String hobby;
	Profesor p;
	
	public Alumno() {
		
	}
	
	public Alumno(String matricula) {
		this.matricula = matricula;
	}
	
	public Alumno(String matricula, String nombre, String apellido, String hobby, Profesor p) {
		super(matricula, nombre, apellido);
		this.hobby = hobby;
		this.p = p;
	}



	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", hobby=" + hobby
				+ ", p=" + p + "]\n";
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Profesor getP() {
		return p;
	}

	public void setP(Profesor p) {
		this.p = p;
	}
	
	
}
