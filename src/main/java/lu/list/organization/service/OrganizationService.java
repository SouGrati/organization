package lu.list.organization.service;

import java.util.List;

import lu.list.organization.model.Organization;

public interface OrganizationService {
	
	void addOrganization(Organization organization);
	
	List<Organization> getAllOrganization();
	
	Organization getOrganizationById(int id);
	
	void updateOrganization(Organization organization);

}
