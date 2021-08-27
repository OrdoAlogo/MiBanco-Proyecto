package com.curso.mibanco;

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
		Cuenta corriente = new CheckingAccount(2000,0);
		corriente.deposito(125);
		corriente.deposito(50);
		
		Cuenta ahorro = new SavingsAccount(1000,0);
		Cuenta ahorro2 = new SavingsAccount(700,0);
		Cuenta ahorro3 = new SavingsAccount(1500,0);
		Cuenta corriente2 = new CheckingAccount(2100,0);
		ahorro.deposito(500);
		ahorro.deposito(55);
		
		try {
			corriente.reintegro(250);
			ahorro.reintegro(5500);
			
		} catch (OverdrafException e) {
			e.getMessage();
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
		iker.addCuenta(corriente);
		gorka.addCuenta(corriente2);
		sandra.addCuenta(ahorro3);
		teofilo.addCuenta(ahorro2);
		
		GenerarClientes generar = new GenerarClientes();
		generar.generarClientes(santander);
		generar.generarClientes(bbva);
		
		
	}
}