package com.flightapp.service;

import java.util.List;

import com.flightapp.entity.Airline;

public interface AirlineService {
	
	public Airline addAirline(Airline airline);
	
//	public Long updateAirline(Long id,Airline airline);
	
	public Long enableAirline(Long id);
	
	public Long disableAirline(Long id);
	
	public List<Airline> getAllAirline();
	
//	public Airline getAirline(Long id);
	
	public void deleteAirline(Long id);

}
