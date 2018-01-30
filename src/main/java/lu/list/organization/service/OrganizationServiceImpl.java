package lu.list.organization.service;

import java.util.List;

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

	@Override
	public List<Organization> getAllOrganization() {
		return organizationDao.getAllOrganization();
	}

	@Override
	public Organization getOrganizationById(int id) {
		return organizationDao.getOrganizationById(id);
	}

	@Override
	public void updateOrganization(Organization organization) {
		organizationDao.updateOrganization(organization);
	}

}
