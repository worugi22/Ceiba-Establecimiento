/**
 * 
 */
package com.ceiba.ceibaestacionamiento.service;

import java.util.List;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */
public interface IVehiculoService {
	
	public List<Vehiculo> findAll();
	public Vehiculo findById(String placavehiculo);
	public Vehiculo save(Vehiculo vehiculo);
	public void delete(String placavehiculo);
	
}
