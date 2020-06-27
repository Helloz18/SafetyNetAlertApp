package parser;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.DataParser;

public class ReadJsonFileTest {

	@Test
	void getDataFromFile() throws JsonParseException, JsonMappingException, IOException {
		
		InputStream is = new FileInputStream("dataTest.json");
		ObjectMapper mapper = new ObjectMapper();
		DataParser data = mapper.readValue(is, DataParser.class);
			
		assertEquals("John", data.getPersons().get(0).getFirstName());
	}
 
}
