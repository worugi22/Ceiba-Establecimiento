/**
 * 
 */
package com.ceiba.estacionamiento.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.model.Vehiculo;
import com.ceiba.estacionamiento.repository.IVehiculoRepository;


/**
 * @author wolsey.rubio
 *
 */

@Service("vehiculoService")
public class VehiculoService {
	
	@Autowired
	@Qualifier("repositorioVehiculos")
	private IVehiculoRepository vehiculoRepository;
	
	private static final Log Looger = LogFactory.getLog(VehiculoService.class);
	
	public List<Vehiculo> consultarVehiculos(){
		try {
			return vehiculoRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
}
