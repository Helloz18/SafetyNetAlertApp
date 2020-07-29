package dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import model.Data;
import model.Medicalrecord;

@Service
public class MedicalrecordDAO implements InterfaceDAO<Medicalrecord> {
	
	private static Logger LOGGER = LogManager.getLogger(MedicalrecordDAO.class);
		
	List<Medicalrecord> medicalrecords = Data.getInstance().getMedicalrecords();

	/**
	 * returns a list of all medicalrecords.
	 */
	@Override
	public List<Medicalrecord> findAll() {
		return medicalrecords;
	}

	/**
	 * add a medicalrecord to the list.
	 */
	@Override
	public Medicalrecord save(Medicalrecord medicalrecord) {
		medicalrecords.add(medicalrecord);	
		LOGGER.info("add a medicalRecord");
		return medicalrecord;
	}
		
	/**
	 * modify a medicalrecord.
	 */
	@Override
	public void update(Medicalrecord medicalrecord) {
		for (int i=0; i<medicalrecords.size(); i++) {
			if(medicalrecords.get(i).getFirstName().equals(medicalrecord.getFirstName())
					&& (medicalrecords.get(i).getLastName().equals(medicalrecord.getLastName()))) {
				medicalrecords.set(i, medicalrecord);
				LOGGER.info("medicalRecord has been modified.");
				return;
			}
		}
	}
	
	/**
	 * remove a medicalrecord from the list.
	 */
	@Override
	public void delete(Medicalrecord medicalrecord) {
		LOGGER.info("MedicalRecord has been removed.");
		medicalrecords.remove(medicalrecord);
		
	}

}
