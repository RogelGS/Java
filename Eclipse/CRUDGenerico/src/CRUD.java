import java.util.ArrayList;
import java.util.List;

public class CRUD implements Metodos {
	List<Object> lista = new ArrayList<Object>();
	
	@Override
	public void agregar(Object obj) {
		lista.add(obj);
		
	}

	@Override
	public void editar(int index, Object obj) {
		lista.set(index, obj);
		
	}

	@Override
	public void eliminar(int index) {
		lista.remove(index);
		
	}

	@Override
	public Object buscar(int index) {
		Object o = lista.get(index);
		return o;
	}

	@Override
	public void mostrar() {
		System.out.println(lista);
		
	}
	
}
