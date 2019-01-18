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

/* Con esta linea @CrossOrigin(origins= {"http://localhost:4200"}), se da acceso a este dominio para que pueda enviar y recibir datos, designar metodos
permitidos, cabezeras permitidas. si no se indica el parametro los deja habilidatos todos*/

@CrossOrigin(origins= {"http://localhost:4200"}) // conexion con front End
@RestController
@RequestMapping("/estacionamiento")
public class VehiculoRestController {
	
	static final Boolean REGISTRADO = true;
	
	@Autowired // Se inyecta el servicio
	private VehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	@ResponseStatus(HttpStatus.OK)
	public List<Vehiculo> index(){
		return vehiculoService.findAll();
	}
	
	@GetMapping("/vehiculos/parqueados")
	@ResponseStatus(HttpStatus.OK)
	public List<VehiculoDTO> show(){
		return vehiculoService.consultarVehiculosEstacionados(REGISTRADO);
	}
	
	@GetMapping("/vehiculos/parqueados/{placavehiculo}")
	@ResponseStatus(HttpStatus.OK)
	public List<Vehiculo> show(@PathVariable String placavehiculo){
		return vehiculoService.consultarVehiculoEstacionado(placavehiculo, REGISTRADO);
	}
	
	
	@PostMapping("/vehiculos/registrar/ingreso")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo create(@RequestBody Vehiculo vehiculo) {
		return vehiculoService.registrarVehiculo(vehiculo);
	}
	
	@PutMapping("/vehiculos/{placavehiculo}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo update(@RequestBody Vehiculo vehiculo, @PathVariable String placavehiculo) {
		Vehiculo vehiculoActual = this.vehiculoService.consultarVehiculoEstacionado1(placavehiculo, REGISTRADO);
		
		vehiculoActual.setFechasalida(vehiculo.getFechasalida());
		vehiculoActual.setEstado(vehiculo.getEstado());
		vehiculoActual.setCosto(vehiculo.getCosto());
		
		this.vehiculoService.registrarVehiculo(vehiculoActual);
		return vehiculoActual;
	}	
	
	
//	@PutMapping("/vehiculos/registrar/salida/{placavehiculo}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Vehiculo update(@RequestBody Vehiculo vehiculo, String placavehiculo) {
//		
//		Vehiculo vehiculoActual = (Vehiculo) vehiculoService.consultarVehiculoEstacionado(placavehiculo, REGISTRADO);
//		
//		vehiculoActual.setFechasalida(vehiculo.getFechasalida());
//		vehiculoActual.setEstado(vehiculo.getEstado());
//		vehiculoActual.setCosto(vehiculo.getCosto());
//		
//		this.vehiculoService.registrarVehiculo(vehiculoActual);
//		return vehiculoActual;
//	
//	}
	
	
//	@GetMapping("/vehiculos/placa/{placavehiculo}")
//	public Vehiculo show(@PathVariable String placavehiculo) {
//		return vehiculoService.findByPlacavehiculo(placavehiculo);
//	}
	
//	@GetMapping("/vehiculos/id/{idvehiculo}")
//	public Vehiculo show(@PathVariable Integer idvehiculo) {
//		return vehiculoService.findByIdvehiculo(idvehiculo);
//	}	

//	
//	@DeleteMapping("/vehiculos/id/{idvehiculo}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Integer idvehiculo) {
//		vehiculoService.deleteById(idvehiculo);
//	}
//	
//	@DeleteMapping("/vehiculos/placa/{placavehiculo}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable String placavehiculo) {
//		vehiculoService.deleteByPlacavehiculo(placavehiculo);
//	}
	
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
	
	
}


