package com.example.demo.radio_streamer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.radio_streamer.model.RadioStation;

@Repository
public interface RadioStationRepository extends JpaRepository<RadioStation, Integer>{

}
