package com.flightapp.controller;

import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Flight;
import com.flightapp.entity.Response;
import com.flightapp.service.FlightServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FlightController {
	@Autowired
	FlightServiceImpl flightService;
	
	
	@GetMapping("/")
	public Response test() {
		return new Response("Welcome to User Service");
	}

	@GetMapping("/searchFlight/{dateOfDeparture}/{departureCity}/{arrivalCity}")
	public ResponseEntity<?> searchFlight(@PathVariable String dateOfDeparture,@PathVariable String departureCity,@PathVariable String arrivalCity ) throws Exception{ 
		List<Flight> flights = flightService.searchFlight(dateOfDeparture, departureCity, arrivalCity);
		if(flights.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight not found");
		}
		return 	ResponseEntity.ok(flights);
	}
	
	@GetMapping("/flight/{id}")
	public Flight getFlight(@PathVariable Long id) {
		return flightService.getFlight(id);
	}

}
