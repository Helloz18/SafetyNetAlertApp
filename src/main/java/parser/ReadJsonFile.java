package parser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.DataParser;
import model.Firestations;
import model.Medicalrecords;
import model.Persons;

public class ReadJsonFile implements IDataReader {

	private InputStream is;
	private ObjectMapper mapper = new ObjectMapper();
	private DataParser data;
	private List<Persons> listPersons;
	private List<Firestations> listFirestations;
	private List<Medicalrecords> listMedicalrecords;
	
	
	@Override
	public List<Persons> readPersons() {
		try {
			is = new FileInputStream("data.json");
			data = mapper.readValue(is, DataParser.class);
			listPersons = data.getPersons();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listPersons;
	}

	@Override
	public List<Firestations> readFirestations() {
		try {
			is = new FileInputStream("data.json");
			data = mapper.readValue(is, DataParser.class);
			listFirestations = data.getFirestations();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listFirestations;
}

	@Override
	public List<Medicalrecords> readMedicalrecords() {
		try {
			is = new FileInputStream("data.json");
			data = mapper.readValue(is, DataParser.class);
			listMedicalrecords = data.getMedicalrecords();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listMedicalrecords;

	}
	
}
