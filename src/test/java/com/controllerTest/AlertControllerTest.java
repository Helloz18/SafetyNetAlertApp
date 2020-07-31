package com.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;

import controller.AlertController;
import dao.ChildWithAgeAndMembersOfFamilyDAO;
import dao.FirestationDAO;
import model.ChildWithAgeAndMembersOfFamily;

@RunWith(SpringRunner.class)
@WebMvcTest(AlertController.class)
@ExtendWith(MockitoExtension.class)
class AlertControllerTest {
	
	private MockMvc mvc;

    @Mock
    private ChildWithAgeAndMembersOfFamilyDAO dao;
    
    FirestationDAO redao = new FirestationDAO();

	
	@Test
	void getAhttpStatusOKforAchildAlert() {
		RestTemplate restTemplate = new RestTemplate();
		String URL ="http://localhost:8080/childAlert";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(URL + "?address=1509%20Culver%20St", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	void getAhttpStatusKOforAchildAlert() {
		RestTemplate restTemplate = new RestTemplate();
		String URL ="http://localhost:8080/childAlert";
		ChildWithAgeAndMembersOfFamily[] response = restTemplate.getForObject(URL+"?address=Unknown", ChildWithAgeAndMembersOfFamily[].class);
		List<ChildWithAgeAndMembersOfFamily> children = new ArrayList<ChildWithAgeAndMembersOfFamily>(Arrays.asList(response));
		assertEquals(children.size(), 0);
	}
	
	@Test
	void getAchildForAnAddress() {
		//GIVEN
		RestTemplate restTemplate = new RestTemplate();
		String URL ="http://localhost:8080/childAlert";
		//WHEN
		ChildWithAgeAndMembersOfFamily[] child = restTemplate.getForObject(URL+"?address=1509 Culver St", ChildWithAgeAndMembersOfFamily[].class);
		List<ChildWithAgeAndMembersOfFamily> children = new ArrayList<ChildWithAgeAndMembersOfFamily>(Arrays.asList(child));
		//THEN
		assertEquals(children.get(0).getChild().getFirstName(), "Tenley");
			
	}

	@Test
	void getChildrenForAnAddress() {
		//GIVEN
		RestTemplate restTemplate = new RestTemplate();
		String URL ="http://localhost:8080/childAlert";
		String address = "1509 Culver St";
		//WHEN
		ChildWithAgeAndMembersOfFamily[] child = restTemplate.getForObject(URL+"?address="+address, ChildWithAgeAndMembersOfFamily[].class);
		List<ChildWithAgeAndMembersOfFamily> children = new ArrayList<ChildWithAgeAndMembersOfFamily>(Arrays.asList(child));
		ChildWithAgeAndMembersOfFamilyDAO dao = new ChildWithAgeAndMembersOfFamilyDAO();
		dao.findByAddress(address);
		//THEN
		assertEquals(children.get(0).getChild().getFirstName(), dao.findByAddress(address).get(0).getChild().getFirstName());
			
	}
	
	@Test
	void getForAnAddress() {
		//GIVEN
		String address = "1509 Culver St";
		//WHEN
		ChildWithAgeAndMembersOfFamilyDAO dao = new ChildWithAgeAndMembersOfFamilyDAO();
		dao.findByAddress(address);
		//THEN
		assertNotNull(dao.findByAddress(address));
			
	}
	
	  	
}
