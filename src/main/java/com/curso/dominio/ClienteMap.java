package com.curso.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteMap {
	private String nombre;
	private String apellidos;
	private LocalDate fechaAlta;
	private List<Cuenta> cuentas;
	
	
	public ClienteMap(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaAlta = LocalDate.now();
		this.cuentas = new ArrayList<Cuenta>();
		
	}
	
	public ClienteMap(String nombre, String apellidos, LocalDate fechaAlta) {
		
		this(nombre,apellidos);
		this.fechaAlta = LocalDate.now();
			
	}


	public int getNumeroDeCuentas() {
		return cuentas.size();
	}


	public Cuenta getCuentas(int cuenta) {
		return cuentas.get(cuenta);
	}


	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void addCuenta(Cuenta cuenta) {
		cuentas.add(cuenta);
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	

	
	
	
	
	

}
