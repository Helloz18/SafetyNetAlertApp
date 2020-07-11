package dao;

import java.util.List;

public interface InterfaceDAO <Model> {

	    List<Model> findAll();
	    
	    Model save(Model model);

	    void update(Model model, String param);

	    void delete(Model model);

		List<String> findById(int param);
}
