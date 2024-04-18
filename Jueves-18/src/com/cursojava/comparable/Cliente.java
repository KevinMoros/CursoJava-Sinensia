package com.cursojava.comparable;

public class Cliente implements Comparable<Cliente>{

	public String nombre;
	public String apellido;
	public int edad;
	public String dni;
	
	public Cliente(String nombre, String apellido, int edad ,String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	@Override
	public String toString() {
		return  "Cliente" + "\n" + 
				"Nombre: " + nombre + "\n" +
				"Apellido: " + apellido + "\n" +
				"Edad: " + edad + "\n" +
			    "DNI: " + dni + "\n";
	}

	//Ordena a los los clientes por el DNI
	@Override
	public int compareTo(Cliente cliente) {
		return this.dni.compareTo(cliente.dni);
	}
	
	
	
}
