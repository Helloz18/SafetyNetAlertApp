package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.Data;
import model.Firestation;

@Repository
public class FirestationDAO implements InterfaceDAO<Firestation> {

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
	/**
	 * This method will change a firestation (its address of its station-number)
	 */
	@Override
	public void update(Firestation firestation, String param) {
		
		
	}
	
	/**
	 * This method will find all the addresses supervised by a station-number.
	 * @param station
	 * @return a list of String address
	 */
	
	public List<String> findById(int station) {
		List<String>addresses = new ArrayList<>();
		for (int i=0; i<firestations.size(); i++) {
			int stationFind = firestations.get(i).getStation();
			if (stationFind ==station) {
				addresses.add(firestations.get(i).getAddress());
			}
		}	if (addresses.size() != 0) {
		return addresses;			
		}else {
			return null;
		}
		
	}
	
}
