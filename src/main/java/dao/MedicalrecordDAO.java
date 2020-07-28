package dao;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Data;
import model.Medicalrecord;

@Service
public class MedicalrecordDAO implements InterfaceDAO<Medicalrecord> {
	
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
				return;
			}
		}
	}
	
	/**
	 * remove a medicalrecord from the list.
	 */
	@Override
	public void delete(Medicalrecord medicalrecord) {
		medicalrecords.remove(medicalrecord);
		
	}

}
