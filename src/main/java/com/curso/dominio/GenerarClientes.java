package com.curso.dominio;

public class GenerarClientes {
	
	private Banco banco;

	public GenerarClientes() {
		
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	public void generarClientes(Banco banco) {
		System.out.println();
		System.out.println(" CLIENTES DEL BANCO " + banco.getNombre() );
		
		//Recorremos el listado de cliente que contiene el banco
		for(int indice_cliente = 0; indice_cliente < banco.getNumClientes(); indice_cliente++) {
			
			Cliente cliente = banco.getCliente(indice_cliente);
			
			System.out.println();
			System.out.println("Cliente: "+cliente.getNombre()+" "+cliente.getApellidos());
			
			//Ahorra recorremos las cuentas que contiene cada cliente
			for(int indice_cuenta = 0; indice_cuenta < cliente.getNumeroDeCuentas(); indice_cuenta++ ) {
				
				Cuenta cuenta = cliente.getCuentas(indice_cuenta);
				String tipo_c = "";
				//Separamos los tipos de cuentas
				if(cuenta instanceof SavingsAccount ) {
					tipo_c = "Ahorros ";
				}else if(cuenta instanceof CheckingAccount) {
					tipo_c = "Corriente ";
				}else {
					tipo_c = "Desconocida";
				}
				
				//Imprimimos los valores de las cuentas
				System.out.println("Tipo de Cuenta: "+tipo_c + " Saldo actual: "+cuenta.saldo+ " Balance: "+cuenta.balance());
			}
			
		}
	}

}
