package dao;

import java.util.List;

import model.Data;
import model.Medicalrecord;

public class MedicalrecordDAO implements InterfaceDAO<Medicalrecord> {
	
	List<Medicalrecord> medicalrecords = Data.getInstance().getMedicalrecords();

	@Override
	public List<Medicalrecord> findAll() {
		return medicalrecords;
	}

	@Override
	public Medicalrecord save(Medicalrecord medicalrecord) {
		medicalrecords.add(medicalrecord);	
		return medicalrecord;
	}
		

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

	@Override
	public void delete(Medicalrecord medicalrecord) {
		medicalrecords.remove(medicalrecord);
		
	}

}
