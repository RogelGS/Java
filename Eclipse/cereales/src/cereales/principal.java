package cereales;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class principal {
	public static void main(String[] args) {
		
		//Variables
		String nombre, marca;
		List<cereal> lista = new ArrayList<cereal>();
		int contNet;
		double precio;
		cereal cc = null;
		Scanner leer = null;
		int opcion, submenu;
		
		
		//Ciclo
		do {
			
			//Opciones
			System.out.println("Estas son las opciones");
			System.out.println("1 Alta");
			System.out.println("2 Editar");
			System.out.println("3 Eliminar");
			System.out.println("4 Buscar");
			System.out.println("5 Contar");
			System.out.println("6 Mostrar");
			System.out.println("7 Salir");
			System.out.println("8 Vacia");
			System.out.println("9 Buscar por nombre");
			System.out.println("10 Eliminar todo");
			//Evaluar opcion
			
			//Opción a leer
			leer = new Scanner(System.in);
			opcion = leer.nextInt();

			switch(opcion) {
			//Opcion 1
				case 1:
					System.out.println("Escribe el nombre del cereal");
					leer = new Scanner(System.in);
					nombre = leer.nextLine();
					System.out.println("Escribe el nombre de la marca");
					marca = leer.nextLine();
					System.out.println("Escribe el contenido neto");
					contNet = leer.nextInt();
					System.out.println("Escribe el precio");
					precio = leer.nextDouble();
					
					cc = new cereal(nombre, marca, contNet, precio);
					
					lista.add(cc);
					
					System.out.println("Se ha agrega el cereal" + cc);
					break;
				//OPCION 2
				case 2:
					System.out.println("Escribe el indice a editar");
					//OBTENGO EL INDICE A MODIFICAR
					leer = new Scanner(System.in);
					submenu = leer.nextInt();
					
					//OBTENGO EL PRODUCTO A MODIFICAR
					cc = lista.get(submenu);
									
					//COMIENZA CICLO PARA OPERACION
					do {
						//OPCIONES
						System.out.println("Que deseas modificar");
						System.out.println("1 Nombre");
						System.out.println("2 Marca");
						System.out.println("3 Contenido Neto");
						System.out.println("4 Precio");
						System.out.println("5 Salir");
						
						leer = new Scanner(System.in);
						submenu = leer.nextInt();
						
						//EVALUAR OPCIONES
						switch(submenu) {
						//OPCION 1
							case 1:
								System.out.println("Escribe el nombre del producto");
								leer = new Scanner(System.in);
								nombre = leer.nextLine();
								
								cc.setNombre(nombre);
								break;
						//OPCION 2
							case 2:
								System.out.println("Escribe la marca del producto");
								leer = new Scanner(System.in);
								marca = leer.nextLine();
								
								cc.setMarca(marca);
								break;
						//OPCION 3
							case 3:
								System.out.println("Escribe el contenido neto del producto");
								leer = new Scanner(System.in);
								contNet = leer.nextInt();
								
								cc.setContNet(contNet);
								break;
						//OPCION 4
							case 4:
								System.out.println("Escribe el precio del producto");
								leer = new Scanner(System.in);
								precio = leer.nextDouble();
								
								cc.setPrecio(precio);
								break;
						//OPCION 5 SALIR
							case 5:
								break;
							}
						}while(submenu < 5);
					
					break;
				case 5:
					System.out.println(lista.isEmpty() ? "La lista esta vacia":  "La lista no esta vacia");
					break;
				case 6:
					System.out.println("La lista tiene una longitud de "+ lista.size());
					break;
				
				case 8:
					lista.clear();
					System.out.println("Se ha vaciado la lista");
					break;
			}
		}while(opcion != 7);
		//Termina ciclo
	}
}
