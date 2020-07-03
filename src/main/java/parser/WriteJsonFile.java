package parser;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.DataParser;

public class WriteJsonFile implements IDataWriter {

	private ObjectMapper mapper = new ObjectMapper();
	
		@Override
		public DataParser writeData() {
		DataParser data = null;
//			FileWriter file = new FileWriter(null);
//			InputStream is;
//			try {
//				is = new FileInputStream("data.json");
//				data = mapper.readValue(is, DataParser.class);
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		return data;
		}

}
