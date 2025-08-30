package com.example.demo.radio_streamer.model;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "RADIO")
public class RadioStation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "El nombre no puede estar vacio")
	@Column(name = "name", length = 200, nullable = false)
	private String name;

	@NotBlank(message = "LA URL del stream no puede estar vacia")
	@URL(message = "Debe ser una URL válida")
	@Column(name = "streamurl", length = 1024, nullable = false)
	private String streamUrl;

	@Column(name = "genre", length = 200, nullable = false)
	private String genre;

	@Column(name = "country", length = 200, nullable = false)
	private String country;

	@Column(name = "isfavorite")
	private boolean isFavorite = false;

	public RadioStation() {
	}

	public RadioStation(Integer id, @NotBlank(message = "El nombre no puede estar vacio") String name,
			@NotBlank(message = "LA URL del stream no puede estar vacia") @URL(message = "Debe ser una URL válida") String streamUrl,
			String genre, String country) {
		this.id = id;
		this.name = name;
		this.streamUrl = streamUrl;
		this.genre = genre;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "RadioStation [id=" + id + ", name=" + name + ", streamUrl=" + streamUrl + ", genre=" + genre
				+ ", country=" + country + "]";
	}


}
