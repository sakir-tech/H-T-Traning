package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.dto.ReservationRequest;
import com.flightapp.entity.Reservation;
import com.flightapp.entity.Response;
import com.flightapp.service.ReservationServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReservationController {

	@Autowired
	ReservationServiceImpl reservationService;

	@PostMapping("/bookflight/{id}")
	public ResponseEntity<?> bookFlight(@RequestBody ReservationRequest request,@PathVariable Long id) {
		try {
            reservationService.bookFlight(request, id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Not Booked,Please check the Details Properly");
		}
		return ResponseEntity.status(HttpStatus.OK).body(new Response("Flight booked Successfully"));
	}
	
	@GetMapping("/booking/history/{email}")
	public ResponseEntity<?> bookingHistory(@PathVariable String email){
		List<Reservation> bookingHistory = reservationService.bookingHistory(email);
		if(bookingHistory.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Tickets Found");
		}
		return  ResponseEntity.status(HttpStatus.OK).body(bookingHistory);
	}
	
	@GetMapping("/ticket/{pnr}")
	public ResponseEntity<?> findTicket(@PathVariable Integer pnr){
		Reservation ticket = reservationService.findTicket(pnr);
		if(ticket==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Ticket Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ticket);
	}
	
	@DeleteMapping("/booking/cancel/{pnr}")
	public ResponseEntity<?> deleteTicket(@PathVariable Integer pnr) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			reservationService.deteleTicket(pnr);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/cancel/{id}")
	public ResponseEntity<?> deteleTicketId(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			reservationService.deteleTicketId(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@GetMapping("/last")
	public Reservation lastTicketDeatils() {
		return this.reservationService.lastTicketDeatils();
	}

}
