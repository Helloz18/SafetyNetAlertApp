package com.hfinoux.SafetyNetAlerts.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

//	@Test
//	void getAhttpStatusOKforAfirestaion() {
//		RestTemplate restTemplate = new RestTemplate();
//		String URL ="http://localhost:8080/firestation";
//		ResponseEntity<String> response
//		  = restTemplate.getForEntity(URL + "/1", String.class);
//		assertEquals(response.getStatusCode(), HttpStatus.OK);
//	}

	@Test
	public void testPostFirestation() throws Exception {
	    String firestation = "{ \"address\":\"newAddress\",\"station\":\"8\"}";
	    
	    mockMvc.perform(
	    		post("/firestation").contentType(MediaType.APPLICATION_JSON).content(firestation).characterEncoding("utf-8"))
				.andExpect(status().isCreated()).andReturn();
	    
	}
	
    @Test
    void getFirestationsInfos() throws Exception {
        mockMvc.perform(get("/firestations-infos")).andExpect(status().isOk());
    }
	

}
