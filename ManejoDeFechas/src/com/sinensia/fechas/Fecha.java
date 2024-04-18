package com.sinensia.fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class Fecha {

	public static void main(String[] args) {
		
		// Presentación de la fecha actual.
		LocalDate fechaActual = LocalDate.now();
		System.out.println(fechaActual);
		
		// Presentación de la fecha y hora actual.
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		System.out.println(fechaHoraActual);
		
		// Presentación de la fecha y hora en Europa/Madrid.
		ZoneId zonaHoraria = ZoneId.of("Europe/Madrid");
		ZonedDateTime fechaHoraActualMadrid = ZonedDateTime.now(zonaHoraria);
		System.out.println("La fecha y hora actual de Madrid es: " + fechaHoraActualMadrid);
		
		// Presentacion de la fecha 10/12/2022 con ese formato.
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaEspecifica = LocalDate.of(2022, 12, 10);
		System.out.println(formato.format(fechaEspecifica));
		
		// Indicar a que mes corresponde el 7/12/2020, en numero y el nombre
		LocalDate fechaEspecifica1 = LocalDate.of(2020, 12, 7);
		int mesCorrespondiente = fechaEspecifica1.getMonthValue();
		Month nombreMes = fechaEspecifica1.getMonth();
		System.out.println(mesCorrespondiente +" "+ nombreMes.toString());
		
		// Comprobar si el año 2022 es bisiesto
		Year year = Year.of(2022);
		
		if(year.isLeap()) {
			System.out.println("El año " + year + " es bisiesto.");
		}else {
			System.out.println("El año " + year + " no es bisiesto.");
		}
		
		// Comprobar si puedo poner el dia 29 a 2/2020 -> Verdadero
		LocalDate fechaEspecifica2 = LocalDate.of(2020, 2, 29);
		System.out.println(fechaEspecifica2);
		
		// Ver que fecha es 30 días después del 20/2/2010
		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaEspecifica3 = LocalDate.of(2010, 2, 20);
		LocalDate dias = fechaEspecifica3.plusDays(30);
		System.out.println("La fecha " + formato1.format(fechaEspecifica3) + " después de 30 dias será " + formato1.format(dias) + ".");
		
		//Ver que fecha es 1 mes después del 15/12/2009
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaEspecifica4 = LocalDate.of(2009, 12, 15);
		LocalDate meses = fechaEspecifica4.plusMonths(1);
		System.out.println("La fecha " + formato2.format(fechaEspecifica4) + " después de un mes será " + formato2.format(meses) + ".");
		
		//Calcular cuantos días han pasado entre el 7/10/2001 y el 10/5/2004
		LocalDate fecha = LocalDate.of(2001, 10, 7);
		LocalDate fecha1 = LocalDate.of(2004, 5, 10);
		
	}
}
