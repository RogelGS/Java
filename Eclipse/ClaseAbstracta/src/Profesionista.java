
public abstract class Profesionista {
	protected String nombre, apellido, titulo, universidad;
	
	public Profesionista() {
		
	}

	public Profesionista(String nombre, String apellido, String titulo, String universidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.titulo = titulo;
		this.universidad = universidad;
	}
	
	//METODO NO ABSTRACTO(NORMAL) --> ES ALGO QUE TODOS HACEN IGUAL
	public void cobrar(double cantidad, String tipo) {
		System.out.println("Me pagaron mi quincena de "+ cantidad + " en el tipo de " + tipo);
	}
	
	//METODO ABSTRACTO() --> HACEN TODOS DE FORMA DIFERENTE
	public abstract void trabajar();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	
}
