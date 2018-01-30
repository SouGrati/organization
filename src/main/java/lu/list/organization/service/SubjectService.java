package lu.list.organization.service;

import lu.list.organization.model.Subject;

public interface SubjectService {
	
	Subject login(Subject subject);

	void addSubject(Subject subject);
}
