package lu.list.organization.service;

import org.springframework.beans.factory.annotation.Autowired;

import lu.list.organization.dao.ObjectDao;
import lu.list.organization.model.OObject;

public class ObjectServiceImpl implements ObjectService {
	
	@Autowired
	private ObjectDao objectDao;

	@Override
	public void addObject(OObject object) {
		objectDao.addObject(object);
	}
	
}
