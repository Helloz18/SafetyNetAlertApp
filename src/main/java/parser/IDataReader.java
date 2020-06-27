package parser;
import java.util.List;

import model.Firestations;
import model.Medicalrecords;
import model.Persons;


public interface IDataReader {

	List<Persons> readPersons();
	
	List<Firestations> readFirestations();
	
	List<Medicalrecords> readMedicalrecords();
}
