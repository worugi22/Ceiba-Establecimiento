/**
 * 
 */
package com.ceiba.ceibaestacionamiento.test.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;
import com.ceiba.ceibaestacionamiento.services.VehiculoService;
import com.ceiba.ceibaestacionamiento.util.EstacionamientoUtils;

/**
 * @author wolsey.rubio
 *
 */
public class VehiculoServiceTest {
	

	VehiculoService vehiculoService; 
	Vehiculo vehiculo;
	
	@Before 
	public void init() throws ParseException {
		vehiculoService = new VehiculoService();
	}
	
//	@Test
//	public void siUnVehiuculoIngresa() {
//		long obtenido = EstacionamientoUtils.calcularHoras(fechaIngreso, fechaSalida);
//		long esperado = 25;
//		assertEquals(obtenido,esperado);
//	}
//	
//	
//	@Test
//	public void capacidadTipoVehiuculo() {
//		String tipoVehiucloPermitido = "carro";
//		String tipoVehiculoIngresado = "carro";
//		long capacidad = 20;
//		assertTrue(vehiculoService.isCapacidadVehiculoTipoVehiculo(tipoVehiucloPermitido,tipoVehiculoIngresado,capacidad));
//	}
//	@Test
//	public void isValidoDiaPlacaIniciaA() {
//
//		when(vehiculo.getPlacavehiculo()).thenReturn("aaa-111");		
//		assertFalse(vehiculoService.isValidoDiaPlaca(vehiculo.getPlacavehiculo()));
//	}
}
