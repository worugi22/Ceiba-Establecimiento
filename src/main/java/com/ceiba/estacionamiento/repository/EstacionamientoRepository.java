/**
 * 
 */
package com.ceiba.estacionamiento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.estacionamiento.model.Estacionamiento;


/**
 * @author wolsey.rubio
 *
 */

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository("repositoryEstacionamientos")
public interface EstacionamientoRepository extends CrudRepository<Estacionamiento, Integer> {

}
