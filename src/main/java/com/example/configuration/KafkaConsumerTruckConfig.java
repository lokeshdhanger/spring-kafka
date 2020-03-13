package com.example.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.example.bo.Truck;
import com.example.utils.TruckDeserializer;


@EnableKafka
@Configuration
public class KafkaConsumerTruckConfig {
	
	@Value("${kafka.bootstrap.address}")
	private String bootstrapAddress;
	
	@Value("${kafka.truck.consumer.group.id}")
	private String truckConsumerGroupId;
	
	@Bean
	public Map<String, Object> consumerConfigs(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, TruckDeserializer.class);
		map.put(ConsumerConfig.GROUP_ID_CONFIG, truckConsumerGroupId);
		return map;
	}
	
	@Bean
	public ConsumerFactory<String, Object> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}
	
	public ConcurrentKafkaListenerContainerFactory<String, Truck> kafkaTruckListnerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Truck> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	
	

}
