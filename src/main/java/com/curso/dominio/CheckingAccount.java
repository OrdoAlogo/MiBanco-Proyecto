package com.curso.dominio;

import java.io.Serializable;

public class CheckingAccount extends Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private double limiteCredito;
		private double saldoInicial;
		
	public CheckingAccount(double saldoInicial, double limiteCredito) {
		super(saldoInicial);
		this.limiteCredito = 5000;
		
	}
	
	public CheckingAccount(double saldoInicial) {
		super(saldoInicial);
		this.limiteCredito = 5000;
		
	}
	@Override
	public boolean reintegro(double importeR) throws OverdrafException{
		boolean result = false;
		double debito = this.saldoInicial - importeR;
		
		if(this.limiteCredito < debito) {
			
			result = false;
			throw new OverdrafException("Limite agotado",(this.limiteCredito-debito));
			
		}if(this.limiteCredito > debito) {
			
			result = true;
			
		}
		
		return super.reintegro(importeR);
		
	}
	
	
	
	
	
	

}
