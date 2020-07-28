package dao;

import java.util.List;

public interface InterfaceDAO <Model> {

	    List<Model> findAll();
	    
	    Model save(Model model);

	    void update(Model model);

	    void delete(Model model);

}
