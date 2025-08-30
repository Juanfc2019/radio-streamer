package com.example.demo.radio_streamer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.radio_streamer.model.RadioStation;
import com.example.demo.radio_streamer.service.RadioStationService;

import jakarta.validation.Valid;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/stations")
public class RadioStationController {

	private final RadioStationService stationService;

	public RadioStationController(RadioStationService stationService) {
		this.stationService = stationService;
	}
	
	@GetMapping
	public List<RadioStation> getAllStation(){
		return stationService.getAllStations();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RadioStation> getStationById(@PathVariable Integer id){
		return ResponseEntity.ok(stationService.getStationById(id));
	}
	
	@PostMapping
	public ResponseEntity<RadioStation> createStation(@Valid @RequestBody RadioStation station){
		RadioStation newStation = stationService.createStation(station);
		return new ResponseEntity<>(newStation, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RadioStation> updateStation(@PathVariable Integer id, @Valid @RequestBody RadioStation stationDetails){
		return ResponseEntity.ok(stationService.updateStation(id, stationDetails));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStation(@PathVariable Integer id){
		stationService.deleteStation(id);
		return ResponseEntity.noContent().build();
	}
}
