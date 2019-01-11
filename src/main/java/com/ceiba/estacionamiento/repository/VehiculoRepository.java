/**
 * 
 */
package com.ceiba.estacionamiento.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ceiba.estacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository("repositorioVehiculos")
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer>{
	
}



/*
 @Repository("repositorioVehiculos")
public interface VehiculoRepository extends JpaRepository<com.ceiba.estacionamiento.model.Vehiculo, Serializable>{
}
  
 */

