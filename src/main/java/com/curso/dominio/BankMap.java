package com.curso.dominio;
import java.util.Map;
import java.util.HashMap;
public class BankMap {

	private static Map<String, ClienteMap> clientes;
	static {
		clientes = new HashMap<String, ClienteMap>();
	}
	private BankMap() {
		
	}
	
	public static void addCliente( String dni, ClienteMap c) {
		clientes.put(dni, c);
	}
	public static int getNumCliente() {
		return clientes.size();
	}
	public static ClienteMap getClientes(String dni) {
		return clientes.get(dni);
	}
	
	
}
