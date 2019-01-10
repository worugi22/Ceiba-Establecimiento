/**
 * 
 */
package com.ceiba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.model.Carro;

/**
 * Interface para definir las operaciones de DB realacionadas con los Carros
 * @author wolsey.rubio
 *
 */
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
