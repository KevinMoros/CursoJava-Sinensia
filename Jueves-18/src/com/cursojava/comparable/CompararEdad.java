package com.cursojava.comparable;

import java.util.Comparator;

/**
 * Clase para comparar mediante diferentes campos.
 */
public class CompararEdad implements Comparator<Cliente> {

	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		
		return cliente1.getEdad() - cliente2.getEdad();
	}

}
