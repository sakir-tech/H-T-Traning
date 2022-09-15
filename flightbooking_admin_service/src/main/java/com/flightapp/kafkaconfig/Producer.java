package com.flightapp.kafkaconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.flightapp.entity.Airline;

@Configuration
public class Producer {
	 @Bean
	    public ProducerFactory<String, Airline> producerFactory() {
	        Map<String, Object> config = new HashMap<>();

	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

	        return new DefaultKafkaProducerFactory<String, Airline>(config);
	    }

	    @Bean
	    public KafkaTemplate<String, Airline> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }


}
