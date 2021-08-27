package com.curso.dominio;

import java.io.Serializable;

public abstract class Cuenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double saldo;

	protected Cuenta(double saldo) {
		super();
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	 public void deposito(double importe) {
		 if(importe < 0) {
			 System.out.println("Ingrese una cantidad Positiva");
		 }
		 else {
			 System.out.println("------------------");
			 System.out.println("INGRESO CON EXITO");
			 System.out.println("Saldo Anterior: "+this.saldo+" Ingreso: "+importe);
			 this.saldo = this.saldo+importe;
			 System.out.println("Su saldo actual es: "+this.saldo);
			 
		 }
	 }
	 
	 public boolean reintegro(double importeR) throws OverdrafException {
		 boolean result = false;
		 
		 if(importeR >= saldo) {
			 
			 System.out.println("Saldo insuficiente");
			 System.out.println("------------------");
			 result = false;
			 
		 }if(importeR <= saldo) {
			 System.out.println("------------------");
			 System.out.println("REINTEGRO con EXITO");
			 System.out.println("Saldo Anterior: "+ this.saldo+ " Reintegro: "+importeR);
			 saldo = saldo - importeR;
			 System.out.println("Saldo actual: "+ this.saldo);
			
			 result = true;
		 }
		 
		 return result;
	 }
	 
	 
	 public double balance() {
		 return this.saldo;
	 }

	
	
	
}
