package lu.list.organization.service;

import java.util.List;

import lu.list.organization.model.OObject;

public interface ObjectService {
	
	void addObject(OObject object);
	
	List<OObject> getAllObjects();
}
