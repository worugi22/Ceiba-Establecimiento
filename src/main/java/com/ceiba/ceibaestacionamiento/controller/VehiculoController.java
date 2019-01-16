/**
 * 
 */
package com.ceiba.ceibaestacionamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;
import com.ceiba.ceibaestacionamiento.services.VehiculoService;

/**
 * @author wolsey.rubio
 *
 */

/* Con esta linea se da acceso a este dominio para que pueda enviar y recibir datos, designar metodos
permitidos, cabezeras permitidas. si no se indica el parametro los deja habilidatos todos*/
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/estacionamiento")
public class VehiculoController {
	
	// Se inyecta el servicio
	@Autowired
	private VehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	public List<Vehiculo> index(){
		return vehiculoService.findAll();
	}
	
	@GetMapping("/vehiculos/id/{idvehiculo}")
	public Vehiculo show(@PathVariable Integer idvehiculo) {
		return vehiculoService.findByIdvehiculo(idvehiculo);
	}
	
	@GetMapping("/vehiculos/placa/{placavehiculo}")
	public Vehiculo show(@PathVariable String placavehiculo) {
		return vehiculoService.findByPlacavehiculo(placavehiculo);
	}
	
	@PostMapping("/vehiculos")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo create(@RequestBody Vehiculo vehiculo) {
		return vehiculoService.save(vehiculo);
	}
	
	@PutMapping("/vehiculos/{idvehiculo}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo update(@RequestBody Vehiculo vehiculo, @PathVariable Integer idvehiculo) {
		Vehiculo currentVehiculo = this.vehiculoService.findByIdvehiculo(idvehiculo);
		
		currentVehiculo.setIdvehiculo(vehiculo.getIdvehiculo());
		currentVehiculo.setFechaingreso(vehiculo.getFechaingreso());
		currentVehiculo.setFechasalida(vehiculo.getFechasalida());
		currentVehiculo.setCilindrajevehiculo(vehiculo.getCilindrajevehiculo());
		currentVehiculo.setIdestacionamiento(vehiculo.getIdestacionamiento());
		currentVehiculo.setTipovehiculo(vehiculo.getTipovehiculo());
		
		this.vehiculoService.save(currentVehiculo);
		return currentVehiculo;
	}

	@DeleteMapping("/vehiculos/{idvehiculo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer idvehiculo) {
		vehiculoService.deleteById(idvehiculo);
	}
	
	
	
}


