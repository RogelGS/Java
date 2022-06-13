
public class Medico extends Profesionista {
	
	String colorBata, especialidad;
	
	public Medico() {
		
	}
	
	public Medico(String nombre, String apellido, String titulo, String universidad, String colorBata, String especialidad) {
		super(nombre, apellido, titulo, universidad);
		this.colorBata = colorBata;
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Medico [colorBata=" + colorBata + ", especialidad=" + especialidad + "]";
	}

	@Override
	public void trabajar() {
		System.out.println("Chin tienes covid->Omicron");
		
	}
	
	public void consultar() {
		System.out.println("Ten paracetamol, es para todo");
	}

	public String getColorBata() {
		return colorBata;
	}

	public void setColorBata(String colorBata) {
		this.colorBata = colorBata;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	

}
