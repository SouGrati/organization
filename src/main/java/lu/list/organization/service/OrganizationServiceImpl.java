package lu.list.organization.service;

import org.springframework.beans.factory.annotation.Autowired;

import lu.list.organization.dao.OrganizationDao;
import lu.list.organization.model.Organization;

public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationDao organizationDao;
	
	@Override
	public void addOrganization(Organization organization) {
		organizationDao.addOrganization(organization);
	}

}
