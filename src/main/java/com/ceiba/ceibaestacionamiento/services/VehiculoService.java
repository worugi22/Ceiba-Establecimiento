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
	
	@Autowired 
	private IVehiculoRepository vehiculoRepository;
	Vehiculo vehiculo;

	static final String CARRO = "carro";
	static final long MAX_CARRO = 20;
	static final String MOTO = "moto";
	static final long MAX_MOTO = 10;
	
	static final long DOMINGO = 1;
	static final long LUNES = 2;
	static final long MARTES = 3;
	static final long MIERCOLES = 4;
	static final long JUEVES = 5;
	static final long VIERNES = 6;
	static final long SABADO = 7;

	Date now = new Date();
    Calendar calendar = Calendar.getInstance();
    long dia = calendar.get(Calendar.DAY_OF_WEEK);
    
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
	
	public List<Vehiculo> findByTipovehiculoAndEstado(String tipovehiculo, boolean estado) {
		return vehiculoRepository.findByTipovehiculoAndEstado(tipovehiculo,estado);
	}
 
	
	@Transactional
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		if(findByTipovehiculoAndEstado(CARRO,true).size() < 20 && vehiculo.getTipovehiculo().equals(CARRO)) 
			return vehiculoRepository.save(vehiculo);
		if(findByTipovehiculoAndEstado(MOTO,true).size() < 10 && vehiculo.getTipovehiculo().equals(MOTO)) 
			return vehiculoRepository.save(vehiculo);
		return null;
	}
	

	@Transactional
	public RegistrarVehiculoDTO registrarVehiculoRest(Vehiculo vehiculo) {
			Vehiculo vehiculoToDTO = vehiculoRepository.save(vehiculo);
			
			if(findByTipovehiculoAndEstado(CARRO,true).size() < MAX_CARRO && vehiculo.getTipovehiculo().equals(CARRO)) 
				return RegistrarVehiculoDTO.getInstance(vehiculoToDTO);
			if(findByTipovehiculoAndEstado("moto",true).size() < MAX_MOTO && vehiculo.getTipovehiculo().equals(MOTO)) 
				return RegistrarVehiculoDTO.getInstance(vehiculoToDTO);
			
			return null;
	}
	
	@Transactional(readOnly = true)
	public List<VehiculoDTO> consultarVehiculosEstacionados(boolean estado) {
		List<Vehiculo> vehiculos = vehiculoRepository.findByEstado(estado);
		return VehiculoDTO.getInstanceList(vehiculos);
	}
	
	@Transactional(readOnly = true) 
	public Vehiculo consultarVehiculoEstacionado(String placavehidulo, boolean estado) {
		
		
		return vehiculoRepository.findByPlacavehiculoAndEstado(placavehidulo, estado);
	}
	
	@Transactional() 
	public Vehiculo save(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}

	
	// Business Logic
	
	
	
	


}
