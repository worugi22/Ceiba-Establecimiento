/**
 * 
 */
package com.ceiba.ceibaestacionamiento.services;

/**
 * @author wolsey.rubio
 *
 */
public class CostoParqueoMoto {
	
	static final Integer NUMERO_MAX_MOTOS = 10;
	static final Integer PRECIO_X_HORA_MOTO = 500;
	static final Integer PRECIO_X_DIA_MOTO = 4000;
	static final Integer CILINDRAJE_MAYOR_A = 500;
	static final Integer PRECIO_X_CILINDRAJE_MAYOR_500 = 2000;
	
	public Boolean isCantidadVehiculos(Integer cantidadMotos) {
		return cantidadMotos < NUMERO_MAX_MOTOS;
	}
	
	public Double calcularPrecio(Integer elapsedTime, Integer elapsedDay, Integer cilindraje) {
		
		Double precio;
		
		if(elapsedDay > 0) {
			precio = (double) (elapsedDay * PRECIO_X_DIA_MOTO);
			if(elapsedTime > 0) {
				precio += elapsedTime * PRECIO_X_HORA_MOTO;
			}
		}else {
			precio = (double) (elapsedTime * PRECIO_X_HORA_MOTO);
		}
		if(cilindraje > CILINDRAJE_MAYOR_A)
			precio += PRECIO_X_CILINDRAJE_MAYOR_500;
		
		return precio;
		
	} 

}
