package com.example.utils;

import org.apache.kafka.common.serialization.Serializer;

import com.example.bo.Truck;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TruckSerializer implements Serializer<Truck>{

	@Override
	public byte[] serialize(String topic, Truck data) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

}
