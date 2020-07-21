package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.Data;
import model.Firestation;
import model.Person;
import parser.DataReader;

@Repository
public class FirestationDAO implements InterfaceDAO<Firestation> {

	List<Firestation> firestations = Data.getInstance().getFirestations();
	
	@Override
	public List<Firestation> findAll() {
		return firestations;	
	}

	@Override
	public Firestation save(Firestation firestation) {
		firestations.add(firestation);	
		return firestation;
	}
	
	@Override
	public void delete(Firestation firestation) {
		firestations.remove(firestation);
		
	}

	@Override
	public void update(Firestation firestation, String param) {
		
		
	}
	
	
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
