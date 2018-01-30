package lu.list.organization.model;

public class Organization {
	
	private int idOrganization;
	private String nameOrganization;
	private Coalition coalition;
	
	public int getIdOrganization() {
		return idOrganization;
	}
	public void setIdOrganization(int idOrganization) {
		this.idOrganization = idOrganization;
	}
	public String getNameOrganization() {
		return nameOrganization;
	}
	public void setNameOrganization(String nameOrganization) {
		this.nameOrganization = nameOrganization;
	}
	public Coalition getCoalition() {
		return coalition;
	}
	public void setCoalition(Coalition coalition) {
		this.coalition = coalition;
	}
	
}
