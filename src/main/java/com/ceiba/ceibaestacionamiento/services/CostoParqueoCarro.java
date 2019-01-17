package com.ceiba.ceibaestacionamiento.services;

/**
 * @author wolsey.rubio
 *
 */
public class CostoParqueoCarro {
	
	static final Integer NUMERO_MAX_CARROS = 20;
	static final Integer PRECIO_X_HORA_CARRO = 1000;
	static final Integer PRECIO_X_DIA_CARRO = 8000;
	static final Integer MAX_HORA_POR_HORA = 8;
	
	public Boolean isCantidadVehiculos(Integer cantidadCarros) {
		return cantidadCarros < NUMERO_MAX_CARROS;
	}
	
	public Double calcularPrecio(Integer elapsedTime, Integer elapsedDay) {
		
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
	
}
