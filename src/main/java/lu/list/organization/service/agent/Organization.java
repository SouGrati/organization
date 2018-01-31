package lu.list.organization.service.agent;

public class Organization {
	private int organizationId;
	private String organizationName;
	
	public  Organization(int organizationId) {
		this.organizationId = organizationId;
		
	}
	
	public int getOrganizationId() {
        return this.organizationId;
    }
 
    public void setOrganizationId(int num) {
        this.organizationId = num;
    }


	public String getOrganizationName() {
    return this.organizationName;
	}

	public void setOrganizationName(String name) {
    this.organizationName = name;
	}

	public Organization() {
	}
	
}
