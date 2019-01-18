/**
 * 
 */
package com.ceiba.ceibaestacionamiento.services;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */
public class TiempoTranscurrido {

	
	Vehiculo vehiculo = new Vehiculo();
	
    Calendar horaIngreso = Calendar.getInstance();
  	
	Date fechaIngreso;
	Date fechaSalida = new Date();
	Calendar calendar = GregorianCalendar.getInstance();
	
	
	public Integer calcualarHorasAndDias() {
//		fechaIngreso = vehiculo.getFechaingreso();
//		vehiculo.setFechasalida(fechaSalida);
//		//calendar.
//	    horaIngreso.setTime(vehiculo.getFechaingreso());
//	    
//	    System.out.println(horaIngreso.get(Calendar.HOUR)); // the day of the week in numerical format
//	    System.out.println(horaIngreso.get(Calendar.MINUTE)); 
//	    System.out.println(horaIngreso.get(Calendar.SECOND)); 
//	
//		Integer horasTrascurridas = fechaIngreso.getHours() - fechaSalida.getHours();
//		
		return 0;
	}
	
}
