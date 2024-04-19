package com.cursojava.excepcionesp;

public class Principal {

	public static void main(String[] args) {

		Cuenta c = new Cuenta("Pepe", 20000.0, EstadoCuenta.OPERATIVA);

		try {
			c.ingreso(1);
			c.reintegro(20000.0);
		} catch (PersonalizadaExcepction e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
