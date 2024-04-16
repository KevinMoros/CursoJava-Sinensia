package com.sinensia.vehiculos;

import com.sinensia.enums.Color;
import com.sinensia.enums.TipoCombustible;
import com.sinensia.enums.TipoMotor;


/**
 * Clase Vehiculo. Posee constantes por defecto para el tipo de combustible,
 * color y motor. Posee atributos como num_Matricula, combustible, color y
 * motor.
 * 
 * @author Kevin.
 *
 */
public abstract class Vehiculo{

	protected final static TipoCombustible TIPO_COMBUSTIBLE_DF = TipoCombustible.GASOLINA;
	protected final static Color COLOR_DF = Color.ROJO;
	protected final static TipoMotor MOTOR_DF = TipoMotor.COMBUSTION;

	protected static String num_Matricula;
	protected TipoCombustible combustible;
	protected Color color;
	protected TipoMotor motor;

	public Vehiculo(String num_Matricula) {
		super();
		Vehiculo.num_Matricula = num_Matricula;
		this.combustible = TIPO_COMBUSTIBLE_DF;
		this.color = COLOR_DF;
		this.motor = MOTOR_DF;
	}

	public Vehiculo(String num_Matricula, String combustible, String color, String motor) {
		super();
		Vehiculo.num_Matricula = num_Matricula;
		this.combustible = comprobartipoCombustible(combustible);
		this.color = comprobarColor(color);
		this.motor = comprobarTipoMotor(motor);
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
	private TipoCombustible comprobartipoCombustible(String tipo) {

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
	 * Metodo que comprueba la matricula.
	 * 
	 * @param num_Matricula
	 * @return true si es valida
	 * @return false si es invalida
	 */
	public boolean comprobarMatricula(String num_Matricula) {

		if (getNum_Matricula().toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {
			System.out.println("Matrícula válida.");
			return true;

		} else {

			System.out.println("Matrícula inválida.");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Vehiculo" + "\nNumero de matricula: " + num_Matricula + "\nCombustible: " + combustible + "\nColor: "
				+ color + "\nMotor: " + motor;
	}

}
