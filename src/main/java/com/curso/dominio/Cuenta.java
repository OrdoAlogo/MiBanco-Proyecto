package com.curso.dominio;

public class Cuenta {
	private double saldo;

	public Cuenta(double saldo) {
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
			 this.saldo += importe;
			 System.out.println("OPERACION REALIZADA CON EXITO");
			 System.out.println("Su saldo actual es: "+this.saldo);
		 }
	 }
	 
	 public void reintegro(double importe) {
		 if(importe > this.saldo) {
			 
			 System.out.println("No tienes saldo suficiente en la cuenta");
		 }
		 else {
			 this.saldo = this.saldo - importe;
			 System.out.println("OPERACION REALIZADA CON ÉXITO");
			 System.out.println("Importe reintegro " +importe+ " Saldo Actual: "+this.saldo);
		 }
	 }

	@Override
	public String toString() {
		return "Cuenta saldo actual " + saldo ;
	}
	
	
}
