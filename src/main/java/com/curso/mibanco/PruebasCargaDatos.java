package com.curso.mibanco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import com.curso.dominio.BankMap;
import com.curso.dominio.CheckingAccount;
import com.curso.dominio.ClienteMap;
import com.curso.dominio.Cuenta;
import com.curso.dominio.SavingsAccount;

public class PruebasCargaDatos {
   /*
    * Leer el fichero para crear los clientes del banco
    * Por cada linea leer los datos crear cliente y su cuenta
    * si el tipo de cuenta es C o S asignar a Checking... o Savnig
    * */
	/*Recorrer los clientes del banco mostrando sus cuentas*/
	/*uso clases: Scanner, DateTimeFormat, burrferReader, filereader*/
	public static void main(String[] args) {
		
		ClienteMap cliente;
		Scanner fichero;
		//Leemos el fichero y creamos los clientes
		try {
			int dni = 1;
			fichero = new Scanner(new File("DatosCarga.txt"));
			while(fichero.hasNextLine()) {
				
				String linea = fichero.nextLine();
				cliente = crearCliente(linea);			
				BankMap.addCliente("H"+dni++,cliente);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fichero no encontrado");
		}	
		
		//Recorremos los clientes para imprimirlos
		for(int socio = 1; socio <=BankMap.getNumCliente(); socio++) {
			ClienteMap c = BankMap.getClientes("H"+socio);
			System.out.printf(". Cliente %s %s %tD %n",c.getNombre(),c.getApellidos(),c.getFechaAlta());
			
			Cuenta cta = c.getCuentas(0);
			if(cta instanceof SavingsAccount) {
				SavingsAccount ahorro = (SavingsAccount) cta;
				System.out.printf("Cuenta de Ahorros con saldo %f€ %n",ahorro.getSaldo());
				System.out.println();
			}else {
				CheckingAccount corriente = (CheckingAccount) cta;
				System.out.printf("Cuenta Corriente con saldo %f€ %n",corriente.getSaldo());
				System.out.println();
			}
		}
		
	}
	
	//Funcion para crear el cliente que leemos en el fichero
	private static ClienteMap crearCliente(String linea) {
		Scanner scaner = new Scanner(linea);
		scaner.useDelimiter("#");
		scaner.useLocale(Locale.ENGLISH);
		
		String nombre = scaner.next();
		String apellidos = scaner.next();
		String fecha = scaner.next();
		String tipo = scaner.next();
		double saldo = scaner.nextDouble();
		double  dato = scaner.nextDouble();
			//Formateo la fecha
		DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaAlta = LocalDate.parse(fecha, formateo);
		
		ClienteMap cliente = new ClienteMap(nombre,apellidos,fechaAlta);
		Cuenta cuenta = null;		
				
			switch(tipo) {
				case "S":
					cuenta = new SavingsAccount(saldo,dato);
				case "C":
					cuenta = new CheckingAccount(saldo,dato);
			}
				
		cliente.addCuenta(cuenta);	
		return cliente;
		
	}
}
