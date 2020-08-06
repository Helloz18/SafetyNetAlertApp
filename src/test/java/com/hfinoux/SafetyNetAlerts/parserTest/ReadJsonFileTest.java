package com.hfinoux.SafetyNetAlerts.parserTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hfinoux.SafetyNetAlerts.model.Data;

public class ReadJsonFileTest {
	
	File file = new File("dataTest.json");

	@Test
	void getFirstNameFromFile() throws JsonParseException, JsonMappingException, IOException {
		//GIVEN
		InputStream is = new FileInputStream(file);
		ObjectMapper mapper = new ObjectMapper();
		//WHEN
		Data data = mapper.readValue(is, Data.class);
		//THEN
		assertEquals("John", data.getPersons().get(0).getFirstName());
	}
	
	@Test
	void getFirestationFromFile() throws JsonParseException, JsonMappingException, IOException {
		//GIVEN
		InputStream is = new FileInputStream(file);
		ObjectMapper mapper = new ObjectMapper();
		//WHEN
		Data data = mapper.readValue(is, Data.class);
		//THEN
		assertEquals(3, data.getFirestations().get(0).getStation());
	}
 
}
