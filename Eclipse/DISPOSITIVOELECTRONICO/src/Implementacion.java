import java.util.HashMap;

public class Implementacion implements Metodos{
	HashMap<Integer, DispositivoElectronico> hash = new HashMap<Integer, DispositivoElectronico>();
	DispositivoElectronico de = null;
	
	@Override
	public void guardar(Object objeto) {
		de = (DispositivoElectronico) objeto;
		hash.put(de.getClave(), de);
	}

	@Override
	public void editar(Object objeto) {
		de = (DispositivoElectronico) objeto;
		hash.put(de.getClave(), de);		
	}

	@Override
	public void eliminar(Object objeto) {
		de = (DispositivoElectronico) objeto;
		hash.remove(de.getClave());
	}

	@Override
	public Object buscar(Object objeto) {
		de = (DispositivoElectronico) objeto;
		return hash.get(de.getClave());
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
	}
	
	public void eliminarTodo() {
		hash.clear();
	}
	
	public void contar() {
		System.out.println("El hash tiene "+ hash.size());
	}
}
