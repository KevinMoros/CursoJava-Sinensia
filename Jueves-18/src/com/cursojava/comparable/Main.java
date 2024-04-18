package com.cursojava.comparable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pruebas con el comprobar el comparator y el compareTo
 */
public class Main {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Jose", "Rodriguez", 1, "Y9765095G");
		Cliente c2 = new Cliente("Ramon", "Molina", 26, "Y6766395G");
		Cliente c3 = new Cliente("Raquel", "Vello", 16, "Y5766395G");

		Cliente c4 = new Cliente("Luis", "Molina", 80, "Y1236395G");
		Cliente c5 = new Cliente("Manuel", "Vello", 66, "Y5676395G");

		List<Cliente> clientes = new ArrayList<>();

		List<Cliente> clientes2 = new ArrayList<Cliente>();

		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);

		clientes2.add(c4);
		clientes2.add(c5);

		// Ordena los clientes según lo hayamos indicado en el metodo compareTo de la
		// interfaz Comparable.

		// Collections.sort(clientes);

		Comparator<Cliente> ordenPorEdad = new CompararEdad();

		clientes.sort(ordenPorEdad);

		clientes2.sort(ordenPorEdad);

		// Otra manera de comprar por el campo especificado
		// clientes.sort(Comparator.comparing(Cliente::getEdad));

		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		for (Cliente cliente : clientes2) {
			System.out.println(cliente);
		}
	}

}
