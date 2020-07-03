package parser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.DataParser;

/**
 * 
 * This class will read a Json file.
 */
public class ReadJsonFile implements IDataReader {

	
	private ObjectMapper mapper = new ObjectMapper();
/**
 * This method is used to read a JSON file with the ObjectMapper class 
 * from jackson dependency. This dependency comes with springBoot-starter-web.
 * @return a DataParser object 
 */
	@Override
	public DataParser readData() {
		DataParser data = null;
		InputStream is;
		try {
			is = new FileInputStream("data.json");
			data = mapper.readValue(is, DataParser.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
