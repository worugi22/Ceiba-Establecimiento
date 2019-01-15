/**
 * 
 */
package com.ceiba.ceibaestacionamiento.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author wolsey.rubio
 *
 */

@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable{
	
	@Id
	private String placavehiculo;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idvehiculo;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaingreso;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechasalida;
	
	// @Column(name="") // Si tiene el mismo nombre de la base de datos no se utiliza.
	private Integer cilindrajevehiculo;
	private Integer idestacionamiento;
	private Integer tipovehiculo;
	
	@PrePersist
	public void prePersist() {
		fechaingreso = new Date();
	}

	public Integer getIdvehiculo() {
		return idvehiculo;
	}

	public void setIdvehiculo(Integer idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getPlacavehiculo() {
		return placavehiculo;
	}

	public void setPlacavehiculo(String placavehiculo) {
		this.placavehiculo = placavehiculo;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	public Integer getCilindrajevehiculo() {
		return cilindrajevehiculo;
	}

	public void setCilindrajevehiculo(Integer cilindrajevehiculo) {
		this.cilindrajevehiculo = cilindrajevehiculo;
	}

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
	
	private static final long serialVersionUID = 1L;

}
