import java.util.HashMap;

public class Implementacion implements Metodos {
	HashMap<String, Perro> hash = new HashMap<>();
	
	
	//EXPRESIONES LAMBDA
	CRUDFuncional guardar = (p) -> {
		hash.put(p.getNombre(), p);
		return null;
	};
	
	CRUDFuncional editar = (p) -> {
		hash.put(p.getNombre(), p);
		return null;
	};
	
	CRUDFuncional eliminar = (p) -> {
		hash.remove(p.getNombre());
		return null;
	};
	
	CRUDFuncional mostrar = (p) -> {
		System.out.println(hash);
		return null;
	};
	
	CRUDFuncional buscar = (p) -> {
		return hash.get(p.getNombre());
	};
	
	@Override
	public void Guardar(Perro perro) {
		guardar.crud(perro);
	}

	@Override
	public void Editar(Perro perro) {
		editar.crud(perro);
	}

	@Override
	public void Eliminar(Perro perro) {
		eliminar.crud(perro);
	}

	@Override
	public Perro Buscar(Perro perro) {
		return buscar.crud(perro);
	}

	@Override
	public void mostrar() {
		mostrar.crud(null);
	}

}
