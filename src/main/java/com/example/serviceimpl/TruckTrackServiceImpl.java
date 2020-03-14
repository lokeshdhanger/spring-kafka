package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bo.Truck;
import com.example.service.KafkaService;
import com.example.service.TruckTrackService;

@Service
public class TruckTrackServiceImpl implements TruckTrackService{

	@Autowired
	private KafkaService kafkaService;
	
	@Override
	public Truck save(Truck truck) {
		kafkaService.send(truck);
		
		return truck;
	}

}
