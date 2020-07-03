package dao;

import java.util.List;


import model.Firestation;
import parser.ReadJsonFile;

public class FirestationDAO implements InterfaceDAO<Firestation> {

	private ReadJsonFile read = new ReadJsonFile();
	
	@Override
	public List<Firestation> findAll() {
		return read.readData().getFirestations();	
	}

	@Override
	public void save(Firestation firestation) {
		// TODO Auto-generated method stub
		
	}	
	@Override
	public void delete(Firestation firestation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Firestation firestation, String[] params) {
		// TODO Auto-generated method stub
		
	}


	
}
