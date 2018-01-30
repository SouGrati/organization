package lu.list.organization.dao;

import lu.list.organization.model.Subject;

public interface SubjectDao {
	
	Subject login(Subject subject);

	void addSubject(Subject subject);

}
