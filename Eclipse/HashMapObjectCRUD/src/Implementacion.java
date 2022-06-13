import java.util.HashMap;

public class Implementacion implements Metodos {
	HashMap<String, Mueble> hash = new HashMap<String, Mueble>();
	Mueble m;

	@Override
	public void guardar(Object object) {
		m = (Mueble) object;
		hash.put(m.getNombre(), m);
		
	}

	@Override
	public void editar(Object object) {
		m = (Mueble) object;
		hash.remove(m.getNombre());
		
	}

	@Override
	public void eliminar(Object object) {
		m = (Mueble) object;
		hash.put(m.getNombre(), m);
	}

	@Override
	public Object buscar(Object object) {
		m = (Mueble) object;
		m = hash.put(m.getNombre(), m);
		return m;
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
		
	}
	
}
