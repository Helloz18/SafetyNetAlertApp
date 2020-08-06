package com.hfinoux.SafetyNetAlerts.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.hfinoux.SafetyNetAlerts.controller.AlertController;


@WebMvcTest(AlertController.class)
@AutoConfigureMockMvc
class AlertControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
    @Test
    void getAresponseOkForChildrenFoundInAnAddress() throws Exception {
    	//GIVEN
    	String address = "1509 Culver St";
    	//WHEN, THEN
        mockMvc.perform(get("/childAlert?address=" + address)).andExpect(status().isOk()).andReturn();
        }
    
    @Test
    void getAnEmptyArrayForAddressUnknown() throws Exception {
    	//GIVEN
    	String address = "unknown";
    	//WHEN
        MvcResult response = mockMvc.perform(get("/childAlert?address=" + address)).andExpect(status().isOk()).andReturn();
        //THEN
        assertEquals(response.getResponse().getContentAsString(), "[]");
    }
    
    @Test
    void getAnEmptyArrayForAddressEmpty() throws Exception {
    	//GIVEN
    	String address = "";
    	//WHEN
        MvcResult response = mockMvc.perform(get("/childAlert?address=" + address)).andExpect(status().isOk()).andReturn();
        //THEN
        assertEquals(response.getResponse().getContentAsString(), "[]");
    }
	
    @Test
    void getListOfPhoneNumberForAstationNumber() throws Exception {
    	//GIVEN
    	int stationNumber = 1;
    	//WHEN
        MvcResult response = mockMvc.perform(get("/phoneAlert?firestation="+stationNumber)).andExpect(status().isOk()).andReturn();
        //THEN
        assertEquals(response.getResponse().getContentAsString(), "[\"841-874-6512\",\"841-874-8547\",\"841-874-7462\",\"841-874-7784\"]");
    }
    
    @Test
    void getEmptyListForAstationNumberNotFound() throws Exception {
    	//GIVEN
    	int stationNumber = 10;
    	//WHEN
        MvcResult response = mockMvc.perform(get("/phoneAlert?firestation="+stationNumber)).andExpect(status().isOk()).andReturn();
        //THEN
        assertEquals(response.getResponse().getContentAsString(), "");
    }
	  	
}
