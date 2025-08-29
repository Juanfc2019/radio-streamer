package com.example.demo.radio_streamer;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RadioStreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadioStreamerApplication.class, args);
	}
	
	
	@RestController
	class HelloController {
		@CrossOrigin(value = "*")
		@GetMapping("/api/hello")
		public Map<String, String> sayHello(){
			return Map.of("message","¡Hola desde Spring Boot 6!");
		}
	}

}
