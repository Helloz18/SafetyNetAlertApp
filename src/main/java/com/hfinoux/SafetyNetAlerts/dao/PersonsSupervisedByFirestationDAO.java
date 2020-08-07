package com.hfinoux.SafetyNetAlerts.dao;

import org.springframework.stereotype.Service;

import com.hfinoux.SafetyNetAlerts.model.PersonsSupervisedByFirestation;

@Service
public interface PersonsSupervisedByFirestationDAO {

	/**
	 * This method will return a list of people supervised by a station and the number of adults and children.
	 * @param stationNumber
	 * @return a PersonsSupervisedByFirestation
	 */
	PersonsSupervisedByFirestation findByStationNumber(int stationNumber);

}