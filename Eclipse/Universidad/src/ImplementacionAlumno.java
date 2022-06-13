
public class ImplementacionAlumno extends CRUD{
	
	Alumno a = null;
	
	public void buscarProfesor(String clave) {
		for(Object o: hash.values()) {
			a = (Alumno) o;
			if(a.getP().getMatricula().equals(clave)) {
				System.out.println(a + "\n");
			} else {
				System.out.println("Matricula no encontrada\n");
			}
		}
	}
}
