package com.cursojava.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase ColeccionList para trabajar con sus métodos
 */
public class ColeccionList {

	public static void main(String[] args) {
		
		List<Integer> listaNumeros = new ArrayList<>();

		
		listaNumeros.add(9);
		listaNumeros.add(7);
		listaNumeros.add(3);
		listaNumeros.add(6);
		listaNumeros.add(1);
		listaNumeros.add(10);
		listaNumeros.add(5);
		listaNumeros.add(2);
		listaNumeros.add(4);
		listaNumeros.add(8);
		
		
		
		Collections.sort(listaNumeros);
		System.out.println("Lista ordenada de menor a mayor\n" + listaNumeros + "\n");
		Collections.reverse(listaNumeros);
		System.out.println("Lista ordenada de mayor a menor\n" +listaNumeros);
	}
}