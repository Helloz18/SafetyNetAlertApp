package parser;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Data;

public class ReadJsonFileTest {

	@Test
	void getFirstNameFromFile() throws JsonParseException, JsonMappingException, IOException {
		
		InputStream is = new FileInputStream("dataTest.json");
		ObjectMapper mapper = new ObjectMapper();
		Data data = mapper.readValue(is, Data.class);
			
		assertEquals("John", data.getPersons().get(0).getFirstName());
	}
	
//	@Test
//	void getFirestationFromFile() throws JsonParseException, JsonMappingException, IOException {
//		
//		InputStream is = new FileInputStream("dataTest.json");
//		ObjectMapper mapper = new ObjectMapper();
//		Data data = mapper.readValue(is, Data.class);
//			
//		assertEquals("3", data.getFirestations().get(0).getStation());
//	}
 
}
