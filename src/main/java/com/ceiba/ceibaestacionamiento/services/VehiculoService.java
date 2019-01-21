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
import com.ceiba.ceibaestacionamiento.dto.RegistrarVehiculoDTO;
import com.ceiba.ceibaestacionamiento.dto.VehiculoDTO;
import com.ceiba.ceibaestacionamiento.model.Vehiculo;

/**
 * @author wolsey.rubio
 *
 */

@Service
public class VehiculoService{
	
	@Autowired // Inyectar el Repository.
	private IVehiculoRepository vehiculoRepository;
	Vehiculo vehiculo;

	//Tipos de vehiculos que pueden ingresar.
	static final String CARRO = "carro";
	static final Integer MAX_CARRO = 20;
	static final String MOTO = "moto";
	static final Integer MAX_MOTO = 10;
	
	static final Integer DOMINGO = 1;
	static final Integer LUNES = 2;
	static final Integer MARTES = 3;
	static final Integer MIERCOLES = 4;
	static final Integer JUEVES = 5;
	static final Integer VIERNES = 6;
	static final Integer SABADO = 7;

	Date now = new Date();
    Calendar calendar = Calendar.getInstance();
    int dia = calendar.get(Calendar.DAY_OF_WEEK);
    
    private boolean isDiferentede(String incialPlaca) {
    	return !(vehiculo.getPlacavehiculo().toLowerCase().startsWith(incialPlaca));
    }

    
	public boolean isValidoIngreso() {
		boolean value = false;
		if( (dia != LUNES || dia != DOMINGO)) {
			if(isDiferentede("a"))
				value = true;
		}
		return value;
	}
	
	public List<Vehiculo> findByTipovehiculoAndEstado(String tipovehiculo, Boolean estado) {
		return vehiculoRepository.findByTipovehiculoAndEstado(tipovehiculo,estado);
	}
 
	
	//*** Servicio para registrar vehiculo validados.
	@Transactional
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		if(findByTipovehiculoAndEstado(CARRO,true).size() < 20 && vehiculo.getTipovehiculo().equals(CARRO)) 
			return vehiculoRepository.save(vehiculo);
		if(findByTipovehiculoAndEstado(MOTO,true).size() < 10 && vehiculo.getTipovehiculo().equals(MOTO)) 
			return vehiculoRepository.save(vehiculo);
		return null;
	}
	
	//*** Servicio para registrar vehiculo validados.
	@Transactional
	public RegistrarVehiculoDTO registrarVehiculoRest(Vehiculo vehiculo) {
			Vehiculo vehiculoToDTO = vehiculoRepository.save(vehiculo);
			
			if(findByTipovehiculoAndEstado(CARRO,true).size() < MAX_CARRO && vehiculo.getTipovehiculo().equals(CARRO)) 
				return RegistrarVehiculoDTO.getInstance(vehiculoToDTO);
			if(findByTipovehiculoAndEstado("moto",true).size() < MAX_MOTO && vehiculo.getTipovehiculo().equals(MOTO)) 
				return RegistrarVehiculoDTO.getInstance(vehiculoToDTO);
			
			return null;
	}
	
	//*** Servicio para consultar todos los vehiculos estacionados.
	@Transactional(readOnly = true)
	public List<VehiculoDTO> consultarVehiculosEstacionados(Boolean estado) {
		List<Vehiculo> vehiculos = vehiculoRepository.findByEstado(estado);
		return VehiculoDTO.getInstanceList(vehiculos);
	}
	
	//*** Servicio retiro de vehiculo.
	@Transactional(readOnly = true) 
	public Vehiculo consultarVehiculoEstacionado(String placavehidulo, Boolean estado) {
		return vehiculoRepository.findByPlacavehiculoAndEstado(placavehidulo, estado);
	}
	

	
	// Business Logic
	
	
	
	


}
