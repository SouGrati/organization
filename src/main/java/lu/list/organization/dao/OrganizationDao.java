package lu.list.organization.dao;

import java.util.List;

import lu.list.organization.model.Organization;

public interface OrganizationDao {
	
	void addOrganization(Organization organization);
	
	List<Organization> getAllOrganization();
	
	Organization getOrganizationById(int id);
	
	void updateOrganization(Organization organization);

}
