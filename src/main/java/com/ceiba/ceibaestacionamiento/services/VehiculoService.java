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
	
	//Tipos de vehiculos que pueden ingresar.
	static final String CARRO = "carro";
	static final String MOTO = "moto";
	
	static final Integer DOMINGO = 1;
	static final Integer LUNES = 2;
	
	Vehiculo vehiculo;

	Date now = new Date();
    Calendar calendar = Calendar.getInstance();
    int dia = calendar.get(Calendar.DAY_OF_WEEK);
    

	public boolean isValidoIngreso() {
		boolean value = false;
		if( (dia != LUNES || dia != DOMINGO)) {
			if(!(vehiculo.getPlacavehiculo().substring(0).toLowerCase().startsWith("a")))
				value = true;
		}
		return value;
	}
	
	public List<Vehiculo> findByTipovehiculoAndEstado(String tipovehiculo, Boolean estado) {
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
	

	@Transactional(readOnly = true) // Permite hacer transaciones. se puede omitir viene en el CrupRepository
	public List<Vehiculo> findAll() {
		return vehiculoRepository.findAll();
	}
	
	@Transactional(readOnly = true) // Permite hacer transaciones. se puede omitir viene en el CrupRepository
	public List<VehiculoDTO> consultarVehiculosEstacionados(Boolean estado) {
		List<Vehiculo> lista = vehiculoRepository.findByEstado(estado);
		return VehiculoDTO.getInstanceList(lista);
	}
	
	//TERMINAR --->>>>
	@Transactional(readOnly = true) // Permite hacer transaciones. se puede omitir viene en el CrupRepository
	public List<Vehiculo> consultarVehiculoEstacionado(String placavehidulo, Boolean estado) {
		return vehiculoRepository.findAllByPlacavehiculoAndEstado(placavehidulo, estado);
	}
	
	@Transactional(readOnly = true) // Permite hacer transaciones. se puede omitir viene en el CrupRepository
	public Vehiculo consultarVehiculoEstacionado1(String placavehidulo, Boolean estado) {
		return vehiculoRepository.findByPlacavehiculoAndEstado(placavehidulo, estado);
	}
	
	@Transactional(readOnly = true) 
	public Vehiculo findByIdvehiculo(Integer idvehiculo) {
		return vehiculoRepository.findByIdvehiculo(idvehiculo);
	}
	
	
	@Transactional(readOnly = true) 
	public Vehiculo findByPlacavehiculo(String placavehiculo) {
		return vehiculoRepository.findByPlacavehiculo(placavehiculo);
	}

//	@Transactional
//	public void deleteById(Integer idvehiculo) {
//		vehiculoRepository.deleteById(idvehiculo);
//	}
//	
//	@Transactional
//	public void deleteByPlacavehiculo(String placavehiuclo) {
//		vehiculoRepository.deleteByPlacavehiculo(placavehiuclo);
//	}
//	

	
	// Business Logic
	
	
	
	


}
