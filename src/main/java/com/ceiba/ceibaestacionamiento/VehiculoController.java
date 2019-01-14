/**
 * 
 */
package com.ceiba.ceibaestacionamiento;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wolsey.rubio
 *
 */

@RestController
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@RequestMapping(value="obtenerVehiculo/{idvehiculo}",method=RequestMethod.GET)
	public Optional<Vehiculo> consultarVehiculo(@PathVariable("idvehiculo") Integer idvehiculo) {
		return vehiculoService.getVehiculo(idvehiculo);
	}
	
}	
