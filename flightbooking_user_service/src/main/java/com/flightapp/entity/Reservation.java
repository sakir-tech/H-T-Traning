package com.flightapp.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {

	private String email;
	private Integer pnr;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;

	public Reservation() {
		super();
	}

	public Reservation(String name, String email, Integer pnr, Passenger passenger, Flight flight) {
		super();
		this.email = email;
		this.pnr = pnr;
		this.passenger = passenger;
		this.flight = flight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPnr() {
		return pnr;
	}

	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
