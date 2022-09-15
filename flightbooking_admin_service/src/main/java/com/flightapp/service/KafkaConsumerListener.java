package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;

@Service
public class KafkaConsumerListener {
	 private final String TOPIC = "Kafka-Airline-Topic";
	 @Autowired
	 private AirlineServiceImpl airlineSevice;

	    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
	    public void consumeJson(Airline airline) {
	    	airlineSevice.addAirline(airline);
	        System.out.println("Consumed JSON Message: " + airline);
	    }
	    

}
