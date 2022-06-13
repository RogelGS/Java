import java.util.Scanner;

public class Principal {
	public static void main(String args[]) {
		int clave;
		String modelo, marca;
		double precio;
		int ram;
		Scanner leer = null;
		Computadora c = null;
		Implementacion imp = new Implementacion();
		int menu, submenu;
		
		do {
			
			System.out.println("1 alta");
			System.out.println("2 editar");
			System.out.println("3 eliminar");
			System.out.println("4 buscar");
			System.out.println("5 contar");
			System.out.println("6 eliminar todo");
			System.out.println("7 buscar por Marca");
			System.out.println("8 mostrar");
			System.out.println("9 salir\n");
			
			leer = new Scanner(System.in);
			menu = leer.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("Escriba la clave de la computadora");
					leer = new Scanner(System.in);
					clave = leer.nextInt();
					
					System.out.println("Escriba el modelo de la computadora");
					leer = new Scanner(System.in);
					modelo = leer.nextLine();
					
					System.out.println("Escriba la marca de la computadora");
					leer = new Scanner(System.in);
					marca = leer.nextLine();
					
					System.out.println("Escriba el precio de la computadora");
					leer = new Scanner(System.in);
					precio = leer.nextDouble();
					
					System.out.println("Escriba la ram de la computadora");
					leer = new Scanner(System.in);
					ram = leer.nextInt();
					
					c = new Computadora(clave, modelo, marca, precio, ram);
					imp.agregar(c);
					
					System.out.println("\nSe ha agregado la computadora" +  c + "\n");
					break;
				case 2:
					System.out.println("Escriba la clave de la computadora a editar");
					leer = new Scanner(System.in);
					clave = leer.nextInt();
					
					c = new Computadora(clave);
					c = (Computadora) imp.buscar(c);
					
					do {
						System.out.println("1. Editar Marca");
						System.out.println("2. Editar Precio");
						System.out.println("3. Regresar al menu principal\n");
						leer = new Scanner(System.in);
						submenu = leer.nextInt();
						
						switch(submenu) {
							case 1:
								System.out.println("Escriba la nueva marca de la computadora");
								leer = new Scanner(System.in);
								marca = leer.nextLine();
								
								c.setMarca(marca);
								break;
							case 2:
								System.out.println("Escriba el nuevo precio de la computadora");
								leer = new Scanner(System.in);
								precio = leer.nextDouble();
								
								c.setPrecio(precio);
								break;
							case 3:
								System.out.println("Regresando al menu principal!\n");
								break;
						}
					}while(submenu < 3);
					imp.editar(c);
					break;
				case 3:
					System.out.println("Escriba la clave de la computadora a eliminar");
					leer = new Scanner(System.in);
					clave = leer.nextInt();
					
					c = new Computadora(clave);
					c = (Computadora) imp.buscar(c);
					imp.eliminar(c);
					
					System.out.println("Se ha eliminado la computadora " + c);
					break;
				case 4:
					System.out.println("Ingrese la clave de la computadora a buscar");
					leer = new Scanner(System.in);
					clave = leer.nextInt();
					
					c = new Computadora(clave);
					c = (Computadora) imp.buscar(c);
					
					System.out.println("\nComputadora encontrada! " + c);
					break;
				case 5:
					imp.contar();
					break;
				case 6:
					imp.eliminarTodo();
					System.out.println("\nSe ha vaciado!\n");
					break;
				case 7:
					System.out.println("Ingrese la marca de la computadora a buscar");
					leer = new Scanner(System.in);
					marca = leer.nextLine();
					
					c = new Computadora();
					c.setMarca(marca);
					
					imp.buscarMarca(c);
					break;
				case 8:
					imp.mostrar();
					break;
				case 9:
					System.out.println("Nos vemos!");
					break;
			}
		}while(menu < 9);
	}
}
