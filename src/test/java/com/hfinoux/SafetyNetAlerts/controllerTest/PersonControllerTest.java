package com.hfinoux.SafetyNetAlerts.controllerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.hfinoux.SafetyNetAlerts.controller.PersonController;

@WebMvcTest(PersonController.class)
@AutoConfigureMockMvc
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;
		
	@Test
	void getTheListOfAllPeopleReturnsOk() throws Exception {
        mockMvc.perform(get("/allPersons")).andExpect(status().isOk()).andReturn();
	}

	@Test
	void getThePersonsInfosGivenAfirstNameAndAlastName() throws UnsupportedEncodingException, Exception {
		//GIVEN
		String firstName = "Eric";
		String lastName = "Cadigan";
		//WHEN
		String personInfos = mockMvc.perform(
				get("/personInfo?firstName="+firstName+"&lastName="+lastName))
				.andReturn()
				.getResponse()
				.getContentAsString();
		
		String emailOfThisPerson = "gramps@email.com";
		//THEN
		assertTrue(personInfos.contains(emailOfThisPerson));
	}
	

	@Test
	public void testPostPerson() throws Exception {
		//GIVEN
	    String person = "{ \"firstName\":\"newFirstName\",\"lastName\":\"newLastName\"}";
	    //WHEN, THEN
	    mockMvc.perform(
	    		post("/person").contentType(MediaType.APPLICATION_JSON).content(person).characterEncoding("utf-8"))
				.andExpect(status().isCreated()).andReturn();
	}
	
	@Test
	public void testPutPerson() throws Exception {
		//GIVEN
	    String ericCadigan = "{ \"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"city\":\"Paris\"}";
		//WHEN, THEN
	    mockMvc.perform(
	    		put("/person").contentType(MediaType.APPLICATION_JSON).content(ericCadigan).characterEncoding("utf-8"))
	    .andExpect(status().isNoContent());		
	}
	
	@Test
	public void testDeletePerson() throws Exception {
		//GIVEN
	    String johnBoyd = "{ \"firstName\":\"John\",\"lastName\":\"Boyd\"}";
		//WHEN, THEN
	    mockMvc.perform(
	    		delete("/person").contentType(MediaType.APPLICATION_JSON).content(johnBoyd).characterEncoding("utf-8"))
	    .andExpect(status().isNoContent());		
	}
}
