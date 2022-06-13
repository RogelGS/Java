package com.mx.implementacion;

import java.util.HashMap;

import com.mx.entidad.Marca;
import com.mx.genral.Metodos;

public class ImpMarca implements Metodos {

	HashMap<String, Marca> hash = new HashMap<String, Marca>();
	Marca marca = null;

	@Override
	public void guardar(Object obj) {
		marca = (Marca) obj;
		hash.put(marca.getNombre(), marca);
	}

	@Override
	public void editar(Object obj) {
		marca = (Marca) obj;
		hash.put(marca.getNombre(), marca);
	}

	@Override
	public void eliminar(Object obj) {
		marca = (Marca) obj;
		hash.remove(marca.getNombre());
	}

	@Override
	public Object buscar(Object obj) {
		marca = (Marca) obj;
		return hash.get(marca.getNombre());
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
	}

}
