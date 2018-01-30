package lu.list.organization.service;

import org.springframework.beans.factory.annotation.Autowired;

import lu.list.organization.dao.SubjectDao;
import lu.list.organization.model.Subject;

public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;

	@Override
	public Subject login(Subject subject) {
		return subjectDao.login(subject);
	}

	@Override
	public void addSubject(Subject subject) {
		subjectDao.addSubject(subject);
	}
	
}
