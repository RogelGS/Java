package com.mx.implementacion;

import java.util.HashMap;

import com.mx.entidad.Celular;
import com.mx.entidad.Marca;
import com.mx.genral.Metodos;

public class ImpCelular implements Metodos {

	HashMap<String, Celular> hash = new HashMap<String, Celular>();
	Celular celular = null;

	@Override
	public void guardar(Object obj) {
		celular = (Celular) obj;
		hash.put(celular.getModelo(), celular);
	}

	@Override
	public void editar(Object obj) {
		celular = (Celular) obj;
		hash.put(celular.getModelo(), celular);
	}

	@Override
	public void eliminar(Object obj) {
		celular = (Celular) obj;
		hash.remove(celular.getModelo());
	}

	@Override
	public Object buscar(Object obj) {
		celular = (Celular) obj;
		return hash.get(celular.getModelo());
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
	}

	public void buscarByMarca(Marca marca)
	{
		for(Celular c : hash.values()) {
			if(c.getMarca().getNombre().equals(marca.getNombre()))
			{
				System.out.println("Celular encontrado->"+c);
			}
		}
	
	}
	
}
