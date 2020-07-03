package dao;

import java.util.List;

public interface InterfaceDAO <Model> {

	    List<Model> findAll();

	    void save(Model model);

	    void update(Model model, String[]params);

	    void delete(Model model);
	
}
