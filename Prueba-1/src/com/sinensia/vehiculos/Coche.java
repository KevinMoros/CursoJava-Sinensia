package com.sinensia.vehiculos;

import com.sinensia.interfaces.Conducible;

/**
 * Clase Coche que extiende de Vehiculo e implementa la interfaz Conducible
 * 
 * @author Kevin
 */
public class Coche extends Vehiculo implements Conducible {

	protected final static int RUEDAS_DF = 4;

	private int num_Ruedas;

	public Coche(String num_Matricula, String combustible, String color, String motor) {
		super(num_Matricula, combustible, color, motor);
		this.num_Ruedas = RUEDAS_DF;
	}

	public int getNum_Ruedas() {
		return num_Ruedas;
	}

	/**
	 * Sobreescritura del método arrancar de la interfaz Conducible. Se verifica si
	 * esta en marcha o no.
	 */
	@Override
	public void arrancar() {

		if (!enMarcha) {
			System.out.println("El coche está arrancando.\n");
			enMarcha = true;
			// Reinicio el tiempo al iniciar cada viaje
			tiempo = 0;
		} else {
			System.out.println("El coche ya ha arrancado.\n");
		}

	}

	/**
	 * Sobreescritura del metodo avanzar de la interfaz Conducible
	 * 
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

		System.out.println("Se ha avanzado " + distancia + " m en " + tiempo + " segundos.\n");
	}

	/**
	 * Sobreescritura del metodo retroceder
	 */
	@Override
	public void retroceder(double distancia) {

		System.out.println("Retrocediendo " + distancia + " metros.\n");
	}

	/**
	 * Sobreescritura del metodo parar de la interfaz Conducible. Si esta en marcha
	 * el coche se para y se actualiza su estado a false. Se imprimen el tiempo
	 * final, la distancia total y el tiempo total del viaje.
	 */
	@Override
	public void parar() {

		if (enMarcha) {
			System.out.println("El coche ha parado.\n");

			enMarcha = false;

			// Asigno el valor de la variable tiempo a tiempoFinal para saber cuando termina
			// el recorrido.
			tiempoFinal = tiempo;
			System.out.println("Tiempo final de viaje: " + tiempoFinal + " segundos.\n");
			System.out.println("Distancia total recorrida: " + distanciaTotal + " metros.\n");
			System.out.println("Tiempo total del viaje: " + tiempoTotal + " segundos.\n");

			// Calculo la velocidad media del viaje
			calcularVelocidad(distanciaTotal, tiempoTotal);

		} else {
			System.out.println("El coche ya esta parado.\n");
		}

	}

	@Override
	public String toString() {
		return super.toString();
	}
}
