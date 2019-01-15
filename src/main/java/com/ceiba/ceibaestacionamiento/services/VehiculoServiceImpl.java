/**
 * 
 */
package com.ceiba.ceibaestacionamiento.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.ceibaestacionamiento.repository.IVehiculoDao;
import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired // Inyectar el cliente DAO
	private IVehiculoDao vehiculoDao;
	
	@Override
	@Transactional(readOnly = true) // Permite hacer transaciones. se puede omitir viene en el CrupRepository
	public List<Vehiculo> findAll() {
		return (List<Vehiculo>) vehiculoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true) 
	public Vehiculo findById(String placavehiculo) {
		return vehiculoDao.findById(placavehiculo).orElse(null);
	}

	@Override
	@Transactional
	public Vehiculo save(Vehiculo vehiculo) {
		return vehiculoDao.save(vehiculo);
	}

	@Override
	@Transactional
	public void delete(String idvehiculo) {
		vehiculoDao.deleteById(idvehiculo);
	}


}
