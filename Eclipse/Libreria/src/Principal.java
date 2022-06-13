import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String nombre, editorial;
		int hojas;
		double precio;
		Scanner leer = null;
		int menu, submenu;
		Libro l = null;
		Implementacion imp = new Implementacion();
		
		do {
			System.out.println("Bienvenidos a su tienta de Libros Enucom");
			System.out.println("1 alta");
			System.out.println("2 editar");
			System.out.println("3 eliminar");
			System.out.println("4 buscar");
			System.out.println("5 contar");
			System.out.println("6 eliminar todo");
			System.out.println("7 buscar por nombre");
			System.out.println("8 mostrar");
			System.out.println("9 salir\n");
			
			leer = new Scanner(System.in);
			menu = leer.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("Ingresa el nombre del libro");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					System.out.println("Ingrese la editorial del libro");
					leer = new Scanner(System.in);
					editorial = leer.nextLine();
					
					System.out.println("Ingrese el numero de hojas del libro");
					leer = new Scanner(System.in);
					hojas = leer.nextInt();
					
					System.out.println("Ingrese el precio del libro");
					leer = new Scanner(System.in);
					precio = leer.nextDouble();
					
					l = new Libro(nombre, editorial, hojas, precio);
					imp.agregar(l);
					
					System.out.println("El libro se ha agregado con el nombre de "+l.getNombre());
					break;
				case 2:
					System.out.println("Ingresa el nombre del libro a editar");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					l = new Libro(nombre);
					l = (Libro) imp.buscar(l);
					
					do {
						System.out.println("1. Editar hojas");
						System.out.println("2. Editar precio");
						System.out.println("3. Regresar al menu principal\n");
						
						leer = new Scanner(System.in);
						submenu = leer.nextInt();
						
						switch(submenu) {
							case 1:
								System.out.println("Escriba el numero de hojas del libro");
								leer = new Scanner(System.in);
								hojas = leer.nextInt();
								
								l.setHojas(hojas);
								break;
							case 2:
								System.out.println("Escriba el precio del libro");
								leer = new Scanner(System.in);
								precio = leer.nextInt();
								
								l.setPrecio(precio);
								break;
							case 3:
								System.out.println("Regresando al menu principal!\n");
								break;
						}
					}while(submenu < 3);
					imp.editar(l);
					System.out.println("Se edito el Libro "+ l);
					break;
				case 3:
					System.out.println("Ingrese el nombre del libro a eliminar");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					l = new Libro(nombre);
					l = (Libro) imp.buscar(l);
					imp.eliminar(l);
					
					System.out.println("\nSe ha eliminado el libro con el nombre "+ l.getNombre() + "\n");
					break;
				case 4:
					System.out.println("\nIngresa el nombre del libro a buscar");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					l = new Libro(nombre);
					
					l = (Libro) imp.buscar(l);
					System.out.println("\nLibro encontrado!: " + l + "\n");
					break;
				case 5:
					imp.contar();
					break;
				case 6:
					imp.eliminarTodo();
					System.out.println("La lista ha sido vaciada!\n");
					break;
				case 7:
					System.out.println("Escribe el nombre de la editorial");
					leer = new Scanner(System.in);
					editorial = leer.nextLine();
					
					l = new Libro();
					l.setEditorial(editorial);;
					
					imp.buscarEditorial(l);
					break;
				case 8:
					imp.mostrar();
					break;
				case 9:
					System.out.println("Nos vemos pronto!\n");
					break;
			}
		}while(menu < 9);
	}

}
