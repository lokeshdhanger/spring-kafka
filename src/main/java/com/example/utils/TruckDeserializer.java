package com.example.utils;

import org.apache.kafka.common.serialization.Deserializer;

import com.example.bo.Truck;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TruckDeserializer implements Deserializer<Truck>{

	@Override
	public Truck deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		Truck event = null;
		try {
			event = mapper.readValue(data, Truck.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

}
