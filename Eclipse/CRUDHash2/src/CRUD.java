import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CRUD implements Metodos {
	HashMap<Object, Object> hash = new HashMap<Object, Object>();
	
	@Override
	public void agregar(Object clave, Object obj) {
		hash.put(clave, obj);
	}

	@Override
	public void editar(Object clave, Object obj) {
		hash.put(clave, obj);
	}

	@Override
	public void eliminar(Object clave) {
		hash.remove(clave);
	}

	@Override
	public Object buscar(Object clave) {
		Object o = hash.get(clave);
		return o;
	}

	@Override
	public void mostrar() {
		System.out.println(hash + "\n");
	}
	
}
