package parser;

import com.fasterxml.jackson.databind.JsonNode;

import model.Data;


public interface IDataReader {
/**
 * 
 * DataParser is a simple Java Object with getters and setters.
 */
	Data readData();	
	
	//JsonNode getRootNode();
	
}
