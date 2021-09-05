package com.curso.mibanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.curso.dominio.Banco;
import com.curso.dominio.CheckingAccount;
import com.curso.dominio.Cliente;
import com.curso.dominio.Cuenta;
import com.curso.dominio.GenerarClientes;
import com.curso.dominio.OverdrafException;
import com.curso.dominio.SavingsAccount;

public class Application
{
	
	public static void main( String[] args )
	{
		Cuenta corriente = new CheckingAccount(2000,1500);
		Cuenta ahorro = new SavingsAccount(1000,0);
		
		corriente.deposito(125);
		ahorro.deposito(500);
	
		try {
			
			corriente.reintegro(3500);
			ahorro.reintegro(500);
			
		} catch (OverdrafException e) {
			System.out.println();
			System.out.println("Saldo insuficiente");
			System.out.println();
		}finally {
			
			try {
				corriente.reintegro(1500);
				ahorro.reintegro(500);
				
			} catch (OverdrafException e) {
				// TODO Auto-generated catch block
				System.out.println();
				System.out.println("Saldo insuficiente");
				System.out.println();
			}
			
		}
		
		Banco bbva = new Banco("BBVA");
		bbva.addCliente("Ordoño", "Ndong");
		bbva.addCliente("Iker", "Gimenez");
		
		Banco santander = new Banco("SANTANDER");
		santander.addCliente("Gorka", "García");
		santander.addCliente("Teofilo", "Nguema");
		santander.addCliente("Sandra", "Basilisa");
		
		Cliente gorka,teofilo,sandra,ordoño,iker;
		gorka = santander.getCliente(0);
		sandra = santander.getCliente(1);
		teofilo = santander.getCliente(2);
		ordoño = bbva.getCliente(0);
		iker = bbva.getCliente(1);
		
		
		ordoño.addCuenta(ahorro);
		sandra.addCuenta(new CheckingAccount(1000,1500));
		iker.addCuenta(corriente);
		
		GenerarClientes generar = new GenerarClientes();
		generar.generarClientes(santander);
		generar.generarClientes(bbva);
		
	}
	
	
	
	
}