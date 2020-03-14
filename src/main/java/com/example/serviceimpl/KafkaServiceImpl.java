package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.bo.Truck;
import com.example.service.KafkaService;

@Service
public class KafkaServiceImpl implements KafkaService{
	
	@Value("${topic.truck}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, Truck> kafkaTemplate;

	@Override
	public void send(Truck truck) {
		Message<Truck> message = MessageBuilder.withPayload(truck).setHeader(KafkaHeaders.TOPIC, topic).build();
		kafkaTemplate.send(message);		
	}

	@KafkaListener(topics = "truck_events" , groupId = "truck_group")
	@Override
	public void consume(Truck truck) {
		System.out.println("consumed: "+ truck.toString());
	}

}
