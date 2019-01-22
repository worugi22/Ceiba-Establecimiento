/**
 * 
 */
package com.ceiba.ceibaestacionamiento.test.services;

import static org.junit.Assert.assertFalse;
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
//	public void isValidoDiaPlacaIniciaA() {
//
//		when(vehiculo.getPlacavehiculo()).thenReturn("aaa-111");		
//		assertFalse(vehiculoService.isValidoDiaPlaca(vehiculo.getPlacavehiculo()));
//	}
}
