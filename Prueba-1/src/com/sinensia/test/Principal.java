package com.sinensia.test;

import java.util.ArrayList;
import java.util.List;

import com.sinensia.vehiculos.Camion;
import com.sinensia.vehiculos.Coche;
import com.sinensia.vehiculos.Vehiculo;

public class Principal {

	public static void main(String[] args) {

		Vehiculo coche = new Camion("1234ABC", "Gasoleo", "Vinotinto", "Combustion");

		List<Vehiculo> vehiculos = new ArrayList<>();

		vehiculos.add(coche);

		for (Vehiculo vehiculo : vehiculos) {
			System.out.println("====Datos Tacometro====");
			if (vehiculo instanceof Camion) {
				((Camion) vehiculo).arrancar();
				((Camion) vehiculo).avanzar(50, 300);
				((Camion) vehiculo).avanzar(500, 300);
				((Camion) vehiculo).parar();
				
			}
		}

	}

}
