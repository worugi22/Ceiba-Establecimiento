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
	
	
	@Test
	public void parquear_un_carro_3_horas_y_1_dia_debe_dar_11000() {
		final Integer HORAS = 3; 
		final Integer DIAS = 1; 
		Double costo = SalidaEstacionamientoCeiba.calcularPrecioCarro(HORAS, DIAS);
		Double resul = (double) 11_000;
		assertEquals(costo,resul);
	}
	
	@Test
	public void parquear_un_carro_0_horas_y_5_dias_debe_dar_40000() {
		final Integer HORAS = 0; 
		final Integer DIAS = 5; 
		Double costo = SalidaEstacionamientoCeiba.calcularPrecioCarro(HORAS, DIAS);
		Double resul = (double) 40_000;
		assertEquals(costo,resul);
	}
	
	@Test
	public void parquear_un_carro_9_horas_y_0_dias_debe_dar_8000() {
		final Integer HORAS = 9; 
		final Integer DIAS = 0; 
		Double resultado = SalidaEstacionamientoCeiba.calcularPrecioCarro(HORAS, DIAS);
		Double esperado = (double) 8_000;
		assertEquals(esperado, resultado);
	}
	
	
	@Test
	public void parquear_una_moto_1_horas_2_dias_y_cilindraje_600_debe_dar_10500() {
		final Integer HORAS = 1; 
		final Integer DIAS = 2; 
		final Integer CILINDRAJE = 600; 
		Double resultado = SalidaEstacionamientoCeiba.calcularPrecioMoto(HORAS, DIAS, CILINDRAJE);
		Double esperado = (double) 10_500;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void parquear_una_moto_0_horas_30_dias_y_cilindraje_500_debe_dar_120000() {
		final Integer HORAS = 0; 
		final Integer DIAS = 30; 
		final Integer CILINDRAJE = 500; 
		Double resultado = SalidaEstacionamientoCeiba.calcularPrecioMoto(HORAS, DIAS, CILINDRAJE);
		Double esperado = (double) 120_000;
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void parquear_una_moto_100_horas_0_dias_y_cilindraje_1000_debe_dar_52000() {
		final Integer HORAS = 100; 
		final Integer DIAS = 0; 
		final Integer CILINDRAJE = 1000; 
		Double resultado = SalidaEstacionamientoCeiba.calcularPrecioMoto(HORAS, DIAS, CILINDRAJE);
		Double esperado = (double) 52_000;
		assertEquals(esperado, resultado);
	}
	
	
}
