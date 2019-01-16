/**
 * 
 */
package com.ceiba.ceibaestacionamiento.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.ceibaestacionamiento.repository.IVehiculoRepository;
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
	static final int CARRO = 1;
	static final int MOTO = 2;
//	
	public List<Vehiculo> findByTipovehiculoAndEstado(Integer tipovehiculo, Boolean estado) {
		return vehiculoRepository.findByTipovehiculoAndEstado(tipovehiculo,estado);
	}
//	
	//private int  carrosParqeados = findByTipovehiculoAndEstado(1,true).size();
	//private int  motosParqeadas = findByTipovehiculoAndEstado(2,true).size();
	
	//Reigistrar ingreso vihiculo parquiadero
	@Transactional
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		
		if(findByTipovehiculoAndEstado(MOTO,true).size() < 10 && vehiculo.getTipovehiculo() == MOTO ) {
			return vehiculoRepository.save(vehiculo);
		}
		
		if(findByTipovehiculoAndEstado(CARRO,true).size() < 20 && vehiculo.getTipovehiculo() == CARRO ) {
			return vehiculoRepository.save(vehiculo);
		}
		
		return null;
	}
	
	
//	@Transactional(readOnly = true) // Permite hacer transaciones. se puede omitir viene en el CrupRepository
//	public List<Vehiculo> findByTipovehiculoAndEstado(Integer tipovehiculo, Boolean estado) {
//		return vehiculoRepository.findByTipovehiculoAndEstado(tipovehiculo,estado);
//	}
//	

	@Transactional(readOnly = true) // Permite hacer transaciones. se puede omitir viene en el CrupRepository
	public List<Vehiculo> findAll() {
		return vehiculoRepository.findAll();
	}
	
	@Transactional(readOnly = true) 
	public Vehiculo findByIdvehiculo(Integer idvehiculo) {
		return vehiculoRepository.findByIdvehiculo(idvehiculo);
	}
	
	@Transactional(readOnly = true) 
	public Vehiculo findByPlacavehiculo(String placavehiculo) {
		return vehiculoRepository.findByPlacavehiculo(placavehiculo);
	}

	@Transactional
	public void deleteById(Integer idvehiculo) {
		vehiculoRepository.deleteById(idvehiculo);
	}
	
	@Transactional
	public void deleteByPlacavehiculo(String placavehiuclo) {
		vehiculoRepository.deleteByPlacavehiculo(placavehiuclo);
	}
	

	
	// Business Logic
	
	
	
	


}
