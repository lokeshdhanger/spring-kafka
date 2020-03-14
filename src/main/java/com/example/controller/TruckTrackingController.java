package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bo.Truck;
import com.example.service.TruckTrackService;

@RestController
public class TruckTrackingController {
	
	@Autowired
	private TruckTrackService truckTrackService;
	
	@PostMapping("truck")
	public void trackTruck(@RequestBody Truck truck) {
		truckTrackService.save(truck);
	}

}
