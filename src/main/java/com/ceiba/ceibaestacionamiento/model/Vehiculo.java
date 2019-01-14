/**
 * 
 */
package com.ceiba.ceibaestacionamiento.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author wolsey.rubio
 *
 */

@Entity
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idvehiculo;
	
	private String placavehiculo;
	private Date fechaingreso;
	private Date fechasalida;
	private Integer cilindrajevehiculo;
	private Integer idestacionamiento;
	private Integer tipovehiculo;
	
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
	
	@Override
	public String toString() {
		return "Vehiculo [idveihiculo=" + idvehiculo + ", placavehiculo=" + placavehiculo + ", fechaingreso="
				+ fechaingreso + ", fechasalida=" + fechasalida + ", cilindrajevehiculo=" + cilindrajevehiculo
				+ ", idestacionamiento=" + idestacionamiento + ", tipovehiculo=" + tipovehiculo + "]";
	}
	
}
