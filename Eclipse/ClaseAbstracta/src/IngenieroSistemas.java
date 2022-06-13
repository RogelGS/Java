
public class IngenieroSistemas extends Profesionista {

	String lenguaje, framework;

	public IngenieroSistemas() {
		
	}

	public IngenieroSistemas(String nombre, String apellido, String titulo, String universidad, String lenguaje, String framework) {
		super(nombre, apellido, titulo, universidad);
		this.lenguaje = lenguaje;
		this.framework = framework;
	}
	
	@Override
	public void trabajar() {
		System.out.println("Haciendo el hola mundo");
	}
	
	public void programando() {
		System.out.println("Viendo tutorial en YouTube");
	}
	
	@Override
	public String toString() {
		return "IngenieroSistemas [lenguaje=" + lenguaje + ", framework=" + framework + "]";
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}
	
	
}
