import java.util.HashMap;

public class Implementacion implements Metodos {
	HashMap<String, Mueble> hash = new HashMap<String, Mueble>();
	
	@Override
	public void guardar(Mueble mueble) {
		hash.put(mueble.getNombre(), mueble);
		
	}

	@Override
	public void editar(Mueble mueble) {
		hash.put(mueble.getNombre(), mueble);
		
	}

	@Override
	public void eliminar(Mueble mueble) {
		hash.remove(mueble.getNombre());
		
	}

	@Override
	public Mueble buscar(Mueble mueble) {
		Mueble m = hash.get(mueble.getNombre());
		return m;
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
		
	}
	
}
