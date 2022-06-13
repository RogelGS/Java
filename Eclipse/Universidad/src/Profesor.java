
public class Profesor extends Persona{
	
	int edad;
	
	public Profesor() {
		
	}
	
	public Profesor(String matricula) {
		this.matricula = matricula;
	}
	
	public Profesor(String matricula, String nombre, String apellido, int edad) {
		super(matricula, nombre, apellido);
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Profesor [matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ "]\n";
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
