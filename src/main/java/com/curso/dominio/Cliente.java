package com.curso.dominio;

import java.util.Arrays;

public class Cliente {
	private String nombre;
	private String apellidos;
	private Cuenta[] cuentas;
	private int numeroDeCuentas;
	
	public Cliente(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cuentas = new Cuenta[5];
		this.numeroDeCuentas = 0;
	}


	public int getNumeroDeCuentas() {
		return numeroDeCuentas;
	}


	public Cuenta getCuentas(int cuenta) {
		return cuentas[cuenta];
	}


	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void addCuenta(Cuenta cuenta) {
		int i = this.numeroDeCuentas++;
		this.cuentas[i] = cuenta;
	}


	
	
	
	
	

}
