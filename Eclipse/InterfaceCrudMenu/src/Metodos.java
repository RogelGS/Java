
public interface Metodos {
	public void guardar(Cancion cancion);
	public void editar(int indice, Cancion cancion);
	public void eliminar(int indice);
	
	public Cancion buscar(int indice);
	public void mostrar();
}
