import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int clave;
		String nombre, marca;
		double precio;
		DispositivoElectronico de = null;
		Scanner leer = null;
		int menu, submenu;
		
		Implementacion imp = new Implementacion();
		
		do {
			
			System.out.println("Bienvenido a su tienda de dispositivos electronicos Enucom");
			System.out.println("1. Alta");
			System.out.println("2. Editar");
			System.out.println("3. Eliminar");
			System.out.println("4. Eliminar");
			System.out.println("5. Contar");
			System.out.println("6. Eliminar Todo");
			System.out.println("7. Buscar por nombre");
			System.out.println("8. Mostrar");
			System.out.println("9. Salir\n");
			
			leer = new Scanner(System.in);
			menu = leer.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("Opción alta de dispositivo electronico");
					
					System.out.println("Escribe la clave del dispositivo");
					leer = new Scanner(System.in);
					clave = leer.nextInt();

					System.out.println("Escribe el nombre del dispositivo");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					System.out.println("Escribe la marca del dispositivo");
					leer = new Scanner(System.in);
					marca = leer.nextLine();
					
					System.out.println("Escribe el precio del dispositivo");
					leer = new Scanner(System.in);
					precio = leer.nextDouble();
					
					de = new DispositivoElectronico(clave, nombre, marca, precio);
					imp.guardar(de);
					System.out.println("Se guardo el dispositivo correctamente\n");
					break;
				case 2:
					System.out.println("Escribe la clave del dispositivo a editar");
					leer = new Scanner(System.in);
					clave = leer.nextInt();
					de = new DispositivoElectronico(clave);
					de = (DispositivoElectronico) imp.buscar(imp);
					
					do {
						
						System.out.println("Menu Editar");
						System.out.println("1. Precio");
						System.out.println("2. Nombre");
						System.out.println("3. Regresar al menu principal");
						
						leer = new Scanner(System.in);
						submenu = leer.nextInt();
						
						switch(submenu) {
							case 1:
								System.out.println("Escribe el precio del dispositivo a editar");
								leer = new Scanner(System.in);
								precio = leer.nextDouble();
								de.setPrecio(precio);
								break;
							case 2:
								System.out.println("Escribe el nombre del dispositivo a editar");
								leer = new Scanner(System.in);
								nombre = leer.nextLine();
								de.setNombre(nombre);
								break;
							case 3:
								System.out.println("Regresando al menu principal\n");
								break;
						}
					}while(submenu < 3);					
					break;
				case 3:
					System.out.println("Escribe la clave del dispositivo a eliminar");
					leer = new Scanner(System.in);
					clave = leer.nextInt();
					de = new DispositivoElectronico(clave);
					de = (DispositivoElectronico) imp.buscar(imp);
					imp.eliminar(de);
					System.out.println("Se elimino el dispositivo "+ de);
					break;
				case 4:
					System.out.println("Escribe la clave del dispositivo a buscar");
					leer = new Scanner(System.in);
					clave = leer.nextInt();
					de = new DispositivoElectronico(clave);
					de = (DispositivoElectronico) imp.buscar(imp);
					break;
				case 5:
					imp.contar();
					break;
				case 6:
					imp.eliminarTodo();
					break;
				case 8:
					imp.mostrar();
					break;
				case 9:
					System.out.println("Gracias por usar el sistema!\n");
					break;
			}
		}while(menu < 9);
		
	}

}
