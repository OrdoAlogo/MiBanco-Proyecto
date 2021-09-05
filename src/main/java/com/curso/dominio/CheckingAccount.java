package com.curso.dominio;

import java.io.Serializable;

public class CheckingAccount extends Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private double limiteCredito;
		
	public CheckingAccount(double saldoInicial, double limiteCredito) {
		super(saldoInicial);
		this.limiteCredito = limiteCredito;
		
	}
	
	public CheckingAccount(double saldoInicial) {
		super(saldoInicial);
		this.limiteCredito = limiteCredito;
		
	}
	@Override
	public void reintegro(double importeR) throws OverdrafException{
		
		if(this.saldo < importeR) {
			
			double saldoNecesario = importeR - this.saldo;
			if(limiteCredito < saldoNecesario) {
				throw new OverdrafException("Fondos insuficientes",saldoNecesario);
			}else {
				this.saldo = 0.0;
				limiteCredito -= saldoNecesario;
			}
			
		}else {
			 System.out.println("------------------");
			 System.out.println("REINTEGRO con EXITO");
			 System.out.println("Saldo Anterior: "+ this.saldo+ " Reintegro: "+importeR);
			 this.saldo = this.saldo - importeR;
			 System.out.println("Saldo actual: "+ this.saldo);
		}
		
	}
		
}
