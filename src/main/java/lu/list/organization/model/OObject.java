package lu.list.organization.model;

public class OObject {
	private int object_id;
	private String object_path;
	private String object_name;
	private int  organization_id;
	public static String OBJECTID = "object_id";
	public static String OBJECTNAME = "object_name";
	public static String OBJECTORGANIZATIONID = "organization_id";
	public static String OBJECTPATH = "object_path";
	public int getObject_id() {
		return object_id;
	}
	public void setObject_id(int object_id) {
		this.object_id = object_id;
	}
	public String getObject_path() {
		return object_path;
	}
	public void setObject_path(String object_path) {
		this.object_path = object_path;
	}
	public String getObject_name() {
		return object_name;
	}
	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}
	public int getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}
	public OObject(int object_id, String object_path, String object_name, int organization_id) {
		super();
		this.object_id = object_id;
		this.object_path = object_path;
		this.object_name = object_name;
		this.organization_id = organization_id;
	}
	public OObject(int object_id, String object_name) {
		super();
		this.object_id = object_id;
		this.object_name = object_name;
	}
	public OObject(int object_id) {
		super();
		this.object_id = object_id;
	}
	public OObject() {
	}
	
}
