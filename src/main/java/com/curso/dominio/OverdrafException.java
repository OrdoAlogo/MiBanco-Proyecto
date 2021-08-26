package com.curso.dominio;

public class OverdrafException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double deficit;
	
	public OverdrafException(String mensajeError,double deficit) {
		super(mensajeError);
		this.deficit = deficit;
	}

	public double getDeficit() {
		return deficit;
	}
	
	
	
}
