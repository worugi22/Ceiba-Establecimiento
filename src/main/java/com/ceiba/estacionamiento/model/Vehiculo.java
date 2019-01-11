/**
 * 
 */
package com.ceiba.estacionamiento.model;

import java.util.Date;

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
@Table(name="vehiculo")
public class Vehiculo {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idvehiculo;
	
	private String placaVehiculo;
	private Date fechaIngreso;
	private Integer cilindrajeVehiculo;
	
	private Integer idestacionamiento;
	private Integer tipoVehiculo;
	
	
	public Integer getIdvehiculo() {
		return idvehiculo;
	}

	public void setIdvehiculo(Integer idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public Integer getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(Integer tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Integer getCilindrajeVehiculo() {
		return cilindrajeVehiculo;
	}

	public void setCilindrajeVehiculo(Integer cilindrajeVehiculo) {
		this.cilindrajeVehiculo = cilindrajeVehiculo;
	}



	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public Integer getIdestacionamiento() {
		return idestacionamiento;
	}

	public void setIdestacionamiento(Integer idestacionamiento) {
		this.idestacionamiento = idestacionamiento;
	}
	
	
	
	
}
