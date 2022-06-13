import java.util.ArrayList;
import java.util.List;

public class Implementacion implements Metodos {
	
	List<Cancion> lista = new ArrayList<Cancion>();
	
	@Override
	public void guardar(Cancion cancion) {
		lista.add(cancion);
		
	}

	@Override
	public void editar(int indice, Cancion cancion) {
		lista.set(indice, cancion);
		
	}

	@Override
	public void eliminar(int indice) {
		lista.remove(indice);
		
	}

	@Override
	public Cancion buscar(int indice) {
		Cancion c = lista.get(indice);
		return c;
	}

	@Override
	public void mostrar() {
		System.out.println(lista);
		
	}

}
