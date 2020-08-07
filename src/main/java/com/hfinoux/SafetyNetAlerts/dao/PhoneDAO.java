package com.hfinoux.SafetyNetAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PhoneDAO {

	/**
	 * This method will list the phoneNumbers of people supervised by a station.
	 * @param stationNumber
	 * @return a list of String phoneNumber.
	 */
	List<String> getPhoneForAstationNumber(int stationNumber);

}