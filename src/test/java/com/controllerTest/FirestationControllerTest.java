package com.controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class FirestationControllerTest {

	@Test
	void getAhttpStatusOKforAfirestaion() {
		RestTemplate restTemplate = new RestTemplate();
		String URL ="http://localhost:8080/firestation";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(URL + "/1", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	
	
//	@Test
//	void getAbadRequestIfNoFirestaion() {
//		RestTemplate restTemplate = new RestTemplate();
//		String URL ="http://localhost:8080/firestation";
//		ResponseEntity<String> response
//		  = restTemplate.getForEntity(URL + "/test", String.class);
//		System.out.println(response.getStatusCodeValue());
//		assertEquals(response.getStatusCodeValue(), 400);
//	}

}
