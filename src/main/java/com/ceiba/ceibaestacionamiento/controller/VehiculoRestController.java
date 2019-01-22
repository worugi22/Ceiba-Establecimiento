/**
 * 
 */
package com.ceiba.ceibaestacionamiento.controller;

import java.util.Date;
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
import com.ceiba.ceibaestacionamiento.services.SalidaEstacionamientoCeiba;
import com.ceiba.ceibaestacionamiento.services.VehiculoService;
import com.ceiba.ceibaestacionamiento.util.EstacionamientoUtils;

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
	
	
	@GetMapping("/parqueados") 
	@ResponseStatus(HttpStatus.OK)
	public List<VehiculoDTO> show(){
		return vehiculoService.consultarVehiculosEstacionados(REGISTRADO);
	}
	
	@GetMapping("/parqueado/{placavehiculo}") 
	@ResponseStatus(HttpStatus.OK)
	public Vehiculo show(@PathVariable String placavehiculo){
		return vehiculoService.consultarVehiculoEstacionado(placavehiculo, REGISTRADO);
	}
	
	
	@PostMapping("/ingreso")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistrarVehiculoDTO create(@RequestBody Vehiculo vehiculo) {
		return vehiculoService.registrarIngresoVehiculoRest(vehiculo);
	}
	

	@PutMapping("/salida/{placavehiculo}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo actualizarPrecioVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable String placavehiculo) {
		
		return vehiculoService.salida(placavehiculo);
		
	}	
	
	
	
	
}


