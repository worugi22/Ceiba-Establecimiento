/**
 * 
 */
package com.ceiba.ceibaestacionamiento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer>{

	//public Vehiculo vihiculo ();
}
