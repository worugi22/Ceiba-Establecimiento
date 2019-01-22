package com.ceiba.ceibaestacionamiento.util;

import java.util.Calendar;
import java.util.Date;

public final class EstacionamientoUtils {
	
	static final String CARRO = "carro";
	static final String MOTO = "moto";
	static final String LETRA_INICIAL_PLACA = "a";
	
	
	
	private EstacionamientoUtils() {
		super();
	}

	public static long calcularHoras(Date fechaIngreso, Date fechaSalida) {
		
		Calendar forFechaIngreso = Calendar.getInstance();
		Calendar forFechaSalida = Calendar.getInstance();
		
		forFechaIngreso.setTime(fechaIngreso);
		forFechaSalida.setTime(fechaSalida);
		
		Double horasPasadas = ((double) (forFechaSalida.getTimeInMillis() - forFechaIngreso.getTimeInMillis())/1000/60/60);
		
		return (long) Math.ceil(horasPasadas);
	}
	
}
