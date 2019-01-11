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
@Table(name="colilla")
public class Colilla {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idcolilla;
	
	private String nombreParqueadero;
	
	private Integer idvehiculo;
	private String placaVehiculo;
	private Date fechaIngreso;
	
	
	public Integer getIdcolilla() {
		return idcolilla;
	}
	public void setIdcolilla(Integer idcolilla) {
		this.idcolilla = idcolilla;
	}
	public String getNombreParqueadero() {
		return nombreParqueadero;
	}
	public void setNombreParqueadero(String nombreParqueadero) {
		this.nombreParqueadero = nombreParqueadero;
	}
	public Integer getIdvehiculo() {
		return idvehiculo;
	}
	public void setIdvehiculo(Integer idvehiculo) {
		this.idvehiculo = idvehiculo;
	}
	public String getPlacaVehiculo() {
		return placaVehiculo;
	}
	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
}
