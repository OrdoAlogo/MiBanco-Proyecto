package com.curso.mibanco;

import com.curso.dominio.Cliente;
import com.curso.dominio.Cuenta;

public class Application
{
	public static void main( String[] args )
	{
		Cuenta c1 = new Cuenta(100.0);
		c1.deposito(122.5);
		Cliente cl1 = new Cliente("Iker","Jimenez");
		cl1.setCuenta(c1);
		c1.reintegro(570.5);
		System.out.println(cl1);
	}
}