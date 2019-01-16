/**
 * 
 */
package com.ceiba.ceibaestacionamiento.repository;


import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */

public interface IVehiculoRepository extends CrudRepository<Vehiculo, Serializable>{
	
	List<Vehiculo> findAll();
	List<Vehiculo> findByTipovehiculoAndEstado(Integer tipovehiculo, Boolean estado);
	Vehiculo findByIdvehiculo(Integer idvehiculo);
	Vehiculo findByPlacavehiculo(String placavehiculo);
	Vehiculo deleteByPlacavehiculo(String placavehiculo);
	
	
}
