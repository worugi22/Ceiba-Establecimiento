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
@Table(name="factura")
public class Factura {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idfactura;
	
	private Date fechaSalida;
	private Double valorTotal;
	
	private Integer idcolilla;
	
	
	public Factura(Integer idfactura, Date fechaSalida, Double valorTotal, Integer idcolilla) {
		super();
		this.idfactura = idfactura;
		this.fechaSalida = fechaSalida;
		this.valorTotal = valorTotal;
		this.idcolilla = idcolilla;
	}

	public Integer getIdfactura() {
		return idfactura;
	}

	public void setIdfactura(Integer idfactura) {
		this.idfactura = idfactura;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getIdcolilla() {
		return idcolilla;
	}

	public void setIdcolilla(Integer idcolilla) {
		this.idcolilla = idcolilla;
	}

	
	
}
