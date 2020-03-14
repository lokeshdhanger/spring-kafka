package com.example.service;

import com.example.bo.Truck;

public interface KafkaService {

	public void send(Truck truck);

	public void consume(Truck truck);
}
