/**
 * 
 */
package com.ceiba.ceibaestacionamiento;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
