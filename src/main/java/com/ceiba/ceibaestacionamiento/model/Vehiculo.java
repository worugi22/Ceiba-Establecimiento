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

/**
 * @author wolsey.rubio
 *
 */

@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idvehiculo;
	
	private String placavehiculo;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date fechaingreso;
	
	private Date fechasalida;
	private long cilindrajevehiculo;
	private Integer idestacionamiento;
	private String tipovehiculo;
	private Boolean estado;
	private Double costo;
	
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

	public long getCilindrajevehiculo() {
		return cilindrajevehiculo;
	}

	public void setCilindrajevehiculo(long cilindrajevehiculo) {
		this.cilindrajevehiculo = cilindrajevehiculo;
	}

	public Integer getIdestacionamiento() {
		return idestacionamiento;
	}

	public void setIdestacionamiento(Integer idestacionamiento) {
		this.idestacionamiento = idestacionamiento;
	}

	public String getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	

	@Override
	public String toString() {
		return "Vehiculo [idvehiculo=" + idvehiculo + ", placavehiculo=" + placavehiculo + ", fechaingreso="
				+ fechaingreso + ", fechasalida=" + fechasalida + ", cilindrajevehiculo=" + cilindrajevehiculo
				+ ", idestacionamiento=" + idestacionamiento + ", tipovehiculo=" + tipovehiculo + ", estado=" + estado
				+ ", costo=" + costo + "]";
	}

	

	private static final long serialVersionUID = 1L;

	

}
