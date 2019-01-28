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
	
	static final int DOMINGO = 1;
	static final int LUNES = 2;
	static final int MARTES = 3;
	static final int MIERCOLES = 4;
	static final int JUEVES = 5;
	static final int VIERNES = 6;
	static final int SABADO = 7;
		
    public int getDiaActual() {
        Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_WEEK);
    }
    
    
    public boolean isVehiculoDiaHabil(int diaActual) {
    	return (diaActual == LUNES || diaActual == DOMINGO);
    }
    
    public boolean placaIniciaConLetra(String placaVehiculo) {
    	return placaVehiculo.toLowerCase().startsWith(LETRA_INICIAL_PLACA);
    }
    
    public boolean isValidoDiaPlaca(String placaVehiculo) {
    	boolean value = true;
    	if( placaIniciaConLetra(placaVehiculo))
    		value = isVehiculoDiaHabil(getDiaActual());
    	return  value;
	}

	public boolean isCapacidadVehiculo(List<Vehiculo> vehiculo, long capacidad) {
		return vehiculo.size() < capacidad;
	}
	
	public boolean isTipoVehiculo(String tipoVehiculoIngresado, String tipoVehiculoPermitido) {
		return tipoVehiculoIngresado.equals(tipoVehiculoPermitido);
	}
	
	@Transactional
	public RegistrarVehiculoDTO registrarIngresoVehiculoRest(Vehiculo vehiculo) {
		
		Vehiculo vehiculoToDTO;
		
		if(isCapacidadVehiculo(vehiculoRepository.findByTipovehiculoAndEstado(CARRO,true),MAX_CARRO) && isTipoVehiculo(vehiculo.getTipovehiculo(),CARRO) && isValidoDiaPlaca(vehiculo.getPlacavehiculo()) ) {
			vehiculoToDTO = vehiculoRepository.save(vehiculo);
			return RegistrarVehiculoDTO.getInstance(vehiculoToDTO);
		}
		
		if(isCapacidadVehiculo(vehiculoRepository.findByTipovehiculoAndEstado(MOTO,true),MAX_MOTO) && isTipoVehiculo(vehiculo.getTipovehiculo(),MOTO) && isValidoDiaPlaca(vehiculo.getPlacavehiculo()) ) {
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
	public List<VehiculoDTO> consultarVehiculosEstacionados() {
		List<Vehiculo> vehiculos = vehiculoRepository.findByEstado(true);
		return VehiculoDTO.getInstanceList(vehiculos);
	}
	
	@Transactional
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}
	
	@Transactional
	public Vehiculo registrarSalidaVehiculo(String placavehiculo) {
		
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

	
}
