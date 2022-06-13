import java.util.HashMap;

public class Implementacion {
	static HashMap<Object, Object> hash = new HashMap<Object, Object>();
	
	public static void guardar(Object clave, Object obj) {
		hash.put(clave, obj);
	}
	
	public static void editar(Object clave, Object obj) {
		hash.put(clave, obj);
	}
	
	public static void eliminar(Object clave) {
		hash.remove(clave);
	}
	
	public static Object buscar(Object clave) {
		return hash.get(clave);
	}
	
	public static void mostrar() {
		System.out.println(hash);
	}
	
	public static void contar() {
		System.out.println("El hash contiene " + hash.size());
	}
 }
