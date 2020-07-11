package parser;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DataWriter  {

	private DataReader read = new DataReader();
	private File file = new File("dataTest.json");
//	
//	private ObjectMapper mapper = new ObjectMapper();
//	
//		@Override
//		public void writeData() {
//			JsonNode root = read.getRootNode();
//			
//			try {
//				mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);
//			} catch (JsonGenerationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}

}
