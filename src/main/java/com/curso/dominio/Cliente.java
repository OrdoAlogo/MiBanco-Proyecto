package com.curso.dominio;

public class Cliente {
	private String nombre;
	private String apellidos;
	private Cuenta cuenta;
	
	public Cliente(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	@Override
	public String toString() {
		return "Cliente: " + nombre + " " + apellidos + ", Saldo=" + cuenta;
	}
	
	

}
