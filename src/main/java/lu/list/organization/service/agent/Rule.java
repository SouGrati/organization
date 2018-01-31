package lu.list.organization.service.agent;

import lu.list.organization.model.OObject;
import lu.list.organization.model.Subject;

public class Rule {
	private int rule;
	private Subject subject;
	private OObject object;
	private Action action;
	private Organization orga;

	public void setRule(int rule) {

		this.rule = rule;
	}

	public int getRule() {

		return rule;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public OObject getObject() {
		return object;
	}

	public Organization getOrga() {
		return orga;
	}

	public void setOrga(Organization orga) {
		this.orga = orga;
	}

	public void setObject(OObject object) {
		this.object = object;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Rule(int rule, Subject subject, OObject object, Action action, Organization orga) {
		super();

		this.action = action;
		this.object = object;
		this.subject = subject;
		this.orga = orga;
	}

}
