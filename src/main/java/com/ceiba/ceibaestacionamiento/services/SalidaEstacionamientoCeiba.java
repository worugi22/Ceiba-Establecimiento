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
	
	
	public static double calcularPrecioCarro(long horas, long dias) {
		
		double precio;
		double factor =   (double)horas/MAX_HORA_POR_HORA;
		
		
		if(horas <= MAX_HORA_POR_HORA && dias == 0) {
			precio = (double) (horas * PRECIO_X_HORA_CARRO);	
		}else {
			precio = (Math.floor(factor) * PRECIO_X_DIA_CARRO) + (dias * PRECIO_X_DIA_CARRO);
			if(horas <= MAX_HORA_POR_HORA)
				precio += horas * PRECIO_X_HORA_CARRO; 
		}
		
		return precio;
		
	} 
	

	public static double calcularPrecioMoto(long horas, long dias, long cilindraje) {
		
		double precio;
		
		if(dias > 0) {
			precio = (double) (dias * PRECIO_X_DIA_MOTO);
			if(horas > 0) {
				precio += horas * PRECIO_X_HORA_MOTO;
			}
		}else {
			precio = (double) (horas * PRECIO_X_HORA_MOTO);
		}
		if(cilindraje > CILINDRAJE_MAYOR_A)
			precio += PRECIO_X_CILINDRAJE_MAYOR_500;
		
		return precio;
		
	} 
	
	
	
	
	
}
