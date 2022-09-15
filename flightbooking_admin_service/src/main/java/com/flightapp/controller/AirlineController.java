package com.flightapp.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Admin;
import com.flightapp.entity.Airline;
import com.flightapp.entity.Response;
import com.flightapp.service.AirlineServiceImpl;
//import com.google.common.net.MediaType;

import reactor.core.publisher.Flux;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AirlineController {
	@Autowired
	private AirlineServiceImpl airlineSevice;

	@Autowired
	private KafkaTemplate<String, Airline> kafkaTemplate;

	private static final String TOPIC = "Kafka-Airline-Topic";

	public AirlineController(AirlineServiceImpl airlineSevice) {
		super();
		this.airlineSevice = airlineSevice;
	}

//	@GetMapping("/test")
//	public Admin welcome() {
//		return new Admin(1L,"Sadik","123");
//	}

	@PostMapping("/addAirline")
	public ResponseEntity<?> addAirline(@RequestBody Airline airline) {
		try {
			airlineSevice.addAirline(airline);
			return ResponseEntity.status(HttpStatus.OK).body(new Response("Airline added successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Airline already added"));
		}
	}

	@GetMapping("/allAirline")
	public List<Airline> getAllAirline() {
		return airlineSevice.getAllAirline();
	}

//	@GetMapping("/airline/{id}")
//	public Airline getAirline(@PathVariable Long id) {
//		return airlineSevice.getAirline(id);		
//	}
//	
//	@PutMapping("/updateAirline/{id}")
//	public ResponseEntity<Airline> updateAirline(@PathVariable Long id,@RequestBody Airline airline){
//		ResponseEntity<Airline> responseEntity=new ResponseEntity<>(HttpStatus.OK);
//		try {
//			airlineSevice.updateAirline(id, airline);
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseEntity=new ResponseEntity<Airline>(HttpStatus.NOT_FOUND);
//		}
//		return responseEntity;	
//	}
//	
	@PutMapping("/enableAirline/{id}")
	public ResponseEntity<Airline> enableAirline(@PathVariable Long id) {
		ResponseEntity<Airline> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			airlineSevice.enableAirline(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Airline>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@PutMapping("/disableAirline/{id}")
	public ResponseEntity<Airline> disableAirline(@PathVariable Long id) {
		ResponseEntity<Airline> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			airlineSevice.disableAirline(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Airline>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@DeleteMapping("/deleteAirline/{id}")
	public ResponseEntity<Airline> deleteAirline(@PathVariable Long id) {
		ResponseEntity<Airline> responseEntity = new ResponseEntity<Airline>(HttpStatus.OK);
		try {
			airlineSevice.deleteAirline(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Airline>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	

	@GetMapping("/publishAirline")
	public String publishAirline() {

		// int id = (int)(Math.floor(Math.random()*100));
		kafkaTemplate.send(TOPIC, new Airline("Dubai Airways", "Dubai Airways", "777896544", "Dubai", true));

		return "Published successfully: " + LocalDateTime.now();
	}

	@RequestMapping(value = "/airlinesAll", method = RequestMethod.GET, produces = { MediaType.TEXT_EVENT_STREAM_VALUE })
	public Flux<Airline> findAllAirlines() {
		Flux<Airline> a = airlineSevice.findAllAirLines();
		return a;
	}

//	 @RequestMapping(value = "/airlineAll", method=RequestMethod.GET)
//		public Flux<Airline> findAllAirline(){
//			return  airlineSevice.getAllAirline();
//		}
}
