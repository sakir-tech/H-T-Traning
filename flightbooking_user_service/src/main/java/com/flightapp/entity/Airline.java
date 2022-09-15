package com.flightapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Airline extends AbstractEntity {
    @Column(unique = true,length = 100)
	private String airlineName;
	private String logo;
	private String phone;
	private String address;
	private Boolean isActive;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "airline")
	private List<Flight> flights=new ArrayList();

	public Airline() {
		super();
	}

	public Airline(String airlineName, String logo, String phone, String address, Boolean isActive,
			List<Flight> flights) {
		super();
		this.airlineName = airlineName;
		this.logo = logo;
		this.phone = phone;
		this.address = address;
		this.isActive = isActive;
		this.flights = flights;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Airline [airlineName=" + airlineName + ", logo=" + logo + ", phone=" + phone + ", address=" + address
				+ ", isActive=" + isActive + ", flights=" + flights + "]";
	}

}
