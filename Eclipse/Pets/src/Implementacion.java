import java.util.HashMap;

public class Implementacion implements Metodos{
	HashMap<Object, Object> hash = new HashMap<>();
	
	//EXPRESIONES LAMBDA
	CRUD guardarEditar = (c, o) -> {
		hash.put(c, o);
		return null;
	};
	
	CRUD eliminar = (c, o) -> {
		hash.remove(c);
		return null;
	};
	
	CRUD buscar = (c, o) -> {
		return hash.get(c);
	};
	
	CRUD mostrar = (c, o) -> {
		System.out.println(hash + "\n");
		return null;
	};
	
	CRUD contar = (c, o) -> {
		System.out.println("El hash contiene " + hash.size() + "\n");
		return null;
	};
	
	@Override
	public void guardar(Object clave, Object obj) {
		guardarEditar.crud(clave, obj);
	}

	@Override
	public void editar(Object clave, Object obj) {
		guardarEditar.crud(clave, obj);
	}

	@Override
	public void eliminar(Object clave) {
		eliminar.crud(clave, null);
	}

	@Override
	public Object buscar(Object clave) {
		return buscar.crud(clave, null);
	}

	@Override
	public void mostrar() {
		mostrar.crud(null, null);
	}
	
	public void contar() {
		contar.crud(null, null);
	}

}
