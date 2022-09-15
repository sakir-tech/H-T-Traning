package com.flightapp.dto;

public class ReservationRequest {

	private Long flightId;
	private String email;
	private String passengerName;
	private String passengerGender;
	private String meal;
	private Integer age;
	private String passengerPhone;
	private String nameOnTheCard;
	private String cardNumber;
	private String expiryDate;
	private Integer cvv;

	public ReservationRequest() {
		super();
	}

	public ReservationRequest(Long flightId, String email, String passengerName, String passengerGender, String meal,
			Integer age, String passengerPhone, String nameOnTheCard, String cardNumber, String expiryDate,
			Integer cvv) {
		super();
		this.flightId = flightId;
		this.email = email;
		this.passengerName = passengerName;
		this.passengerGender = passengerGender;
		this.meal = meal;
		this.age = age;
		this.passengerPhone = passengerPhone;
		this.nameOnTheCard = nameOnTheCard;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getNameOnTheCard() {
		return nameOnTheCard;
	}

	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", email=" + email + ", passengerName=" + passengerName
				+ ", passengerGender=" + passengerGender + ", meal=" + meal + ", age=" + age + ", passengerPhone="
				+ passengerPhone + ", nameOnTheCard=" + nameOnTheCard + ", cardNumber=" + cardNumber + ", expiryDate="
				+ expiryDate + ", cvv=" + cvv + "]";
	}

}
