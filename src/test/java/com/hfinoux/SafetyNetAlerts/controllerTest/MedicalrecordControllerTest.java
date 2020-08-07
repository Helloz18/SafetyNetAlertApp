package com.hfinoux.SafetyNetAlerts.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.hfinoux.SafetyNetAlerts.controller.MedicalrecordController;

@WebMvcTest(MedicalrecordController.class)
@AutoConfigureMockMvc
class MedicalrecordControllerTest {

	@Autowired
	private MockMvc mockMvc;
		
	@Test
	void getTheListOfAllPeopleReturnsOk() throws Exception {
        mockMvc.perform(get("/allMedicalrecords")).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void testPostMedicalrecord() throws Exception {
		//GIVEN
	    String medicalRecordToPost = "{\"firstName\":\"NewJohn\",\"lastName\":\"NewBoyd\",\"birthdate\":\"01/01/2001\",\"medications\":[\"medication1:350mg\",\"medication2:100mg\"],\"allergies\":[\"nillacilan\"]}";
	    //WHEN, THEN
	    mockMvc.perform(
	    		post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(medicalRecordToPost).characterEncoding("utf-8"))
				.andExpect(status().isCreated()).andReturn();
	}
	
	@Test
	public void testPutMedicalrecord() throws Exception {
		//GIVEN
	    String ericCadigan = "{ \"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"birthdate\":\"08/08/8888\"}";
		//WHEN, THEN
	    mockMvc.perform(
	    		put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(ericCadigan).characterEncoding("utf-8"))
	    .andExpect(status().isNoContent());		
	}
	
	@Test
	public void testDeleteMedicalrecord() throws Exception {
		//GIVEN
	    String medicalrecordToDelete = "{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"birthdate\":\"03/06/1984\",\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"],\"allergies\":[\"nillacilan\"]}";
	    //WHEN, THEN
	    mockMvc.perform(
	    		delete("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(medicalrecordToDelete).characterEncoding("utf-8"))
	    .andExpect(status().isNoContent());		
	}
}
