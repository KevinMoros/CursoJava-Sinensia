package com.cursojava.excepcionesp;

// Clase para crear una excepción personalizada.
public class PersonalizadaExcepction extends Exception {
	String texto;

	public PersonalizadaExcepction(String texto) {
		super();
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "ExceptionPersonalizada [Aviso = " + texto + "]";
	}
	
	
}
