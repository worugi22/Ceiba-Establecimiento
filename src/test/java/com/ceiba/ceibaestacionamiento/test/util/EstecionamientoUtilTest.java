/**
 * 
 */
package com.ceiba.ceibaestacionamiento.test.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.ceibaestacionamiento.util.EstacionamientoUtils;

/**
 * @author wolsey.rubio
 *
 */
public class EstecionamientoUtilTest {
	
	private  SimpleDateFormat formato;
	private Date fechaIngreso;
	private Date fechaSalida;
	
	@Before 
	public void init() throws ParseException {
		formato =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		fechaIngreso = formato.parse("2019/01/22 09:14:00"); 
		fechaSalida = formato.parse("2019/01/23 10:14:00"); 
	}
	
	@Test
	public void siUnVehiuculoIngresa() {
		long obtenido = EstacionamientoUtils.calcularHoras(fechaIngreso, fechaSalida);
		long esperado = 25;
		assertEquals(obtenido,esperado);
	}
	

}
