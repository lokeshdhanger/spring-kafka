package com.example.utils;

import org.apache.kafka.common.serialization.Deserializer;

import com.example.bo.Truck;

public class TruckDeserializer implements Deserializer<Truck>{

	@Override
	public Truck deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}

}
