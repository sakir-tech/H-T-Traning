package com.flightapp.service;


import java.util.List;

import com.flightapp.entity.Flight;

public interface FlightService {
	
	public Flight addFlight(Flight flight);
	
	public Flight getFlight(Long id);
	
	public List<Flight> getAllFlights();
	
	public void deleteFlight(Long id);
	
	public Long updateFlight(Long id,Flight flight);
	
//	List<Flight> searchFlight(String dateOfDeparture, String departureCity, String arrivalCity) throws Exception;

}
