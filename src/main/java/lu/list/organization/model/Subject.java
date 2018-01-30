package lu.list.organization.model;

public class Subject {
	//private static final long serialVersionUID = 1L;
	public static String SUBJECTID = "subject_id";
	public static String SUBJECTNAME = "subject_name";
	public static String SUBJECTORGANIZATIONID = "organization_id";
	
	int subject_id;
	String subject_name;
	int organization_id;
	private boolean isAdmin;
	private String subject_password;
	
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public int getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}
	public Subject(int subject_id, String subject_name, int organization_id) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.organization_id = organization_id;
	}
	public Subject(int subject_id) {
		super();
		this.subject_id = subject_id;
	}
	
	public Subject() {
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getSubject_password() {
		return subject_password;
	}
	public void setSubject_password(String subject_password) {
		this.subject_password = subject_password;
	}
	
}
