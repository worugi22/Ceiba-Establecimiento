package com.ceiba.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity(name="carro")
public class Carro {
	
	private int idCar;
	private String placaCarro;
	
	
}
