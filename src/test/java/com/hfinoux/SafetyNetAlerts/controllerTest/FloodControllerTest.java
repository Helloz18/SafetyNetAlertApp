package com.hfinoux.SafetyNetAlerts.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.hfinoux.SafetyNetAlerts.controller.FloodController;

@WebMvcTest(FloodController.class)
@AutoConfigureMockMvc
class FloodControllerTest {

	@Autowired
	private MockMvc mockMvc;
		
	@Test
	void getTheListOfPeopleReturnsOk() throws Exception {
		int stationNumber = 1;
        mockMvc.perform(get("/flood/stations?stations="+stationNumber)).andExpect(status().isOk()).andReturn();
	}

}
