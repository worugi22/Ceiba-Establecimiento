/**
 * 
 */
package com.ceiba.estacionamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.model.Vehiculo;
import com.ceiba.estacionamiento.services.VehiculoService;

/**
 * @author wolsey.rubio
 *
 */

@RestController
@RequestMapping("/controladorVehiculo")
public class VehiculoController {
	
	@Autowired
	@Qualifier("vehiculoService")
	private VehiculoService vehiculoService;
	
	@RequestMapping(value = "/listaVehiculos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Vehiculo> consultarVehiculos(){
		return vehiculoService.consultarVehiculos();
	}
}
