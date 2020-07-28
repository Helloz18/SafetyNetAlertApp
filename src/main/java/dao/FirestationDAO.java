package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import controller.FirestationController;
import model.Data;
import model.Firestation;

@Repository
public class FirestationDAO implements InterfaceDAO<Firestation> {

	private static Logger LOGGER = LogManager.getLogger(FirestationDAO.class);
	List<Firestation> firestations = Data.getInstance().getFirestations();
	
	/**
	 * This method return all the addresses with the station-number set to supervise this address.
	 * An address can be supervised by several stations.
	 */
	@Override
	public List<Firestation> findAll() {
		return firestations;	
	}
	/***
	 * This method add a firestation to the list of firestations.
	 * A firestation is composed by an address and a station-number from which the address depends on.
	 */
	@Override
	public Firestation save(Firestation firestation) {
		firestations.add(firestation);	
		return firestation;
	}
	/**
	 * This method removes a firestation from the list of firestations.
	 */
	@Override
	public void delete(Firestation firestation) {
		firestations.remove(firestation);
		
	}
	/**TODO
	 * This method will change a firestation (its address or its station-number)
	 */
	@Override
	public void update(Firestation firestation) {
		for(int i=0; i<firestations.size(); i++) {
			if(firestations.get(i).getAddress().equals(firestation.getAddress())) {
				firestations.set(i,firestation);
			return;	
			}
		}
		
	}
	
	/**
	 * This method will find all the addresses supervised by a station-number.
	 * An address will appear only once even if there is several result in the file.
	 * @param station
	 * @return a list of String address
	 */
	
	public List<String> findById(int station) {
		List<String>addresses = new ArrayList<>();
		for (int i=0; i<firestations.size(); i++) {
			int stationFind = firestations.get(i).getStation();
			if (stationFind == station && !addresses.contains(firestations.get(i).getAddress())) {
				addresses.add(firestations.get(i).getAddress());
			}
		}	if (addresses.size() != 0) {
		return addresses;			
		}else {
			LOGGER.error("The stationNumber "+ station + " doesn't exist.");
			return null;
		}
		
	}
	
}
