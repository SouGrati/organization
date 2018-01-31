package lu.list.organization.dao;

import java.util.List;

import lu.list.organization.model.OObject;

public interface ObjectDao {
	
	void addObject(OObject object);

	List<OObject> getAllObjects();

	OObject getObjectById(int idObject);

}
