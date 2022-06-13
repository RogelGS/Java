import java.util.HashMap;

public class Implementacion implements Metodos {
	HashMap<Integer, Computadora> hash = new HashMap<Integer, Computadora>();
	Computadora c = null;
	
	@Override
	public void agregar(Object obj) {
		c = (Computadora) obj;
		hash.put(c.getClave(), c);
	}

	@Override
	public void editar(Object obj) {
		c = (Computadora) obj;
		hash.put(c.getClave(), c);
	}

	@Override
	public void eliminar(Object obj) {
		c = (Computadora) obj;
		hash.remove(c.getClave());
		
	}

	@Override
	public Object buscar(Object obj) {
		c = (Computadora) obj;
		c = hash.get(c.getClave());
		return c;
	}

	@Override
	public void mostrar() {
		System.out.println(hash + "\n");
		
	}
	
	public void eliminarTodo() {
		hash.clear();
	}
	
	public void contar() {
		System.out.println("El hash contiene " + hash.size()); 
	}
	
	public void buscarMarca(Computadora computadora) {
		//System.out.println("Marca a buscar" + computadora);
		for(Computadora cc : hash.values()) {
			if(cc.getMarca().equals(computadora.getMarca())) {
				System.out.println("Computadora encontrada! " + cc + "\n");
			}
		}
		
	}
}
