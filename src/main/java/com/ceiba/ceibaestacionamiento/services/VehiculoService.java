/**
 * 
 */
package com.ceiba.ceibaestacionamiento.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.ceibaestacionamiento.repository.IVehiculoRepository;
import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */

@Service
public class VehiculoService{
	
	@Autowired // Inyectar el cliente DAO
	private IVehiculoRepository vehiculoRepository;
	
	@Transactional(readOnly = true) // Permite hacer transaciones. se puede omitir viene en el CrupRepository
	public List<Vehiculo> findAll() {
		return vehiculoRepository.findAll();
	}
	
	@Transactional(readOnly = true) 
	public Vehiculo findByIdvehiculo(Integer idvehiculo) {
		return vehiculoRepository.findByIdvehiculo(idvehiculo);
	}
	
	@Transactional(readOnly = true) 
	public Vehiculo findByPlacavehiculo(String placavehiculo) {
		return vehiculoRepository.findByPlacavehiculo(placavehiculo);
	}

	@Transactional
	public Vehiculo save(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}

	@Transactional
	public void deleteById(Integer idvehiculo) {
		vehiculoRepository.deleteById(idvehiculo);
	}


}
