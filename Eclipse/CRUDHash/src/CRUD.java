import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CRUD implements Metodos {
	HashMap<Integer, Object> hash = new HashMap<Integer, Object>();
	
	@Override
	public void agregar(int clave, Object obj) {
		hash.put(clave, obj);
	}

	@Override
	public void editar(int clave, Object obj) {
		hash.put(clave, obj);
	}

	@Override
	public void eliminar(int clave) {
		hash.remove(clave);
	}

	@Override
	public Object buscar(int clave) {
		Object o = hash.get(clave);
		return o;
	}

	@Override
	public void mostrar() {
		System.out.println(hash + "\n");
	}
	
}
