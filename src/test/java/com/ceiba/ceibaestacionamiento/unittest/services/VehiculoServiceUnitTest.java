/**
 * 
 */
package com.ceiba.ceibaestacionamiento.unittest.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ceiba.ceibaestacionamiento.dto.VehiculoDTO;
import com.ceiba.ceibaestacionamiento.model.Vehiculo;
import com.ceiba.ceibaestacionamiento.repository.IVehiculoRepository;
import com.ceiba.ceibaestacionamiento.services.VehiculoService;
import com.ceiba.ceibaestacionamiento.util.EstacionamientoUtils;

/**
 * @author wolsey.rubio
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class VehiculoServiceUnitTest {

	private  SimpleDateFormat formato;
	static final String CARRO = "carro";
	static final long MAX_CARRO = 20;
	static final String MOTO = "moto";
	static final Integer MAX_MOTO = 10;
	static final int DOMINGO = 1;
	static final int LUNES = 2;
	static final int MARTES = 3;
	static final int MIERCOLES = 4;
	static final int JUEVES = 5;
	static final int VIERNES = 6;
	static final int SABADO = 7;
	
	String tipoVehiculoIngresado;
	String tipoVehiculoPermitido;
	
//	private Date fechaIngreso;
//	private Date fechaSalida;
//	
	@InjectMocks
	VehiculoService vehiculoService; 
	Calendar calendar;
	List<Vehiculo> vehiculoList;
	Vehiculo vehiculo;
	VehiculoDTO vehiculoDTO;
	
	
	@Mock
	IVehiculoRepository vehiculoRepository;


	@Before 
	public void setUp() throws ParseException {
		vehiculoService = new VehiculoService();
		//formato =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//fechaIngreso = formato.parse("2019/01/22 09:14:00"); 
//		fechaSalida = formato.parse("2019/01/23 10:14:00"); 
		calendar = Calendar.getInstance();
	
		
	}	
	
	@Test
	public void testGetDiaActual() {
		int diaActual = calendar.get(Calendar.DAY_OF_WEEK);
		assertEquals(vehiculoService.getDiaActual(), diaActual);
	}
	
	
	@Test
	public void testIsVehiculoDiaHabilLunes() {
		assertTrue(vehiculoService.isVehiculoDiaHabil(LUNES));
	}
	
	@Test
	public void testIsVehiculoDiaHabilDomingo() {
		assertTrue(vehiculoService.isVehiculoDiaHabil(DOMINGO));
	}
	
	@Test
	public void testIsVehiculoDiaHabilOtroDia() {
		assertFalse(vehiculoService.isVehiculoDiaHabil(MARTES));
	}
	
	@Test
	public void testIsValidoDiaPlacaIniciaLetraA() {
		assertTrue(vehiculoService.placaIniciaConLetra("AKF-234"));
	}
	
	@Test
	public void testIsValidoDiaPlacaIniciaLetraDiferente() {
		assertFalse(vehiculoService.placaIniciaConLetra("DKF-234"));
	}
	
//	@Test
//	public void testIsValidoDiaPlaca() {
//		when(vehiculo.getPlacavehiculo()).thenReturn("aaa-111");		
//		assertTrue(vehiculoService.isValidoDiaPlaca(vehiculo.getPlacavehiculo()));
//	}
	
//	@Test
//	public void testIsCapacidadVehiculo() {
//		int capacidad = 20;
//		when(vehiculo.size()).thenReturn(anyInt());	
//		when( anyInt() < capacidad).thenReturn(true);
//		assertTrue(vehiculoService.isCapacidadVehiculo(vehiculo,capacidad));
//	}
	

	@Test
	public void testIsTipoVehiculoCarro() {
		tipoVehiculoIngresado = CARRO;
		tipoVehiculoPermitido = CARRO;
		assertTrue(vehiculoService.isTipoVehiculo(tipoVehiculoPermitido, tipoVehiculoIngresado));
	}
	
	@Test
	public void testIsTipoVehiculoMoto() {
		tipoVehiculoIngresado = MOTO;
		tipoVehiculoPermitido = MOTO;
		assertTrue(vehiculoService.isTipoVehiculo(tipoVehiculoPermitido, tipoVehiculoIngresado));
	}
	
	@Test
	public void testIsTipoVehiculoOtro() {
		tipoVehiculoIngresado = "otro";
		tipoVehiculoPermitido = MOTO;
		assertFalse(vehiculoService.isTipoVehiculo(tipoVehiculoPermitido, tipoVehiculoIngresado));
	}
	
//	@Test
//	public void testRegistrarIngresoVehiculoRest() {
//		Vehiculo vehiculoA = new Vehiculo();
//		vehiculoA.setPlacavehiculo("DWE-342");
//		vehiculoA.setTipovehiculo(CARRO);
//		assertNotNull(vehiculoService.registrarIngresoVehiculoRest(vehiculoA));
//	}
	
	@Test
	public void testConsultarVehiculoEstacionado() {
		IVehiculoRepository vehiculoRepositoryR = mock(IVehiculoRepository.class);
		when(vehiculoRepositoryR.findByPlacavehiculoAndEstado("", true)).thenReturn(vehiculo);
		vehiculoService.consultarVehiculoEstacionado("",true);
	}

//	/**
//	 * Test method for {@link com.ceiba.ceibaestacionamiento.services.VehiculoService#consultarVehiculosEstacionados()}.
//	 */
//	@Test
//	public void testConsultarVehiculosEstacionados() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link com.ceiba.ceibaestacionamiento.services.VehiculoService#registrarVehiculo(com.ceiba.ceibaestacionamiento.model.Vehiculo)}.
//	 */
//	@Test
//	public void testRegistrarVehiculo() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link com.ceiba.ceibaestacionamiento.services.VehiculoService#registrarSalidaVehiculo(java.lang.String)}.
//	 */
//	@Test
//	public void testRegistrarSalidaVehiculo() {
//		fail("Not yet implemented");
//	}
//
//	
	
}
