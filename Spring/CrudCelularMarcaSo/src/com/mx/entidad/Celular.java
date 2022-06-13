package com.mx.entidad;

public class Celular {

	String modelo;
	double precio;
	int ram;
	int rom;
	Marca marca;
	So so;

	public Celular() {
		// TODO Auto-generated constructor stub
	}

	public Celular(String modelo) {
		this.modelo = modelo;
	}

	public Celular(String modelo, double precio, int ram, int rom, Marca marca, So so) {
		this.modelo = modelo;
		this.precio = precio;
		this.ram = ram;
		this.rom = rom;
		this.marca = marca;
		this.so = so;
	}

	@Override
	public String toString() {
		return "[modelo=" + modelo + ", precio=" + precio + ", ram=" + ram + ", rom=" + rom + ", marca=" + marca
				+ ", so=" + so + "]\n";
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getRom() {
		return rom;
	}

	public void setRom(int rom) {
		this.rom = rom;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public So getSo() {
		return so;
	}

	public void setSo(So so) {
		this.so = so;
	}

}
