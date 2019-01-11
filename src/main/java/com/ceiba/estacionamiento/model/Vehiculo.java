/**
 * 
 */
package com.ceiba.estacionamiento.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wolsey.rubio
 *
 */
@Entity
@Table(name="vehiculo")
public class Vehiculo {
	
	private Integer idVehiculo;
	private Integer tipoVehiculo;
	private String placaVehiculo;
	private String horaSalida;
	
	public Vehiculo(Integer idVehiculo, Integer tipoVehiculo, String placaVehiculo) {
		super();
		this.idVehiculo = idVehiculo;
		this.tipoVehiculo = tipoVehiculo;
		this.placaVehiculo = placaVehiculo;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Integer getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(Integer tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", tipoVehiculo=" + tipoVehiculo + ", placaVehiculo="
				+ placaVehiculo + ", horaSalida=" + horaSalida + "]";
	}
	
	
	
	
}
