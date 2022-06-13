import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//VARIABLES
		String nombre, alcohol, color;
		int precio;
		Bebida b = null;
		Scanner leer = null;
		Implementacion imp = new Implementacion();
		int opcion, submenu, item;
		
		//CICLO
		do {
			//OPCIONES
			System.out.println("1 alta");
			System.out.println("2 editar");
			System.out.println("3 eliminar");
			System.out.println("4 buscar");
			System.out.println("5 contar");
			System.out.println("6 eliminar todo");
			System.out.println("7 vacia");
			System.out.println("8 buscar por nombre");
			System.out.println("9 mostrar");
			System.out.println("10 salir");
			
			//LEER CONSOLA
			leer = new Scanner(System.in);
			opcion = leer.nextInt();
			
			//QUE HACER EN CADA OPCION
			switch(opcion) {
				case 1:
					System.out.println("Agregar el nombre de la bebida");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					System.out.println("Agregar precio de la bebida");
					precio = leer.nextInt();
					System.out.println("Agregar alcohol de la bebida");
					leer = new Scanner(System.in);
					alcohol = leer.nextLine();
					System.out.println("Agregar color de la bebida");
					color = leer.nextLine();
					
					b = new Bebida(nombre, alcohol, color, precio);
					imp.agregar(b);
					
					System.out.println("Bebida agregada!" + b.getNombre());
					break;
				case 2:
					System.out.println("Indique el indice de la bebida a editar");
					
					item = leer.nextInt();
					b = imp.buscar(item);
					
					do {
						System.out.println("1. Editar precio");
						System.out.println("2. Editar color");
						System.out.println("3. Regresar al menu principal");
						
						submenu = leer.nextInt();
						
						switch(submenu) {
							case 1:
								System.out.println("Ingresa el precio de la bebida");
								precio = leer.nextInt();
								b.setPrecio(precio);;
								imp.editar(item, b);
								break;
							case 2:
								System.out.println("Ingresar el color de la bebida");
								leer = new Scanner(System.in);
								color = leer.nextLine();
								b.setColor(color);
								imp.editar(item, b);
								break;
							case 3:
								System.out.println("Regresando al menu principal");
								break;
						}
					}while(submenu < 3);
					break;
				case 3:
					System.out.println("Indique el indice de la bebida a borrar");
					leer = new Scanner(System.in);
					item = leer.nextInt();
					b = imp.buscar(item);
					imp.eliminar(item);
					System.out.println("La bebida a sido eliminada"+ b.getNombre());
					break;
				case 4:
					System.out.println("Indique el indice de la bebida a buscar");
					item = leer.nextInt();
					b = imp.buscar(item);
					System.out.println(b);
					break;
				case 5:
					imp.contar();
					break;
				case 6:
					imp.eliminarTodo();
					System.out.println("Se ha eliminado todo");
					break;
				case 7:
					imp.vacia();
					break;
				case 8:
					System.out.println("Escriba el nombre de la bebida");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					b = imp.buscarNombre(nombre);
					System.out.println(b);
					break;
				case 9:
					imp.mostrar();
					break;
				case 10:
					System.out.println("Nos vemos!");
					break;
			}
		}while(opcion < 10);
	}

}
