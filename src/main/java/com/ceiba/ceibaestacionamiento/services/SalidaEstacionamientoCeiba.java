package com.ceiba.ceibaestacionamiento.services;



/**
 * @author wolsey.rubio
 *
 */
public class SalidaEstacionamientoCeiba {
	
	static final Integer NUMERO_MAX_CARROS = 20;
	static final Integer PRECIO_X_HORA_CARRO = 1000;
	static final Integer PRECIO_X_DIA_CARRO = 8000;
	static final Integer MAX_HORA_POR_HORA = 8;
	
	static final Integer NUMERO_MAX_MOTOS = 10;
	static final Integer PRECIO_X_HORA_MOTO = 500;
	static final Integer PRECIO_X_DIA_MOTO = 4000;
	static final Integer CILINDRAJE_MAYOR_A = 500;
	static final Integer PRECIO_X_CILINDRAJE_MAYOR_500 = 2000;
	
	public Boolean isCantidadCarros(Integer cantidadCarros) {
		return cantidadCarros < NUMERO_MAX_CARROS;
	}
	
	public Boolean isCantidadMotos(Integer cantidadMotos) {
		return cantidadMotos < NUMERO_MAX_MOTOS;
	}
	
	
	public Double calcularPrecioCarro(Integer elapsedTime, Integer elapsedDay) {
		
		Double precio = null;
		Double relacionHorasMaxHoras =  (double) (elapsedTime/MAX_HORA_POR_HORA);
		
		if(elapsedTime < 9 && elapsedDay == 0) {
			precio = (double) (elapsedTime * PRECIO_X_HORA_CARRO);	
		}else {
			precio = ((relacionHorasMaxHoras) * PRECIO_X_DIA_CARRO) + (elapsedDay * PRECIO_X_DIA_CARRO);
			if(elapsedTime < 9)
				precio += elapsedTime * PRECIO_X_HORA_CARRO; 
		}
		
		return precio;
		
	} 
	

	public Double calcularPrecioMoto(Integer elapsedTime, Integer elapsedDay, Integer cilindraje) {
		
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
