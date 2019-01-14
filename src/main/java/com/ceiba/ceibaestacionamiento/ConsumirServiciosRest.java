/**
 * 
 */
package com.ceiba.ceibaestacionamiento;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */
public class ConsumirServiciosRest {
	private static final Logger logger = LoggerFactory.getLogger(ConsumirServiciosRest.class);
	
	public static void main(String arg[]) {
		RestTemplate restTemplate = new RestTemplate();
		Vehiculo vehiculo = restTemplate.getForObject("http://localhost:8080/obtenerVehiculo/4", Vehiculo.class);
		logger.info("Se consumen el servicio rest "
				+ "idve es : "+vehiculo.getIdvehiculo()
				+", placaVehiculo es : "+vehiculo.getPlacavehiculo()
				+", fechaIngreso es : "+vehiculo.getFechaingreso()
				+", fechaSalida es : "+vehiculo.getFechasalida()
				+", cilindrajeVehiculo es : "+vehiculo.getCilindrajevehiculo()
				+", ideestacionamiento es : "+vehiculo.getIdestacionamiento()
				+", tipoVehiculo es : "+vehiculo.getTipovehiculo()
				);
	}

}
