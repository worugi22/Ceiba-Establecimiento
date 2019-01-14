/**
 * 
 */
package com.ceiba.ceibaestacionamiento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wolsey.rubio
 *
 */

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer>{

	//public Vehiculo vihiculo ();
}
