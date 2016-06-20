package com.serviceprotocolclient.springboot;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpringBootClientExp {

	public static void main(String[] args) {

		try {
			System.out.println(new SpringBootClientExp().getValueFromServer());
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}

	@RequestMapping
	private String getValueFromServer() throws JsonProcessingException, IOException {
		String payLoad = "";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/communication-service/Test Spring Boot...", String.class);

		payLoad = response.getBody();
		JsonNode n = new ObjectMapper().readTree(payLoad);
		payLoad = n.get("message").asText();

		return payLoad;
	}
}
