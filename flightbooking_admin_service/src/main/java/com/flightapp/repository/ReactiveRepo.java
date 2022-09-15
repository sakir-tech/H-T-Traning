package com.flightapp.repository;

import org.springframework.stereotype.Repository;

import com.flightapp.entity.Airline;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
@Repository
public class ReactiveRepo {

	public Flux<Airline> findAllAirLines() {
		// TODO Auto-generated method stub
		 return Flux
				.range(1, 2)
				.delayElements(Duration.ofSeconds(1))
				//.doOnNext(n->System.out.println("Consuming: "+n))
				.map(id->new Airline("Thai Airways","Thai Airways","777896544","Thai",true));
	}

}
