package com.flightapp.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flight extends AbstractEntity {

	private String flightNumber;
	private String airlineName;
	private String departureCity;
	private String arrivalCity;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Meal meal;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfDeparture;
	private Integer bussinessSeat;
	private Integer nonBussinessSeat;
	private Double price;
	@ManyToOne
	@JsonIgnore
	private Airline airline;

	public Flight() {
	}

	public Flight(String flightNumber, String airlineName, String departureCity, String arrivalCity, Meal meal,
			Date dateOfDeparture, Integer bussinessSeat, Integer nonBussinessSeat, Double price, Airline airline) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.meal = meal;
		this.dateOfDeparture = dateOfDeparture;
		this.bussinessSeat = bussinessSeat;
		this.nonBussinessSeat = nonBussinessSeat;
		this.price = price;
		this.airline = airline;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Integer getBussinessSeat() {
		return bussinessSeat;
	}

	public void setBussinessSeat(Integer bussinessSeat) {
		this.bussinessSeat = bussinessSeat;
	}

	public Integer getNonBussinessSeat() {
		return nonBussinessSeat;
	}

	public void setNonBussinessSeat(Integer nonBussinessSeat) {
		this.nonBussinessSeat = nonBussinessSeat;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
}