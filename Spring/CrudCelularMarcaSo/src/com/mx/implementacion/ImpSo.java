package com.mx.implementacion;

import java.util.HashMap;

import com.mx.entidad.So;
import com.mx.genral.Metodos;

public class ImpSo implements Metodos {

	HashMap<String, So> hash = new HashMap<String, So>();
	So so = null;

	@Override
	public void guardar(Object obj) {
		so = (So) obj;
		hash.put(so.getNombre(), so);
	}

	@Override
	public void editar(Object obj) {
		so = (So) obj;
		hash.put(so.getNombre(), so);
	}

	@Override
	public void eliminar(Object obj) {
		so = (So) obj;
		hash.remove(so.getNombre());
	}

	@Override
	public Object buscar(Object obj) {
		so = (So) obj;
		return hash.get(so.getNombre());
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
	}

}
