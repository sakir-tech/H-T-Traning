package com.flightapp.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.Flight;

public interface FlightRepo extends JpaRepository<Flight, Long> {
	
 // public List<Flight> findByDateOfDepartureAndDepartureCityAndArrivalCity(Date date,String departureCity,String arrivalCity );

}
