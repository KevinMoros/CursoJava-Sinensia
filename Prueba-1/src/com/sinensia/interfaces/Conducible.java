package com.sinensia.interfaces;

/**
 * Interfaz Conducible Contiene los metodos que pueden ser implementados de
 * manera diferente dependiendo de la clase
 */
public interface Conducible {

	void arrancar();

	void avanzar(double distancia, double tiempo);

	void retroceder(double distancia);

	void parar();

}
