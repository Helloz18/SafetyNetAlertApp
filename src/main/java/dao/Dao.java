package dao;

import java.util.List;

public interface Dao <Model> {

	    List<Model> findAll();

	    void save(Model model);

	    void update(Model model, String[]params);

	    void delete(Model model);
	
}
