package com.sinensia.vehiculos;

import java.util.ArrayList;
import java.util.List;

import com.sinensia.interfaces.Conducible;

/**
 * Clase Camión que extiende de Vehiculo e mplementa la interfaz Conducible
 */
public class Camion extends Vehiculo implements Conducible {

	// Lista que almacenara velocidades
	private List<Double> tacometro;

	public Camion(String num_Matricula, String combustible, String color, String motor) {
		super(num_Matricula, combustible, color, motor);
		this.tacometro = new ArrayList<>();
	}

	public List<Double> getTacometro() {
		return tacometro;
	}

	/**
	 * Sobreescritura del metodo calcular velocidad de la clase padre.
	 * Si el tacometro no tiene datos no calcula nada.
	 * 
	 */
	@Override
	protected void calcularVelocidad(double distancia, double tiempo) {
	    if (tacometro.isEmpty()) {
	        System.out.println("No hay datos en el tacómetro para calcular la velocidad media.");
	    } else {
	        double sumaVelocidades = 0.0;

	        for (double velocidad : tacometro) {
	            sumaVelocidades += velocidad;
	        }

	        double velocidadMedia = sumaVelocidades / tacometro.size();
	        System.out.println("La velocidad media de todo recorrido fue: " + velocidadMedia + " m/s.\n");
	    }
	}


	/**
	 * Sobreescritura del método parar de la interfaz Conducible.. Se llamara al
	 * metodo calcularVelocidad. Imprimirá que el camión se ha parado.
	 */
	@Override
	public void parar() {

		if (enMarcha) {
			System.out.println("El camión se ha parado.\n");

			enMarcha = false;

			// Asigno el valor de la variable tiempo a tiempoFinal para saber cuando termina
			// el recorrido.
			tiempoFinal = tiempo;
			System.out.println("Tiempo final de viaje: " + tiempoFinal + " segundos.\n");
			System.out.println("Distancia total recorrida: " + distanciaTotal + " metros.\n");
			System.out.println("Tiempo total del viaje: " + tiempoTotal + " segundos.\n");
			calcularVelocidad(distanciaTotal, tiempoTotal);

		} else {
			System.out.println("El camion ya esta parado.\n");
		}
	}

	/**
	 * Sobreescritura del método arrancar de la interfaz Conducible.
	 */
	@Override
	public void arrancar() {
		if (!enMarcha) {
			System.out.println("El camion está arrancando.\n");
			enMarcha = true;
			// Reinicio el tiempo al iniciar cada viaje
			tiempo = 0;
		} else {
			System.out.println("El camion ya ha arrancado.\n");
		}
	}

	/**
	 * Sobreescritura del metodo avanzar de la interfaz Counducible.
	 */
	@Override
	public void avanzar(double distancia, double tiempo) {

		// El tiempo introducido por parametro se le añade al tiempo del constructor(Se
		// actualiza)
		this.tiempo += tiempo;

		// Se actualiza el tiempoTotal de los viajes
		tiempoTotal += tiempo;

		// Se actualiza la distancia recorrida
		espacioRecorrido += distancia;

		// Se actualiza la distancia total
		distanciaTotal += distancia;
		
		
		double velocidad = Math.round((distancia/tiempo) * 100.0) / 100.0;
		
	    tacometro.add(velocidad);

		System.out.println("Se ha avanzado " + distancia + " m en " + tiempo + " segundos.");
		System.out.println("La velocidad media del recorrido es : " + velocidad + " m/s.\n");
		calcularVelocidad(distanciaTotal, tiempoTotal);
	}

	@Override
	public void retroceder(double distancia) {

		System.out.println("Retrocediendo " + distancia + " metros.\n");

	}

	@Override
	public String toString() {
		return super.toString();
	}

}
