package com.flightapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.Airline;

public interface AirlineRepo extends JpaRepository<Airline, Long> {
	
	
	public Airline findByAirlineName(String airlineName);
	
}
