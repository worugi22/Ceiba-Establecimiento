/**
 * 
 */
package com.ceiba.ceibaestacionamiento.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wolsey.rubio
 *
 */

@Entity
@Table(name="estacionamiento")
public class Estacionamiento implements Serializable{


	@Id
	private Integer idestacionamiento;
	
	private Integer tipovehiculo;
	private Integer capacidadvehiculos;
	public Integer getIdestacionamiento() {
		return idestacionamiento;
	}
	public void setIdestacionamiento(Integer idestacionamiento) {
		this.idestacionamiento = idestacionamiento;
	}
	public Integer getTipovehiculo() {
		return tipovehiculo;
	}
	public void setTipovehiculo(Integer tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}
	public Integer getCapacidadvehiculos() {
		return capacidadvehiculos;
	}
	public void setCapacidadvehiculos(Integer capacidadvehiculos) {
		this.capacidadvehiculos = capacidadvehiculos;
	}

	private static final long serialVersionUID = 1L;
	
	
}
