import java.util.Scanner;

public class Principal {
	public static void main(String args[]) {
		String modelo, marca;
		double precio, numero;
		int menu, submenu;
		Tennis t = null;
		Scanner leer = null;
		
		do {
			
			System.out.println("1. Alta");
			System.out.println("2. Editar");
			System.out.println("3. Eliminar");
			System.out.println("4. Buscar");
			System.out.println("5. Mostrar");
			System.out.println("6. Contar");
			System.out.println("7. Salir\n");
			
			leer = new Scanner(System.in);
			menu = leer.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("ESCRIBE EL MODELO DE LOS TENNIS");
					leer = new Scanner(System.in);
					modelo = leer.nextLine();
					
					System.out.println("ESCRIBE LA MARCA DE LOS TENNIS");
					leer = new Scanner(System.in);
					marca = leer.nextLine();
					
					System.out.println("ESCRIBE EL PRECIO DE LOS TENNIS");
					leer = new Scanner(System.in);
					precio = leer.nextDouble();
					
					System.out.println("ESCRIBE EL NUMERO DE LOS TENNIS");
					leer = new Scanner(System.in);
					numero = leer.nextDouble();
					
					t = new Tennis(modelo, marca, precio, numero);
					Implementacion.guardar(t.getNumero(), t);
					
					System.out.println("Se ha guardado correctamente " + t);
					break;
				case 2:
					System.out.println("ESCRIBE EL NUMERO DE LOS TENNIS");
					leer = new Scanner(System.in);
					numero = leer.nextDouble();
					
					t = (Tennis) Implementacion.buscar(numero);
					
					do {
						System.out.println("1. Editar Marca");
						System.out.println("2. Editar precio");
						System.out.println("3. Regresar al menu principal\n");
						leer = new Scanner(System.in);
						submenu = leer.nextInt();
						
						switch(submenu) {
							case 1:
								System.out.println("ESCRIBE LA MARCA DE LOS TENNIS");
								leer = new Scanner(System.in);
								marca = leer.nextLine();
								
								t.setMarca(marca);
								break;
							case 2:
								System.out.println("ESCRIBE EL PRECIO DE LOS TENNIS");
								leer = new Scanner(System.in);
								precio = leer.nextDouble();
								
								t.setPrecio(precio);
								break;
							case 3:
								System.out.println("Regresando al menu principal\n");
								break;
						}
					}while(submenu < 3);
					
					Implementacion.editar(t.getNumero(), t);
					break;
				case 3:
					System.out.println("ESCRIBE EL NUMERO DE LOS TENNIS");
					leer = new Scanner(System.in);
					numero = leer.nextDouble();
					
					t = (Tennis) Implementacion.buscar(numero);
					Implementacion.eliminar(t.getNumero());
					
					System.out.println("Se ha eliminado el item " + t + "\n");
					break;
				case 4:
					System.out.println("ESCRIBE EL NUMERO DE LOS TENNIS");
					leer = new Scanner(System.in);
					numero = leer.nextDouble();
					
					t = (Tennis) Implementacion.buscar(numero);
					
					System.out.println(t + "\n");
					break;
				case 5:
					Implementacion.mostrar();
					break;
				case 6:
					Implementacion.contar();
					break;
				case 7:					
					System.out.println("Saliendo!\n");
					break;
			}
		}while(menu < 7);
	}
}
