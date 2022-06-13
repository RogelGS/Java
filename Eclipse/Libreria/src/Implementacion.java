import java.util.HashMap;

public class Implementacion implements Metodos {
	HashMap<String, Libro> hash = new HashMap<String, Libro>();
	Libro l = null;

	@Override
	public void agregar(Object obj) {
		l = (Libro) obj;
		hash.put(l.getNombre(), l);
	}

	@Override
	public void editar(Object obj) {
		l = (Libro) obj;
		hash.put(l.getNombre(), l);
	}

	@Override
	public void eliminar(Object obj) {
		l = (Libro) obj;
		hash.remove(l.getNombre());
	}

	@Override
	public Object buscar(Object obj) {
		l = (Libro) obj;
		l = hash.get(l.getNombre());
		return l;
	}
	
	public void buscarEditorial(Libro libro) {
		for(Libro l: hash.values()) {
			if(l.getEditorial().equals(libro.getEditorial())) {
				System.out.println("Articulo encontrado: " + l + "\n");
			}
		}
		return ;
	}

	@Override
	public void mostrar() {
		System.out.println(hash+"\n");
	}
	
	public void eliminarTodo() {
		hash.clear();
	}
	
	public void contar() {
		System.out.println("El hash contiene " + hash.size());
	}
}
