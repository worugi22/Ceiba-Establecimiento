/**
 * 
 */
package com.ceiba.ceibaestacionamiento.repository;


import org.springframework.data.repository.CrudRepository;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */
public interface IVehiculoDao extends CrudRepository<Vehiculo, String>{

}
