package com.flightapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;
import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.repository.AirlineRepo;
import com.flightapp.repository.ReactiveRepo;

import reactor.core.publisher.Flux;

@Service
public class AirlineServiceImpl implements AirlineService {
	@Autowired
	private AirlineRepo airlineRepo;
	
	public AirlineServiceImpl(AirlineRepo airlineRepo) {
		super();
		this.airlineRepo = airlineRepo;
	}
	@Autowired
	private ReactiveRepo reactiveRepo;

	@Override
	public Airline addAirline(Airline airline) {
		airline.setIsActive(true);
		airline.setLogo(airline.getAirlineName()+".png");
		Airline savedAirline = airlineRepo.save(airline);
		return savedAirline;
	}

	@Override
	public List<Airline> getAllAirline() {
		return airlineRepo.findAll();
	}
	
	

//	@Override
//	public Airline getAirline(Long id) {
//		return airlineRepo.findById(id).get();
//	}

	@Override
	public void deleteAirline(Long id) {
		airlineRepo.deleteById(id);
	}

//	@Override
//	public Long updateAirline(Long id, Airline airline) {
//		Airline exsitingAirline = airlineRepo.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Airline", "id", id));
//		airline.setId(exsitingAirline.getId());
////		exsitingAirline.setAirlineName(airline.getAirlineName());
////		exsitingAirline.setLogo(airline.getLogo());
////		exsitingAirline.setPhone(airline.getPhone());
////		exsitingAirline.setAddress(airline.getAddress());
////		exsitingAirline.setIsActive(airline.getIsActive());
//		airlineRepo.save(airline);
//		return exsitingAirline.getId();
//	}

	@Override
	public Long enableAirline(Long id) {
		Airline exsitingAirline = airlineRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airline", "id", id));
		exsitingAirline.setIsActive(true);
		airlineRepo.save(exsitingAirline);
		return exsitingAirline.getId();
	}

	@Override
	public Long disableAirline(Long id) {
		Airline exsitingAirline = airlineRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airline", "id", id));
		exsitingAirline.setIsActive(false);
		airlineRepo.save(exsitingAirline);
		return exsitingAirline.getId();
	}

	public Flux<Airline> findAllAirLines() {
		// TODO Auto-generated method stub
		return reactiveRepo.findAllAirLines();
	}
}