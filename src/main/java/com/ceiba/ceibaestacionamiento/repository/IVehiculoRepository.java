/**
 * 
 */
package com.ceiba.ceibaestacionamiento.repository;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio 
 *
 */

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Serializable>{
	
	List<Vehiculo> findByTipovehiculoAndEstado(String tipovehiculo, Boolean estado);
	List<Vehiculo> findByEstado(boolean estado);
	Vehiculo findByPlacavehiculoAndEstado(String placavehiculo, Boolean estado);

}
