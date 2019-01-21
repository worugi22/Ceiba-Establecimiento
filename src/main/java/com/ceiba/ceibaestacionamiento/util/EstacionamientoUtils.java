package com.ceiba.ceibaestacionamiento.util;

import java.util.Calendar;
import java.util.Date;

public final class EstacionamientoUtils {
	
	
	
	//Tipos de vehiculos que pueden ingresar.
	static final String CARRO = "carro";
	static final String MOTO = "moto";
	static final String LETRA_INICIAL_PLACA = "a";
	

	
	public static Boolean buscarCaraterInicial(String placa, String incialPlaca) {
		if(placa.toLowerCase().startsWith(incialPlaca))
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}
	
	public static long calcularHoras(Date fechaIngreso, Date fechaSalida) {
		
		Calendar forFechaIngreso = Calendar.getInstance();
		Calendar forFechaSalida = Calendar.getInstance();
		
		forFechaIngreso.setTime(fechaIngreso);
		forFechaSalida.setTime(fechaSalida);
		
		Double horasPasadas = (double) ((forFechaSalida.getTimeInMillis() - forFechaIngreso.getTimeInMillis())/1000/60/60);
		
		return (long) Math.ceil(horasPasadas);
	}
	
	public static boolean validarPlacaLetraDia(String placa, String tipoVehiculo) {
		
		if(tipoVehiculo == CARRO && buscarCaraterInicial(placa,LETRA_INICIAL_PLACA))
			return Boolean.TRUE;
		if(tipoVehiculo == MOTO && buscarCaraterInicial(placa,LETRA_INICIAL_PLACA))
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}

}
