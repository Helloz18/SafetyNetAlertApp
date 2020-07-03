package parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import dao.FirestationDAO;

class WriteJsonFileTest {

FirestationDAO firestationDAO = new FirestationDAO();
	
	@Test
	void AddValuesInAjsonFileThatExists() throws IOException {
		//Object that allows to read and write in Json
		ObjectMapper mapper = new ObjectMapper();
		
		//file that contains elements for the test (several nodes)
		File file = new File("dataTest.json");
		
		//A node is a element with parents and children (same as DOM)
		//readTree permits to know the structure, in this case, principal nodes
		//are "persons" "firestations" and "medicalrecords"
		JsonNode root = mapper.readTree(file);
		
		//these lines set values for a new firestation as node which will be created thanks to the mapper
		ObjectNode firestation = mapper.createObjectNode();
			firestation.put("address", "nouvelle adresse");
			firestation.put("station", "5");
			
		//now we get the firestations node (which will contain the new firestation)	
		JsonNode firestationsNode = root.path("firestations");
		
		//we add the node created in the global node (which is an array)
	    ((ArrayNode) firestationsNode).add(firestation);
	    
		//this line will write the new json file with the new values		
		mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);
			
		//the dao is not checking the test file, but the original file (data.json)
			int nombreDeStations = firestationDAO.findAll().size() + 1;
			
			assertEquals(14, nombreDeStations);
			}

}
