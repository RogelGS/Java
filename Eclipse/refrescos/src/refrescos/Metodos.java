package refrescos;

public interface Metodos {

	public void guardar(Refresco re);
	public void editar(int indice, Refresco re);
	public void eliminar(int indice);
	
	public Refresco buscar(int indice);
	public void mostrar();
}
