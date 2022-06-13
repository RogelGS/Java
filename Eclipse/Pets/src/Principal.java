import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String nombre, raza;
		double precio;
		int menu, submenu;
		Scanner leer = null;
		Implementacion imp = new Implementacion();
		Pet p = null;
		
		do {
			System.out.println("1. ALTA");
			System.out.println("2. EDITAR");
			System.out.println("3. ELIMINAR");
			System.out.println("4. BUSCAR");
			System.out.println("5. CONTAR");
			System.out.println("6. MOSTRAR");
			System.out.println("7. SALIR\n");
			
			leer = new Scanner(System.in);
			menu = leer.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("Ingresa el nombre de la mascota");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					System.out.println("Ingresa la raza de la mascota");
					leer = new Scanner(System.in);
					raza = leer.nextLine();
					
					System.out.println("Ingresa el precio de la mascota");
					leer = new Scanner(System.in);
					precio = leer.nextDouble();
					
					p = new Pet(nombre, raza, precio);
					imp.guardar(p.getNombre(), p);
					System.out.println("Mascota agregada " + p + "\n");
					break;
				case 2:
					System.out.println("Ingresa el nombre de la mascota a editar");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					p = (Pet) imp.buscar(nombre);
					
					do {
						System.out.println("1. Editar raza");
						System.out.println("2. Editar precio");
						System.out.println("3. Refresar al menu principal");
						leer = new Scanner(System.in);
						submenu = leer.nextInt();
						
						switch(submenu) {
							case 1:
								System.out.println("Ingresa la raza de la mascota");
								leer = new Scanner(System.in);
								raza = leer.nextLine();
								p.setRaza(raza);
								break;
							case 2:
								System.out.println("Ingresa el precio de la mascota");
								leer = new Scanner(System.in);
								precio = leer.nextDouble();
								
								p.setPrecio(precio);
								break;
							case 3:
								System.out.println("Regresando al menu principal\n");
							break;
						}
					}while(submenu < 3);
					imp.editar(p.getNombre(), p);
					System.out.println("Mascota editada " + p + "\n");
					break;
				case 3:
					System.out.println("Ingresa el nombre de la mascota a eliminar");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					p = (Pet) imp.buscar(nombre);
					imp.eliminar(p.getNombre());
					
					System.out.println("Mascota eliminada " + p + "\n");
					break;
				case 4:
					System.out.println("Ingresa el nombre de la mascota a buscar");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					
					p = (Pet) imp.buscar(nombre);
					System.out.println("Mascota encontrada " + p);
					break;
				case 5:
					imp.contar();
					break;
				case 6:
					imp.mostrar();
					break;
				case 7:
					System.out.println("Nos vemos!");
					break;
			}
		}while(menu < 7);
	}

}
