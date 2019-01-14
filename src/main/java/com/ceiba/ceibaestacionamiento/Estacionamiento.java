/**
 * 
 */
package com.ceiba.ceibaestacionamiento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author wolsey.rubio
 *
 */

@Entity
public class Estacionamiento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idestacionamiento;
	
	private Integer tipoVehiculo;

	public Integer getIdestacionamiento() {
		return idestacionamiento;
	}

	public void setIdestacionamiento(Integer idestacionamiento) {
		this.idestacionamiento = idestacionamiento;
	}

	public Integer getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(Integer tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public String toString() {
		return "Estacionamiento [idestacionamiento=" + idestacionamiento + ", tipoVehiculo=" + tipoVehiculo + "]";
	}
	
	
}
