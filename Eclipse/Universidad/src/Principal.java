import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Profesor p = null;
		Alumno a = null;
		String matricula, matricula2, nombre, apellido, hobby;
		int edad;
		Scanner leer = new Scanner(System.in);
		ImplementacionAlumno impA = new ImplementacionAlumno();
		CRUD impP = new ImplementacionProfesor();
		
		p = new Profesor("200", "Gustavo", "Solis", 35);
		impP.agregar(p.getMatricula(), p);
		p = new Profesor("201", "Gerardo", "Rosas", 33);
		impP.agregar(p.getMatricula(), p);
		p = new Profesor("202", "Rodrigo", "Sanchez", 45);
		impP.agregar(p.getMatricula(), p);
		
		int menu = 0, submenu = 0;
		
		do {
			try {
				
				System.out.println("1. Alta Profesor");
				System.out.println("2. Mostrar Profesor");
				System.out.println("3. Alta Alumno");
				System.out.println("4. Editar Alumno");
				System.out.println("5. Eliminar Alumno");
				System.out.println("6. Buscar Alumno");
				System.out.println("7. Mostrar Alumno");
				System.out.println("8. Buscar por profesor");
				System.out.println("9. Salir\n");
				
				leer = new Scanner(System.in);
				menu = leer.nextInt();
				
				switch(menu) {
					case 1:
						System.out.println("Ingrese la matricula del Profesor");
						leer = new Scanner(System.in);
						matricula = leer.nextLine();
						
						System.out.println("Ingrese el nombre del Profesor");
						leer = new Scanner(System.in);
						nombre = leer.nextLine();
						
						System.out.println("Ingrese el apellido del Profesor");
						leer = new Scanner(System.in);
						apellido = leer.nextLine();
						
						try {							
							System.out.println("Ingrese la edad del Profesor");
							leer = new Scanner(System.in);
							edad = leer.nextInt();
							p = new Profesor(matricula, nombre, apellido, edad);
							impP.agregar(p.getMatricula(), p);
							System.out.println("Profesor agregado correctamente "+ p + "\n");
						}catch(Exception e) {
							System.out.println("Error la edad no es un numero, redirigiendo al menu principal\n");
						}
						
						break;
					case 2:
						impP.mostrar();
						System.out.println("");
						break;
					case 3:
						System.out.println("Ingrese la matricula del Alumno");
						leer = new Scanner(System.in);
						matricula = leer.nextLine();
						
						System.out.println("Ingrese el nombre del Alumno");
						leer = new Scanner(System.in);
						nombre = leer.nextLine();
						
						System.out.println("Ingrese el apellido del Alumno");
						leer = new Scanner(System.in);
						apellido = leer.nextLine();
						
						System.out.println("Ingrese el hobby del Alumno");
						leer = new Scanner(System.in);
						hobby = leer.nextLine();
						
						System.out.println("Ingrese la matricula del Profesor");
						impP.mostrar();
						leer = new Scanner(System.in);
						matricula2 = leer.nextLine();
						
						try {
							p = new Profesor(matricula2);
							p = (Profesor) impP.buscar(p.getMatricula());
							if (p == null) {
								System.out.println("La matricula no es valida");
								break;
							}
							
							a = new Alumno(matricula, nombre, apellido, hobby, p);
							impA.agregar(a.getMatricula(), a);
						}catch(Exception e) {
							System.out.println("La Matricula no es valida");
						}
						break;
					case 4:
						System.out.println("Ingrese la matricula del alumno a editar");
						leer = new Scanner(System.in);
						matricula = leer.nextLine();
						
						try {
							a = (Alumno) impA.buscar(matricula);
							if (a == null) {
								System.out.println("La matricula no es valida");
								break;
							}
							do {
								try {
									
									System.out.println("1. Editar Apellido");
									System.out.println("2. Editar Hobby");
									System.out.println("3. Editar Profesor");
									System.out.println("4. Salir");
									leer = new Scanner(System.in);
									submenu = leer.nextInt();
									
									switch(submenu) {
										case 1:
											System.out.println("Ingrese el apellido del Alumno");
											leer = new Scanner(System.in);
											apellido = leer.nextLine();
											
											a.setApellido(apellido);
											break;
										case 2:
											System.out.println("Ingrese el hobby del Alumno");
											leer = new Scanner(System.in);
											hobby = leer.nextLine();
											
											a.setHobby(hobby);
											break;
										case 3:
											System.out.println("Ingrese la matricula del Profesor");
											leer = new Scanner(System.in);
											matricula = leer.nextLine();
											
											try {
												p = (Profesor) impP.buscar(matricula);
												if (p == null) {
													System.out.println("La matricula no es valida");
													break;
												}
												a.setP(p);
											}catch(Exception e) {
												System.out.println("Matricula no valida \n");
											}
											break;
										case 4:
											System.out.println("Regresando al menu principal!\n");
											break;
									}
									impA.editar(a.getMatricula(), a);
									System.out.println("Se ha editado el registro " + a);
								}catch(Exception e) {
									System.out.println("Ingrese una opción valida");
								}
								
							}while(submenu < 4);
						}catch(Exception e) {
							System.out.println("La Matricula no es valida\n");
						}
						break;
					case 5:
						System.out.println("Ingrese la matricula del alumno a eliminar");
						leer = new Scanner(System.in);
						matricula = leer.nextLine();
						
						try {
							a = (Alumno) impA.buscar(matricula);
							if (a == null) {
								System.out.println("La matricula no es valida");
								break;
							}
							impA.eliminar(a.getMatricula());
							System.out.println("Alumno eliminado "+ a);
						}catch(Exception e) {
							System.out.println("La Matricula no es valida\n");
						}
						break;
					case 6:
						System.out.println("Ingrese la matricula del alumno a buscar");
						leer = new Scanner(System.in);
						matricula = leer.nextLine();
						
						try {
							a = (Alumno) impA.buscar(new Alumno(matricula).getMatricula());
							if (a == null) {
								System.out.println("La matricula no es valida");
								break;
							}
							System.out.println("Matricula encontrada "+ a);
						}catch(Exception e) {
							System.out.println("La Matricula no es valida\n");
						}
						break;
					case 7:
						impA.mostrar();
						System.out.println("");
						break;
					case 8:
						System.out.println("Ingrese la matricula del profesor a buscar");
						leer = new Scanner(System.in);
						matricula = leer.nextLine();
						
						impA.buscarProfesor(matricula);

						break;
					case 9:
						System.out.println("Adios!");
						break;
				}
			}catch(Exception e) {
				System.out.println("Ingrese una opcion valida\n");
			}
		}while(menu < 9);
	}

}
