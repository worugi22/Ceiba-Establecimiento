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

/* Con esta linea @CrossOrigin(origins= {"http://localhost:4200"}), se da acceso a este dominio para que pueda enviar y recibir datos, designar metodos
permitidos, cabezeras permitidas. si no se indica el parametro los deja habilidatos todos*/

@CrossOrigin(origins= {"http://localhost:4200"}) // conexion con front End
@RestController
@RequestMapping("/estacionamiento")
public class VehiculoRestController {
	
	static final Boolean REGISTRADO = true;
	static final String CARRO = "carro";
	static final String MOTO = "moto";
	
	@Autowired // Se inyecta el servicio
	private VehiculoService vehiculoService;
	
	
	@GetMapping("/parqueado") // Buscar vehiculos parqueados.
	@ResponseStatus(HttpStatus.OK)
	public List<VehiculoDTO> show(){
		return vehiculoService.consultarVehiculosEstacionados(REGISTRADO);
	}
	
	@GetMapping("/parqueado/{placavehiculo}") // Buscar vehiculo parqueado por placa.
	@ResponseStatus(HttpStatus.OK)
	public Vehiculo show(@PathVariable String placavehiculo){
		return vehiculoService.consultarVehiculoEstacionado(placavehiculo, REGISTRADO);
	}
	
	
	@PostMapping("/vehiculo/registrar") // Registrar un vehiculo ingreso vehiculo.
	@ResponseStatus(HttpStatus.CREATED)
	public RegistrarVehiculoDTO create(@RequestBody Vehiculo vehiculo) {
		if(vehiculoService.findByTipovehiculoAndEstado(CARRO,true).size() < 20 && vehiculo.getTipovehiculo().equals("carro")) 
			return vehiculoService.registrarVehiculoRest(vehiculo);
		if(vehiculoService.findByTipovehiculoAndEstado(MOTO,true).size() < 10 && vehiculo.getTipovehiculo().equals("moto")) 
			return vehiculoService.registrarVehiculoRest(vehiculo);
		return null;
	}
	
	
	// Se registra la salida del vehiculo
	@PutMapping("/vehiculo/salida/{placavehiculo}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vehiculo update(@RequestBody Vehiculo vehiculo, @PathVariable String placavehiculo) {
		Vehiculo vehiculoActual = this.vehiculoService.consultarVehiculoEstacionado(placavehiculo, REGISTRADO);

		// Se genera fecha de salida.
		Date fechaSalida = new Date();
		vehiculoActual.setFechasalida(fechaSalida);
		
		// Se trae la fechas de ingreso de la base de datos.
		Date fechaIngreso = vehiculoActual.getFechaingreso();
		
		// Se calculan las horas y dias que duró parquedo.
		long horas = EstacionamientoUtils.calcularHoras(fechaIngreso, fechaSalida);
		System.out.println(horas);
		long dias = EstacionamientoUtils.calcularHoras(fechaIngreso, fechaSalida)/24;
		
		// Se calcula el costo segun el tipo de vehiculo y sus requerimientos.
		String tipoVehiculo = vehiculoActual.getTipovehiculo();
		double costo = 0;
		Integer cilindrajeVehiculo;
		cilindrajeVehiculo = vehiculo.getCilindrajevehiculo();
		
		switch(tipoVehiculo) {
		  case "carro":
			  costo = SalidaEstacionamientoCeiba.calcularPrecioCarro(horas, dias);
		    break;
		  case "moto":
			  costo = SalidaEstacionamientoCeiba.calcularPrecioMoto(horas, dias, cilindrajeVehiculo);
		    break;
		  default:
		}
		
		// Se acutalizan los valores de costo y estado de parqueo.
		vehiculoActual.setCosto(costo);
		vehiculoActual.setEstado(false);
		
		this.vehiculoService.registrarVehiculo(vehiculoActual);
		return vehiculoActual;
	}	
	
	
	
	
}


