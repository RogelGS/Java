package com.mx.genral;

import java.util.Scanner;

import com.mx.entidad.Celular;
import com.mx.entidad.Marca;
import com.mx.entidad.So;
import com.mx.implementacion.ImpCelular;
import com.mx.implementacion.ImpMarca;
import com.mx.implementacion.ImpSo;

public class Principal {

	public static void main(String[] args) {

		ImpCelular impC = new ImpCelular();
		ImpMarca impM = new ImpMarca();
		ImpSo impS = new ImpSo();

		/* Guardar So con codigo Duro */
		So so = new So("Android", "Libre", "Todas");
		impS.guardar(so);
		so = new So("Iphone", "Paga", "Todas");
		impS.guardar(so);

		/* Guardar Marca con codigo Duro */
		Marca m = new Marca("Samsung", "Korea", 100);
		impM.guardar(m);
		m = new Marca("Motorola", "USA", 90);
		impM.guardar(m);
		m = new Marca("Iphone", "Usa", 200);
		impM.guardar(m);

		String nombre;

		String modelo;
		double precio;
		int ram;
		int rom;

		Celular cel = null;

		int menu = 0, menuE;
		Scanner lec = null;
		do {
			try {
				System.out.println("Menu Tienda de Celular Enucom");
				System.out.println("1 alta celular");
				System.out.println("2 mostrar celular");
				System.out.println("3 editar celular");
				System.out.println("4 eliminar celular");
				System.out.println("5 buscar celular");
				System.out.println("6 buscar por marca");
				System.out.println("7 salir");

				lec = new Scanner(System.in);
				menu = lec.nextInt();

				switch (menu) {
				case 1:
					System.out.println("OCPION ALTA DE CELUALR");

					System.out.println("Escribe el modelo del celular");
					lec = new Scanner(System.in);
					modelo = lec.nextLine();

					System.out.println("Escribe el precio del celular");
					lec = new Scanner(System.in);
					precio = lec.nextDouble();

					System.out.println("Escribe la ram del celular");
					lec = new Scanner(System.in);
					ram = lec.nextInt();

					System.out.println("Escribe la rom del celular");
					lec = new Scanner(System.in);
					rom = lec.nextInt();

					impS.mostrar();
					System.out.println("Escribe el nombre del sistema operativo a seleccionar");
					lec = new Scanner(System.in);
					nombre = lec.nextLine();
					so = new So(nombre);
					so = (So) impS.buscar(so);

					impM.mostrar();
					System.out.println("Escribe el nombre del la marcao a seleccionar");
					lec = new Scanner(System.in);
					nombre = lec.nextLine();
					m = new Marca(nombre);
					m = (Marca) impM.buscar(m);

					cel = new Celular(modelo, precio, ram, rom, m, so);
					impC.guardar(cel);
					System.out.println("Se guardo el celular " + cel.getModelo() + " correctamente");
					break;
				case 2:
					impC.mostrar();
					break;
				case 3:
					System.out.println("OPCION EDITAR");

					System.out.println("Escribe el modelo del celular a editar");
					lec = new Scanner(System.in);
					modelo = lec.nextLine();
					cel = new Celular(modelo);
					cel = (Celular) impC.buscar(cel);
					do {
						System.out.println("Menu Editar");
						System.out.println("1 precio");
						System.out.println("2 Marca");
						System.out.println("3 So");
						System.out.println("4 Menu Principal");

						lec = new Scanner(System.in);
						menuE = lec.nextInt();

						switch (menuE) {
						case 1:
							System.out.println("Escribe el nuevo precio del celular");
							lec = new Scanner(System.in);
							precio = lec.nextDouble();
							cel.setPrecio(precio);
							break;
						case 2:
							impM.mostrar();
							System.out.println("Escribe la nueva marcao a seleccionar");
							lec = new Scanner(System.in);
							nombre = lec.nextLine();
							m = new Marca(nombre);
							m = (Marca) impM.buscar(m);
							cel.setMarca(m);
							break;
						case 3:
							impS.mostrar();
							System.out.println("Escribe el nombre del nuevo sistema operativo a seleccionar");
							lec = new Scanner(System.in);
							nombre = lec.nextLine();
							so = new So(nombre);
							so = (So) impS.buscar(so);
							cel.setSo(so);
							break;
						}// cierra switchEditar
					} while (menuE < 4);
					impC.editar(cel);
					System.out.println("Se edito el celular " + cel);
					break;
				case 4:
					System.out.println("Escribe el modelo del celular a eliminar");
					lec = new Scanner(System.in);
					modelo = lec.nextLine();
					impC.eliminar(new Celular(modelo));
					System.out.println("Se elimino el modelo del celular " + modelo);
					break;
				case 5:
					System.out.println("Escribe el modelo del celular a buscar");
					lec = new Scanner(System.in);
					modelo = lec.nextLine();
					cel = new Celular(modelo);
					cel = (Celular) impC.buscar(cel);
					System.out.println("Celular encontrado->" + cel);
					break;
				case 6:
					impM.mostrar();
					System.out.println("Escribe la marca para buscar celular");
					lec = new Scanner(System.in);
					nombre = lec.nextLine();
					m = new Marca(nombre);
					impC.buscarByMarca(m);

					break;
				case 7:
					System.out.println("bye");
					break;
				}// cierra switch
			} catch (Exception e) {
				System.out.println("Error, favor de intentar nuevametne");
			}
		} while (menu < 7);
	}// cierra main
}// cierra principal
