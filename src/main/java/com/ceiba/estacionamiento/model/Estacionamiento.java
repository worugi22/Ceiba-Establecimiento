/**
 * 
 */
package com.ceiba.estacionamiento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wolsey.rubio
 *
 */
@Entity
@Table(name="estacionamiento")
public class Estacionamiento {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idestacionamiento;
	private Integer tipoVehiculo;
	private Integer capacidadVehiculos;
	
	// hacer mapping AQUIIIIII
	private List<Vehiculo> vehiculos;

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

	public Integer getCapacidadVehiculos() {
		return capacidadVehiculos;
	}

	public void setCapacidadVehiculos(Integer capacidadVehiculos) {
		this.capacidadVehiculos = capacidadVehiculos;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
}
