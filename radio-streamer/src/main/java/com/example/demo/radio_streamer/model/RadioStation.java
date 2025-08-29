package com.example.demo.radio_streamer.model;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RadioStation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El nombre no puede estar vacio")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "LA URL del stream no puede estar vacia")
	@URL(message = "Debe ser una URL válida")
	@Column(nullable = false, length = 1024)
	private String streamUrl;
	
	private String genre;
	private String country;
	private boolean isFavorite = false;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreamUrl() {
		return streamUrl;
	}
	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isFavorite() {
		return isFavorite;
	}
	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	
	@Override
	public String toString() {
		return "RadioStation [name=" + name + ", streamUrl=" + streamUrl + ", genre=" + genre + ", country=" + country
				+ "]";
	}
	

}
