package com.example.utils;

import org.apache.kafka.common.serialization.Serializer;

import com.example.bo.Truck;

public class TruckSerializer implements Serializer<Truck>{

	@Override
	public byte[] serialize(String topic, Truck data) {
		// TODO Auto-generated method stub
		return null;
	}

}
