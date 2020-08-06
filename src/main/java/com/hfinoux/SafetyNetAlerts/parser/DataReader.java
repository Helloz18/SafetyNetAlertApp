package com.hfinoux.SafetyNetAlerts.parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hfinoux.SafetyNetAlerts.model.Data;

/**
 * 
 * This class will read a Json file.
 */
public class DataReader implements IDataReader {

	private File file = new File("data.json");
	private ObjectMapper mapper = new ObjectMapper();
/**
 * This method is used to read a JSON file with the ObjectMapper class 
 * from jackson dependency. This dependency comes with springBoot-starter-web.
 * @return a DataParser object 
 */

	@Override
	public Data readData() {
		Data data = null;
		InputStream is;
		try {
			is = new FileInputStream(file);
			data = mapper.readValue(is, Data.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
}
