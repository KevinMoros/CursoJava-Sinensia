package com.cursojava.excepcionesp;

public class Cuenta {

	private String titular;
	private double saldo;
	private EstadoCuenta estadoCuenta; // En el mundo real EstadoCuenta.OPERATIVA

	public Cuenta(String titular, double saldo, EstadoCuenta estadoCuenta) {
		super();
		this.titular = titular;
		this.saldo = saldo;
		this.estadoCuenta = estadoCuenta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}



	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public EstadoCuenta getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public double ingreso(double cantidad) throws PersonalizadaExcepction {
		
		if (cantidad < 0) throw new PersonalizadaExcepction("La cantidad ingresar no puede ser negativa");
		
		if(estadoCuenta == EstadoCuenta.BLOQUEADA) throw new IllegalStateException("No puede ingresar dinero. Cuenta bloqueada.");
		
		double nSaldo = saldo += cantidad;
		System.out.println("Saldo en la cuenta: " + getSaldo() + " €.");
		System.out.println("Ingreso realizado correctamente.");
		System.out.println("Dinero ingresado: " + cantidad + " €.");
		
		System.out.println("Saldo disponible: " + nSaldo + " €.");
		
		return saldo;
	}

	public double reintegro(double cantidad) throws PersonalizadaExcepction {

		// if(cantidad < 0) throw new PersonalizadaExcepction("La cantidad no puede ser
		// inferior a 0."); {
		// Se lanza una excepción personalizada

		if (estadoCuenta == EstadoCuenta.NUM_ROJOS)
			throw new IllegalStateException("Cuenta en numeros rojos.");

		if (estadoCuenta == EstadoCuenta.BLOQUEADA)
			throw new IllegalStateException("Cuenta bloqueada, hablar con el director.");

		double nSaldo = saldo -= cantidad;
		
		System.out.println("Se han retirado: " + cantidad + " €.");
		System.out.println("Saldo disponible: " + nSaldo + " €.");
		return saldo;
	}

}
