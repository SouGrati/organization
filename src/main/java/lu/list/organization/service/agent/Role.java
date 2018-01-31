package lu.list.organization.service.agent;

public class Role {
	private int roleId;
	private String roleName;
	int organization_id;
	
	public Role(int roleId, int organization_id) {
		super();
		this.roleId = roleId;
		this.organization_id = organization_id;
	}
	public int getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public Role(int roleId) {
		super();
		this.roleId = roleId;
	}
}
