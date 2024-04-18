package com.sinensia.vehiculos;

import com.sinensia.enums.Color;
import com.sinensia.enums.TipoCombustible;
import com.sinensia.enums.TipoMotor;

/**
 * Clase Vehiculo. Posee constantes por defecto para el tipo de combustible,
 * color y motor. Posee atributos como num_Matricula, combustible, color, tipo
 * de motor. En mi enfoque al programa considero que todos los vehiculo tienen
 * tiempo, tiempoFinal, distancia, distanciaTotal, tiempoTotal y si está en
 * marcha.
 * 
 * @author Kevin.
 *
 */
public abstract class Vehiculo {

	protected final static TipoCombustible TIPO_COMBUSTIBLE_DF = TipoCombustible.GASOLINA;
	protected final static Color COLOR_DF = Color.ROJO;
	protected final static TipoMotor MOTOR_DF = TipoMotor.COMBUSTION;

	protected final String num_Matricula;
	protected TipoCombustible combustible;
	protected Color color;
	protected TipoMotor motor;
	protected int espacioRecorrido;
	protected double tiempo;
	protected double tiempoFinal;
	protected double distancia;
	protected double distanciaTotal;
	protected double tiempoTotal;
	protected boolean enMarcha;

	/**
	 * En el constructor inicializo las variables espacioRecorrido, teimpo,
	 * tiempoFinal, distancia, distanciaTotal y tiempoTotal a 0
	 * 
	 * @param num_Matricula
	 * @param combustible
	 * @param color
	 * @param motor
	 */
	public Vehiculo(String num_Matricula, String combustible, String color, String motor) {
		super();
		this.num_Matricula = num_Matricula;
		this.combustible = comprobarTipoCombustible(combustible);
		this.color = comprobarColor(color);
		this.motor = comprobarTipoMotor(motor);
		this.espacioRecorrido = 0;
		this.tiempo = 0;
		this.tiempoFinal = 0;
		this.distancia = 0;
		this.distanciaTotal = 0;
		this.tiempoTotal = 0;
		
	}

	public String getNum_Matricula() {
		return num_Matricula;
	}

	public TipoCombustible getCombustible() {
		return combustible;
	}

	public Color getColor() {
		return color;
	}

	public TipoMotor getMotor() {
		return motor;
	}

	/**
	 * Método que comprueba el tipo de cumbustible.
	 * 
	 * @param tipo representa el string que se le pase al constructor.
	 * @return
	 */
	private TipoCombustible comprobarTipoCombustible(String tipo) {

		// Bucle para recorrer el enum de TipoCombustible si el string es igual a uno de
		// los elementos, lo devuelve.
		for (TipoCombustible combustible : TipoCombustible.values()) {
			if (combustible.name().equalsIgnoreCase(tipo)) {
				return combustible;
			}
		}

		// Si no devuelve la constante de tipo de combustible por defecto
		return TIPO_COMBUSTIBLE_DF;

	}

	/**
	 * Método para comprobar el color del vehiculo.
	 * 
	 * @param color representa el string pasado por el contructor
	 * @return color1 devuelve el color que sea igual al que se paso por parametro.
	 * @return COLOR_DF devuele el color por defecto.
	 */
	protected static Color comprobarColor(String color) {

		for (Color color1 : Color.values()) {
			if (color1.name().equalsIgnoreCase(color)) {
				return color1;
			}
		}
		return COLOR_DF;
	}

	/**
	 * Clase que comprueba el tipo de motor.
	 * 
	 * @param motor depresenta el string pasado por el constructor.
	 * @return tipoMotor devuelve el motor que sea igual al que se paso por
	 *         parametro.
	 * @return MOTOR_DF devuele el motor por defecto.
	 */
	protected static TipoMotor comprobarTipoMotor(String motor) {

		for (TipoMotor tipoMotor : TipoMotor.values()) {
			if (tipoMotor.name().equalsIgnoreCase(motor)) {
				return tipoMotor;
			}
		}
		return MOTOR_DF;
	}

	/**
	 * Método calcularVelocidad();
	 */
	protected void calcularVelocidad(double distancia, double tiempo) {
		// Si el tiempo o distancia es 0 se lanzará una IllegalArgumentException
		if (tiempo == 0 || distancia == 0) {
			throw new IllegalArgumentException("El tiempo o la distancia no pueden ser cero.");
		}

		// Redondeo a dos decimales velocidad
		double velocidad = Math.round((distancia / tiempo) * 100 / 100d);
		System.out.println("La velocidad media es de: " + velocidad + " m/s.\n");
	}

	@Override
	public String toString() {
		return "Vehiculo" + "\nNumero de matricula: " + num_Matricula + "\nCombustible: " + combustible + "\nColor: "
				+ color + "\nMotor: " + motor;
	}

}
