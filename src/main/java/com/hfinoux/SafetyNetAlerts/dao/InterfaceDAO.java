package com.hfinoux.SafetyNetAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * interface for the CRUD methods.
 *
 * @param <Model>
 */
public interface InterfaceDAO <Model> {

	    List<Model> findAll();
	    
	    Model save(Model model);

	    void update(Model model);

	    void delete(Model model);

}
