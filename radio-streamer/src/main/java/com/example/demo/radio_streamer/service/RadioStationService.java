package com.example.demo.radio_streamer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.radio_streamer.model.RadioStation;
import com.example.demo.radio_streamer.repository.RadioStationRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RadioStationService {

	private final RadioStationRepository stationRepository;

	public RadioStationService(RadioStationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}
	
	public List<RadioStation> getAllStations(){
		return stationRepository.findAll();
	}
	
	public RadioStation getStationById(Integer id) {
		return stationRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Estación no encontrada con id: "+id));
	}
	
	public RadioStation createStation(RadioStation station) {
		return stationRepository.save(station);
	}
	
	public RadioStation updateStation(Integer id, RadioStation stationDetails) {
		RadioStation station = getStationById(id);
		station.setName(stationDetails.getName());
		station.setStreamUrl(stationDetails.getStreamUrl());
		station.setGenre(stationDetails.getGenre());
		station.setCountry(stationDetails.getCountry());
		station.setFavorite(stationDetails.isFavorite());
		return stationRepository.save(station);
	}
	
	public void deleteStation(Integer id) {
		if(!stationRepository.existsById(id)) {
			throw new EntityNotFoundException("Estación no encontrada con id: "+id);
		}
		stationRepository.deleteById(id);
	}
}
