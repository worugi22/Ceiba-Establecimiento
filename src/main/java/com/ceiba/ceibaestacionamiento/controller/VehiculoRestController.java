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

import com.ceiba.ceibaestacionamiento.dto.VehiculoDTO;
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
public class VehiculoRestController {
	
	
	@Autowired // Se inyecta el servicio
	private VehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	public List<Vehiculo> index(){
		return vehiculoService.findAll();
	}
	
	@GetMapping("/vehiculos/parqueados")
	public List<VehiculoDTO> show(){
		return vehiculoService.consultarVehiculosEstacionados(true);
	}
	
	@GetMapping("/vehiculos/id/{idvehiculo}")
	public Vehiculo show(@PathVariable Integer idvehiculo) {
		return vehiculoService.findByIdvehiculo(idvehiculo);
	}
	
	@GetMapping("/vehiculos/placa/{placavehiculo}")
	public Vehiculo show(@PathVariable String placavehiculo) {
		return vehiculoService.findByPlacavehiculo(placavehiculo);
	}
	
	@PostMapping("/vehiculos/registrar/ingreso")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo create(@RequestBody Vehiculo vehiculo) {
		return vehiculoService.registrarVehiculo(vehiculo);
	}
	
	
//	@PutMapping("/vehiculos/{idvehiculo}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Vehiculo update(@RequestBody Vehiculo vehiculo, @PathVariable Integer idvehiculo) {
//		Vehiculo vehiculoActual = this.vehiculoService.findByIdvehiculo(idvehiculo);
//		
//		vehiculoActual.setIdvehiculo(vehiculo.getIdvehiculo());
//		vehiculoActual.setFechaingreso(vehiculo.getFechaingreso());
//		vehiculoActual.setFechasalida(vehiculo.getFechasalida());
//		vehiculoActual.setCilindrajevehiculo(vehiculo.getCilindrajevehiculo());
//		vehiculoActual.setIdestacionamiento(vehiculo.getIdestacionamiento());
//		vehiculoActual.setTipovehiculo(vehiculo.getTipovehiculo());
//		
//		this.vehiculoService.registrarVehiculo(vehiculoActual);
//		return vehiculoActual;
//	}

	@PutMapping("/vehiculos/{placavehiculo}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo update(@RequestBody Vehiculo vehiculo, @PathVariable String placavehiculo) {
		Vehiculo vehiculoActual = this.vehiculoService.findByPlacavehiculo(placavehiculo);
		
		vehiculoActual.setIdvehiculo(vehiculo.getIdvehiculo());
		vehiculoActual.setFechaingreso(vehiculo.getFechaingreso());
		vehiculoActual.setFechasalida(vehiculo.getFechasalida());
		vehiculoActual.setCilindrajevehiculo(vehiculo.getCilindrajevehiculo());
		vehiculoActual.setIdestacionamiento(vehiculo.getIdestacionamiento());
		vehiculoActual.setTipovehiculo(vehiculo.getTipovehiculo());
		
		this.vehiculoService.registrarVehiculo(vehiculoActual);
		return vehiculoActual;
	}
	
	@DeleteMapping("/vehiculos/id/{idvehiculo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer idvehiculo) {
		vehiculoService.deleteById(idvehiculo);
	}
	
	@DeleteMapping("/vehiculos/placa/{placavehiculo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String placavehiculo) {
		vehiculoService.deleteByPlacavehiculo(placavehiculo);
	}
	
	
	
}

