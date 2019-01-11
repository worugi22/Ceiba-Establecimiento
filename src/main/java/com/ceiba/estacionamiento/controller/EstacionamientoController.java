/**
 * 
 */
package com.ceiba.estacionamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.model.Estacionamiento;
import com.ceiba.estacionamiento.repository.EstacionamientoRepository;

/**
 * @author wolsey.rubio
 *
 */

@RestController
@RequestMapping(path="/controladorEstacionamiento") // This means URL's start with /demo (after Application path)
public class EstacionamientoController {
	@Autowired // This means to get the bean called estacionamientoRepository
	@Qualifier("estacionamientoRepository")
	private EstacionamientoRepository estacionamientoRepository;
	//private EstacionamientoService estacionamientoService;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewEstacionamiento (@RequestParam Integer tipoVehiculo
			, @RequestParam Integer capacidadVehiculos) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Estacionamiento estacionamiento = new Estacionamiento();
		estacionamiento.setTipoVehiculo(tipoVehiculo);
		estacionamiento.setCapacidadVehiculos(capacidadVehiculos);
		
		estacionamientoRepository.save(estacionamiento);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Estacionamiento> getAllEstacionamientos() {
		// This returns a JSON or XML with the users
		return estacionamientoRepository.findAll();
	}
}
