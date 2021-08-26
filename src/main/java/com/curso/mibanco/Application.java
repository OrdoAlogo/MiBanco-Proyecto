package com.curso.mibanco;

import com.curso.dominio.CheckingAccount;
import com.curso.dominio.Cliente;
import com.curso.dominio.Cuenta;
import com.curso.dominio.OverdrafException;
import com.curso.dominio.SavingsAccount;

public class Application
{
	public static void main( String[] args )
	{
		Cuenta c1 = new SavingsAccount(10,0.0);
		c1.deposito(170.5);
		c1.deposito(70.5);
		try {
			c1.reintegro(25.5);
		} catch (OverdrafException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		Cliente cl1 = new Cliente("Iker","Jimenez");
		cl1.setCuenta(c1);
		System.out.println(cl1);
		System.out.println("Balance: "+c1.balance()+", Saldo actual: "+ c1.getSaldo());
		
		Cuenta corriente = new CheckingAccount(1500,0);
		System.out.println("Cuenta corriente: "+corriente);
		corriente.deposito(20);
		try {
			corriente.reintegro(100);
			corriente.reintegro(510);
			
			
		}catch(OverdrafException e) {
			e.getMessage();
		}
		
		
		
		
	}
}