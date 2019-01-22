/**
 * 
 */
package com.ceiba.ceibaestacionamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.ceibaestacionamiento.dto.RegistrarVehiculoDTO;
import com.ceiba.ceibaestacionamiento.dto.VehiculoDTO;
import com.ceiba.ceibaestacionamiento.model.Vehiculo;
import com.ceiba.ceibaestacionamiento.services.VehiculoService;

/**
 * @author wolsey.rubio
 *
 */

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/estacionamiento")
public class VehiculoRestController {
	
	static final Boolean REGISTRADO = true;
	static final String CARRO = "carro";
	static final String MOTO = "moto";
	
	@Autowired 
	private VehiculoService vehiculoService;
	
	@PostMapping("/ingreso")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public RegistrarVehiculoDTO create(@RequestBody Vehiculo vehiculo) {
		return vehiculoService.registrarIngresoVehiculoRest(vehiculo);
	}
	
	@GetMapping("/parqueados") 
	@ResponseStatus(HttpStatus.OK)
	public List<VehiculoDTO> show(){
		return vehiculoService.consultarVehiculosEstacionados();
	}
	
	@PutMapping("/salida/{placavehiculo}")
	@ResponseStatus(HttpStatus.OK)
	public Vehiculo actualizarPrecioVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable String placavehiculo) {
		return vehiculoService.registrarSalidaVehiculo(placavehiculo);
	}	
	
}


