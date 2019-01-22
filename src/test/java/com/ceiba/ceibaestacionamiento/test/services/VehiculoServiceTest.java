/**
 * 
 */
package com.ceiba.ceibaestacionamiento.test.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;
import com.ceiba.ceibaestacionamiento.services.VehiculoService;

/**
 * @author wolsey.rubio
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class VehiculoServiceTest {

	private  SimpleDateFormat formato;
	private Date fechaIngreso;
	private Date fechaSalida;
	
	@InjectMocks
	VehiculoService vehiculoService = new VehiculoService(); 

	@Mock
	Vehiculo vehiculo;
	
	@Before 
	public void init() throws ParseException {
		vehiculoService = new VehiculoService();
		formato =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		fechaIngreso = formato.parse("2019/01/22 09:14:00"); 
		fechaSalida = formato.parse("2019/01/23 10:14:00"); 
	}
	
	@Test
	public void isValidoDiaPlacaIniciaA() {

		when(vehiculo.getPlacavehiculo()).thenReturn("aaa-111");		
		assertFalse(vehiculoService.isValidoDiaPlaca(vehiculo));
	}
	
}
