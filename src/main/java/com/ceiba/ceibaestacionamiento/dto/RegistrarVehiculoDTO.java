/**
 * 
 */
package com.ceiba.ceibaestacionamiento.dto;

import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */
public class RegistrarVehiculoDTO {
	
	private String placavehiculo;
	private String tipovehiculo;
	private long cilindrajavehiculo;
	
	public RegistrarVehiculoDTO() {
	}
	
	
	public RegistrarVehiculoDTO(String placavehiculo, String tipovehiculo, Integer cilindrajavehiculo) {
		super();
		this.placavehiculo = placavehiculo;
		this.tipovehiculo = tipovehiculo;
		this.cilindrajavehiculo = cilindrajavehiculo;
	}
	
	  public static RegistrarVehiculoDTO getInstance(Vehiculo vehiculo) {
	    	
		  RegistrarVehiculoDTO dto = new RegistrarVehiculoDTO();
	 
			dto.setPlacavehiculo(vehiculo.getPlacavehiculo());
			dto.setTipovehiculo(vehiculo.getTipovehiculo());
			dto.setCilindrajavehiculo(vehiculo.getCilindrajevehiculo());

			
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


	public long getCilindrajavehiculo() {
		return cilindrajavehiculo;
	}


	public void setCilindrajavehiculo(long cilindrajavehiculo) {
		this.cilindrajavehiculo = cilindrajavehiculo;
	}
	  
	  

}
