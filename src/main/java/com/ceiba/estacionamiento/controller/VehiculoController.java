/**
 * 
 */
package com.ceiba.estacionamiento.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.model.Vehiculo;
import com.ceiba.estacionamiento.repository.VehiculoRepository;

/**
 * @author wolsey.rubio
 *
 */

@RestController
@RequestMapping(path="/controladorVehiculo") // This means URL's start with /demo (after Application path)
public class VehiculoController {
	
	@Autowired // This means to get the bean called userRepository
	@Qualifier("vehiculoRepository")
	private VehiculoRepository vehiculoRepository;
	//private VehiculoService vehiculoService;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewVehiculo (@RequestParam String placaVehiculo
			, @RequestParam Date fechaIngreso
			, @RequestParam Integer cilindrajeVehiculo
			, @RequestParam Integer idestacionamiento
			, @RequestParam Integer tipoVehiculo) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlacaVehiculo(placaVehiculo);
		vehiculo.setFechaIngreso(fechaIngreso);
		vehiculo.setCilindrajeVehiculo(cilindrajeVehiculo);
		vehiculo.setIdestacionamiento(idestacionamiento);
		vehiculo.setTipoVehiculo(tipoVehiculo);
		
		vehiculoRepository.save(vehiculo);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Vehiculo> getAllVehiculos() {
		// This returns a JSON or XML with the users
		return vehiculoRepository.findAll();
	}
	
	/*
		@RequestMapping(value = "/listaVehiculos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody List<Vehiculo> consultarVehiculos(){
			return vehiculoService.consultarVehiculos();
		} 
	*/
	
	
	
}
