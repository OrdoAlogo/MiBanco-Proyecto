package com.curso.dominio;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Banco {
	
	
	String nombre;
	private Cliente[] clientes;
	private int numClientes;
	
	public Banco(String nombre) {
		
		this.clientes = new Cliente[5];
		this.numClientes = 0;
		this.nombre = nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void addCliente(String nombre, String apellidos) {
		int p = numClientes++;
		clientes[p] = new Cliente(nombre,apellidos);
	}

	public int getNumClientes() {
		return numClientes;
	}
	
	public Cliente getCliente(int posicion) {
		return this.clientes[posicion];
	}
	
	
	
	
}
