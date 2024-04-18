package com.sinensia.principal;

import java.util.ArrayList;
import java.util.List;

import com.sinensia.vehiculos.Camion;
import com.sinensia.vehiculos.Coche;
import com.sinensia.vehiculos.Vehiculo;

public final class Principal {

	public static void main(String[] args) {
		Vehiculo camion = new Camion("1234ABC", "Gasoleo", "Vinotinto", "Combustion");

		Vehiculo coche = new Coche("1234ABC", "Gasoleo", "Vinotinto", "Combustion");

		List<Vehiculo> vehiculos = new ArrayList<>();

		vehiculos.add(coche);
		vehiculos.add(camion);

		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo instanceof Camion) {
				System.out.println(camion + "\n");
				((Camion) vehiculo).arrancar();
				((Camion) vehiculo).avanzar(3000, 300);
				((Camion) vehiculo).parar();
				((Camion) vehiculo).arrancar();
				((Camion) vehiculo).avanzar(50, 300);
				((Camion) vehiculo).parar();
				
			}

		}

	}
}
