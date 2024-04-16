package com.sinensia.test;

import java.util.ArrayList;
import java.util.List;

import com.sinensia.vehiculos.Coche;
import com.sinensia.vehiculos.Vehiculo;

public class Principal {

	public static void main(String[] args) {

		Vehiculo c = new Coche("1234ABC", "agua", "vinotinto", "madera");

		List<Vehiculo> vehiculos = new ArrayList<>();
		
		vehiculos.add(c);
		
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo instanceof Coche) {
				((Coche) vehiculo).arrancar();
				((Coche) vehiculo).avanzar(50);
				((Coche) vehiculo).parar();
			}
		}

	}

}
