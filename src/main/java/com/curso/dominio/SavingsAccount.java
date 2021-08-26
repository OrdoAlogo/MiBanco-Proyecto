package com.curso.dominio;

import java.io.Serializable;

public class SavingsAccount extends Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double interesRate;
	public SavingsAccount(double saldo,double interesRate) {
		super(saldo);
		this.interesRate = 0.03;
		
	}
	

	@Override
	public double balance() {
	
		return this.saldo+(this.interesRate*this.saldo);

	}



	
	

	
}
