import java.util.ArrayList;
import java.util.List;

public class Implementacion implements Metodos {
	List<Bebida> lista = new ArrayList<Bebida>();

	@Override
	public void editar(int indice, Bebida bebida) {
		lista.set(indice, bebida);
	}

	@Override
	public void agregar(Bebida bebida) {
		lista.add(bebida);
	}

	@Override
	public void eliminar(int indice) {
		lista.remove(indice);
	}

	@Override
	public Bebida buscar(int indice) {
		Bebida b = lista.get(indice);
		return b;
	}

	@Override
	public void mostrar() {
		System.out.println(lista);
		
	}
	
	public void contar() {
		System.out.println(lista.size());
	}
	
	public void eliminarTodo() {
		lista.clear();
	}
	
	public void vacia() {
		System.out.println(lista.isEmpty() ? "Vacia" : "No vacia");
	}
	
	public Bebida buscarNombre(String nombre) {
		for (Bebida bebida : lista) {
			if(bebida.getNombre().equals(nombre)) {
				return bebida;
			}
		}
		return null;
	}
}
