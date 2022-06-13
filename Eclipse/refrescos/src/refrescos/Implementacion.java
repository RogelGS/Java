package refrescos;

import java.util.ArrayList;
import java.util.List;

public class Implementacion implements Metodos{
	List<Refresco> list = new ArrayList<Refresco>();

	@Override
	public void guardar(Refresco re) {
		list.add(re);
	}

	@Override
	public void editar(int indice, Refresco re) {
		list.set(indice, re);
	}

	@Override
	public void eliminar(int indice) {
		list.remove(indice);
	}

	@Override
	public Refresco buscar(int indice) {
		Refresco r = list.get(indice);
		return r;
	}

	@Override
	public void mostrar() {
		System.out.println(list);
	}
	
	public void contar() {
		System.out.println("La lista tiene una longitud de + " + list.size());
	}
	
}
