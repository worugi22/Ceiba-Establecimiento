/**
 * 
 */
package com.ceiba.ceibaestacionamiento.costoparqueaderotest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.ceiba.ceibaestacionamiento.services.SalidaEstacionamientoCeiba;

/**
 * @author wolsey.rubio
 *
 */
public class CostoParqueaderoTest  {
	
	SalidaEstacionamientoCeiba salidaEstacionamientoCeiba = new SalidaEstacionamientoCeiba(); 
	
	@Test
	public void verificarCostoParqueoCarro() {
		final Integer HORAS = 3; 
		final Integer DIAS = 1; 
		Double costo = salidaEstacionamientoCeiba.calcularPrecioCarro(HORAS, DIAS);
		Double resul = (double) 11_000;
		assertEquals(costo,resul);
	}
	
	@Test
	public void verificarCostoParqueoCarroCeroHoras() {
		final Integer HORAS = 0; 
		final Integer DIAS = 5; 
		Double costo = salidaEstacionamientoCeiba.calcularPrecioCarro(HORAS, DIAS);
		Double resul = (double) 40_000;
		assertEquals(costo,resul);
	}
	
	@Test
	public void verificarCostoParqueoCarroCeroDias() {
		final Integer HORAS = 9; 
		final Integer DIAS = 0; 
		Double costo = salidaEstacionamientoCeiba.calcularPrecioCarro(HORAS, DIAS);
		Double resul = (double) 8_000;
		assertEquals(costo,resul);
	}
	
	
	@Test
	public void verificarCostoParqueoMoto() {
		final Integer HORAS = 1; 
		final Integer DIAS = 2; 
		final Integer CILINDRAJE = 600; 
		Double costo = salidaEstacionamientoCeiba.calcularPrecioMoto(HORAS, DIAS, CILINDRAJE);
		Double resul = (double) 10_500;
		assertEquals(costo,resul);
	}
	
	@Test
	public void verificarCostoParqueoMotoCeroHoras() {
		final Integer HORAS = 0; 
		final Integer DIAS = 30; 
		final Integer CILINDRAJE = 500; 
		Double costo = salidaEstacionamientoCeiba.calcularPrecioMoto(HORAS, DIAS, CILINDRAJE);
		Double resul = (double) 120_000;
		assertEquals(costo,resul);
	}
	
	@Test
	public void verificarCostoParqueoMotoCeroDias() {
		final Integer HORAS = 100; 
		final Integer DIAS = 0; 
		final Integer CILINDRAJE = 1000; 
		Double costo = salidaEstacionamientoCeiba.calcularPrecioMoto(HORAS, DIAS, CILINDRAJE);
		Double resul = (double) 52_000;
		assertEquals(costo,resul);
	}
	
	
}
