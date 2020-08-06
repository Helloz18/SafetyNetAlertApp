package com.hfinoux.SafetyNetAlerts.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.hfinoux.SafetyNetAlerts.controller.FirestationController;


@WebMvcTest(FirestationController.class)
@AutoConfigureMockMvc
class FirestationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;


	@Test
	public void testPostFirestation() throws Exception {
		//GIVEN
	    String firestation = "{ \"address\":\"newAddress\",\"station\":\"8\"}";
	    //WHEN, THEN
	    mockMvc.perform(
	    		post("/firestation").contentType(MediaType.APPLICATION_JSON).content(firestation).characterEncoding("utf-8"))
				.andExpect(status().isCreated()).andReturn();
	    
	}
	
    @Test
    void getFirestationsInfos() throws Exception {
        mockMvc.perform(get("/firestations-infos")).andExpect(status().isOk());
    }
	

	@Test
	public void testPutFirestation() throws Exception {
		//GIVEN
	    String stationToUpdate = "{ \"address\":\"29 15th St\",\"station\":\"22\"}";
		//WHEN, THEN
	    mockMvc.perform(
	    		put("/firestation").contentType(MediaType.APPLICATION_JSON).content(stationToUpdate).characterEncoding("utf-8"))
	    .andExpect(status().isNoContent());		
	}
	
	@Test
	public void testDeleteFirestation() throws Exception {
		//GIVEN
	    String stationToDelete = "{ \"address\":\"1509 Culver St\",\"station\":\"3\"}";
		//WHEN, THEN
	    mockMvc.perform(
	    		delete("/firestation").contentType(MediaType.APPLICATION_JSON).content(stationToDelete).characterEncoding("utf-8"))
	    .andExpect(status().isNoContent());		
	}
	
	@Test
	public void getPeopleByStation() throws Exception {
		//GIVEN
		int stationNumber = 1;
	    //WHEN, THEN
	    mockMvc.perform(
	    		get("/firestation/"+stationNumber)).andExpect(status().isOk());  
	}
	
	@Test
	public void getPeopleSupervisedByFirestation() throws Exception {
		//GIVEN
		int stationNumber = 1;
	    //WHEN, THEN
	    mockMvc.perform(
	    		get("/firestation?stationNumber="+stationNumber)).andExpect(status().isOk());  
	}
	
	@Test
	public void getPeopleWithMedicalRecordsFromAnAddress() throws Exception {
		//GIVEN
		String address = "1509 Culver St";
	    //WHEN, THEN
	    mockMvc.perform(
	    		get("/fire?address="+address)).andExpect(status().isOk());  
	}
}
