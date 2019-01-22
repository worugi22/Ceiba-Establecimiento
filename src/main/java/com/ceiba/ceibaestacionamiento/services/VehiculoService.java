/**
 * 
 */
package com.ceiba.ceibaestacionamiento.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ceiba.ceibaestacionamiento.repository.IVehiculoRepository;
import com.ceiba.ceibaestacionamiento.util.EstacionamientoUtils;
import com.ceiba.ceibaestacionamiento.dto.RegistrarVehiculoDTO;
import com.ceiba.ceibaestacionamiento.dto.VehiculoDTO;
import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */

@Service
public class VehiculoService {
	
	@Autowired 
	private IVehiculoRepository vehiculoRepository;
	
	static Vehiculo vehiculo;

	static final String CARRO = "carro";
	static final long MAX_CARRO = 20;
	static final String MOTO = "moto";
	static final Integer MAX_MOTO = 10;
	
	static final String LETRA_INICIAL_PLACA = "a";
	
	static final long DOMINGO = 1;
	static final long LUNES = 2;
	static final long MARTES = 3;
	static final long MIERCOLES = 4;
	static final long JUEVES = 5;
	static final long VIERNES = 6;
	static final long SABADO = 7;
	
	Date now = new Date();
    Calendar calendar = Calendar.getInstance();
    long diaActual = calendar.get(Calendar.DAY_OF_WEEK);
    
    public boolean isPrimeraLetraPlaca(String placa, String incialPlaca) {
    	return (placa.toLowerCase().startsWith(incialPlaca));
	}
    public boolean isValidoDiaPlaca(Vehiculo vehiculo) {
    	boolean value = true;
    	if((isPrimeraLetraPlaca(vehiculo.getPlacavehiculo(), LETRA_INICIAL_PLACA)))
    		value = (diaActual == LUNES || diaActual == DOMINGO);
    	return  value;
	}
		
    public boolean isVehiculoEstacionado(Vehiculo vehiculo) {
    	return (vehiculoRepository.findByPlacavehiculo(vehiculo.getPlacavehiculo().toLowerCase()));
	}
	public boolean isCapacidadVehiculoTipoVehiculo(Vehiculo vehiculo, String tipoVehiuclo,long capacida) {
		return vehiculoRepository.findByTipovehiculoAndEstado(tipoVehiuclo,true).size() < capacida && vehiculo.getTipovehiculo().equals(tipoVehiuclo);
	}
	
	@Transactional
	public Vehiculo salida(String placavehiculo) {
		Vehiculo vehiculoActual = this.consultarVehiculoEstacionado(placavehiculo, true);		
		Date fechaSalida = new Date();
		vehiculoActual.setFechasalida(fechaSalida);
		
	
		Date fechaIngreso = vehiculoActual.getFechaingreso();
		
	
		long horas = EstacionamientoUtils.calcularHoras(fechaIngreso, fechaSalida);
		long dias = EstacionamientoUtils.calcularHoras(fechaIngreso, fechaSalida)/24;
		
		
		String tipoVehiculo = vehiculoActual.getTipovehiculo();
		double costo = 0;
		long cilindrajeVehiculo;
		cilindrajeVehiculo = vehiculoActual.getCilindrajevehiculo();

		switch(tipoVehiculo) {
		  case CARRO:
			  costo = CostoParqueadero.calcularPrecioCarro(horas, dias);
		    break;
		  case MOTO:
			  costo = CostoParqueadero.calcularPrecioMoto(horas, dias, cilindrajeVehiculo);
		    break;
		  default:
		}
		
		vehiculoActual.setCosto(costo);
		vehiculoActual.setEstado(false);
		
		this.registrarVehiculo(vehiculoActual);
		return vehiculoActual;
	}
	
	
	@Transactional
	public RegistrarVehiculoDTO registrarIngresoVehiculoRest(Vehiculo vehiculo) {
		
		Vehiculo vehiculoToDTO;
		
		if(isCapacidadVehiculoTipoVehiculo(vehiculo,CARRO,MAX_CARRO) && isValidoDiaPlaca(vehiculo) ) {
			vehiculoToDTO = vehiculoRepository.save(vehiculo);
			return RegistrarVehiculoDTO.getInstance(vehiculoToDTO);
		}
		if(isCapacidadVehiculoTipoVehiculo(vehiculo,MOTO,MAX_MOTO) && isValidoDiaPlaca(vehiculo) ) {
			vehiculoToDTO = vehiculoRepository.save(vehiculo);
			return RegistrarVehiculoDTO.getInstance(vehiculoToDTO);
		}
		return null;
	}
	
	
	@Transactional(readOnly = true) 
	public Vehiculo consultarVehiculoEstacionado(String placavehidulo, boolean estado) {
		return vehiculoRepository.findByPlacavehiculoAndEstado(placavehidulo, estado);
	}
	
	@Transactional(readOnly = true)
	public List<VehiculoDTO> consultarVehiculosEstacionados(boolean estado) {
		List<Vehiculo> vehiculos = vehiculoRepository.findByEstado(estado);
		return VehiculoDTO.getInstanceList(vehiculos);
	}
	
	@Transactional
	public Vehiculo registrarSalidaVehiculo(Vehiculo vehiculoActual) {
		return vehiculoRepository.save(vehiculo);
	}
	
	@Transactional
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}
	
	@Transactional()
	public List<Vehiculo> findByTipovehiculoAndEstado(String tipovehiculo, boolean estado) {
		return vehiculoRepository.findByTipovehiculoAndEstado(tipovehiculo,estado);
	}
	
	@Transactional() 
	public Vehiculo save(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}

	
	



}
