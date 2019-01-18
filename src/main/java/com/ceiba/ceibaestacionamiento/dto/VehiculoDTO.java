/**
 * 
 */
package com.ceiba.ceibaestacionamiento.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */

public class VehiculoDTO {
	
	private String placavehiculo;
	private String tipovehiculo;
	private Date fechaingreso;
	
	public VehiculoDTO() {
	}
	
	
	public VehiculoDTO(String placavehiculo, String tipovehiculo, Date fechaingreso) {
		super();
		this.placavehiculo = placavehiculo;
		this.tipovehiculo = tipovehiculo;
		this.fechaingreso = fechaingreso;
	}
	
	 public static List<VehiculoDTO> getInstanceList(List<Vehiculo> vehiculo) {
	    	List<VehiculoDTO> dtos = new ArrayList<>();
	
    		for (Vehiculo vehicu : vehiculo) {
	    		VehiculoDTO dto = new VehiculoDTO();
	    		dto.setPlacavehiculo(vehicu.getPlacavehiculo());
	    		dto.setTipovehiculo(vehicu.getTipovehiculo());
	    		dto.setFechaingreso(vehicu.getFechaingreso());	
	    		dtos.add(dto);
			}
	
	    	return dtos;
	    }
	
    public static VehiculoDTO getInstance(Vehiculo vehiculo) {
    	
    	VehiculoDTO dto = new VehiculoDTO();
 
		dto.setPlacavehiculo(vehiculo.getPlacavehiculo());
		dto.setTipovehiculo(vehiculo.getTipovehiculo());
		dto.setFechaingreso(vehiculo.getFechaingreso());

		
    	return dto;
    	
    }


	public String getPlacavehiculo() {
		return placavehiculo;
	}
	public void setPlacavehiculo(String placavehiculo) {
		this.placavehiculo = placavehiculo;
	}
	public String getTipovehiculo() {
		return tipovehiculo;
	}
	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}
	public Date getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	
}
