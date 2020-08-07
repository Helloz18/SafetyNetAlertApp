package com.hfinoux.SafetyNetAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hfinoux.SafetyNetAlerts.model.Medicalrecord;

@Service
public interface MedicalrecordDAO extends InterfaceDAO<Medicalrecord>{

	/**
	 * returns a list of all medicalrecords.
	 */
	List<Medicalrecord> findAll();

	/**
	 * add a medicalrecord to the list.
	 */
	Medicalrecord save(Medicalrecord medicalrecord);

	/**
	 * modify a medicalrecord.
	 */
	void update(Medicalrecord medicalrecord);

	/**
	 * remove a medicalrecord from the list.
	 */
	void delete(Medicalrecord medicalrecord);

}