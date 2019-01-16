/**
 * 
 */
package com.ceiba.ceibaestacionamiento.repository;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */
public interface IVehiculoRepository extends CrudRepository<Vehiculo, Serializable>{
	
	List<Vehiculo> findAll();
	Vehiculo findByIdvehiculo(Integer idvehiculo);
	Vehiculo findByPlacavehiculo(String placavehiculo);
	
}
