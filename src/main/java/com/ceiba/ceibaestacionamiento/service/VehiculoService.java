/**
 * 
 */
package com.ceiba.ceibaestacionamiento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;
import com.ceiba.ceibaestacionamiento.repository.VehiculoRepository;

/**
 * @author wolsey.rubio
 *
 */

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	public Optional<Vehiculo> getVehiculo(Integer idvehiculo) {
		return vehiculoRepository.findById(idvehiculo);
	}
}
