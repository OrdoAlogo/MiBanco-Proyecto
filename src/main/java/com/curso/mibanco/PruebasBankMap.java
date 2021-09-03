package com.curso.mibanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.curso.dominio.BankMap;
import com.curso.dominio.CheckingAccount;
import com.curso.dominio.Cliente;
import com.curso.dominio.ClienteMap;
import com.curso.dominio.Cuenta;
import com.curso.dominio.SavingsAccount;

public class PruebasBankMap {

	public static void main(String[] args) {
		ClienteMap sandra,ordoño,cliente;
		sandra = new ClienteMap("Sandra","Basilisa");
		ordoño = new ClienteMap("Ordoño", "Ndong");
		
		Cuenta ahorro,corriente,cuenta;
		ahorro = new SavingsAccount(1000,0);
		corriente = new CheckingAccount(500,0);
		
		sandra.addCuenta(ahorro);
		ordoño.addCuenta(corriente);
		
		BankMap.addCliente("0001S", sandra);
		BankMap.addCliente("0002O", ordoño);
		//cliente = BankMap.getClientes("0001S");
		cliente = BankMap.getClientes("0002O");
		cuenta = cliente.getCuentas(0);
		
		System.out.println("Cliente: "+cliente.getNombre()+" "+cliente.getApellidos()+" Balance: " +cuenta.balance()+ " Saldo: "+cuenta.getSaldo());
		System.out.println("............");
		
		//Set<ClienteMap> clientes = new TreeSet<ClienteMap>();
		List<ClienteMap> clientes = new ArrayList<ClienteMap>();
		try {
			
			clientes.add(ordoño);
			clientes.add(sandra);
			
			for(ClienteMap c:clientes) {
				System.out.println("Nombre: "+c.getNombre()+" Apellidos: "+c.getApellidos()+" Saldo: "+c.getCuentas(0).getSaldo()+"€");
			}
		}catch(ClassCastException e) {
			System.out.println("Algo ha fallado");
		}
		
		
		
		
		
		
	}

}
