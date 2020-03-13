package com.example.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.example.bo.Truck;
import com.example.utils.TruckSerializer;

@Configuration
public class KafkaProducerTruckConfig {
	
	
	@Value("${kafka.bootstrap.address}")
	private String bootstrapAddress;
	
	@Bean
	public Map<String, Object> producerConfigs(){
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, TruckSerializer.class);
		producerConfig.put(ProducerConfig.ACKS_CONFIG, "all");
		return producerConfig;
	}
	
	@Bean
	public ProducerFactory<String, Truck> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());				
	}
	
	@Bean
	public KafkaTemplate<String, Truck> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}

}
