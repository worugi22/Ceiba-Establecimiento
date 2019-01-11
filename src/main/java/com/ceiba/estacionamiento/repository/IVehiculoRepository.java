/**
 * 
 */
package com.ceiba.estacionamiento.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wolsey.rubio
 *
 */
@Repository("repositorioVehiculos")
public interface IVehiculoRepository extends JpaRepository<com.ceiba.estacionamiento.model.Vehiculo, Serializable>{
	
}
