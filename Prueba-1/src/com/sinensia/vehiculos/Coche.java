package com.sinensia.vehiculos;

import java.time.Duration;
import java.time.Instant;

import com.sinensia.interfaces.Conducible;

public class Coche extends Vehiculo implements Conducible {

	protected final static int RUEDAS_DF = 4;

	private int num_Ruedas;
	private boolean enMarcha;
	private Instant inicioViaje;
	private Instant finViaje;
	private double distanciaTotal;
	

	public Coche(String num_Matricula) {
		super(num_Matricula);
		this.num_Ruedas = RUEDAS_DF;
		this.enMarcha = false;
		this.inicioViaje = null;
		this.finViaje = null;
		this.distanciaTotal = 0;
	}

	public Coche(String num_Matricula, String combustible, String color, String motor) {
		super(num_Matricula, combustible, color, motor);
		this.num_Ruedas = RUEDAS_DF;
		this.enMarcha = false;
		this.inicioViaje = null;
		this.finViaje = null;
		this.distanciaTotal = 0;
	}

	public int getNum_Ruedas() {
		return num_Ruedas;
	}
	
	public double getDistanciaTotal() {
		return distanciaTotal;
	}
	
	private double calcularDistanciaRecorrida(long tiempoSegundos) {
		
		double velocidadConstante = 10;
		double distancia = velocidadConstante * tiempoSegundos;
		
		return distancia;
	}
	

	@Override
	public void arrancar() {
		
		if(!enMarcha) {
			enMarcha = true;
			inicioViaje = Instant.now();
			System.out.println("El coche está arrancando.");
		}else {
			System.out.println("El coche ya arrancó.");
		}
	}

	@Override
	public void avanzar(double metros) {

		if(enMarcha) {
			System.out.println("El coche ha avanzado " + metros + " metros.");
			distanciaTotal = getDistanciaTotal() + metros;
		}else {
			System.out.println("No se puede avanzar, el coche no está en marcha.");
		}

	}

	@Override
	public void retroceder(double metros) {
		
		if(enMarcha) {
			System.out.println("El coche ha retrocedido " + metros + " metros.");
			distanciaTotal = getDistanciaTotal() - metros;
		}else {
			System.out.println("El coche no ha arrancado, no se puede retroceder.");
		}

	}

	@Override
	public void parar() {

	    if (enMarcha) {
	        enMarcha = false;
	        finViaje = Instant.now();
	        System.out.println("El coche se ha detenido.");

	        if (inicioViaje != null && finViaje != null) {
	            Duration duracionViaje = Duration.between(inicioViaje, finViaje);
	            long tiempoSegundos = duracionViaje.getSeconds();

	            if (tiempoSegundos > 0) {
	                double distanciaTotal = calcularDistanciaRecorrida(tiempoSegundos);
	                double velocidadMedia = distanciaTotal / tiempoSegundos;

	                System.out.println("Distancia recorrida: " + distanciaTotal + " metros.");
	                System.out.println("Velocidad media: " + velocidadMedia + " m/s.");
	            } else {
	                System.out.println("El tiempo transcurrido ha sido de 0 segundos.");
	            }
	        } else {
	            System.out.println("No hay tiempos registrados de inicio o fin del viaje.");
	        }
	    } else {
	        System.out.println("El coche ya estaba detenido.");
	    }
	}

	@Override
	public String toString() {
		return super.toString() + "\nRuedas: " + num_Ruedas;
	}

}
