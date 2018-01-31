package lu.list.organization.service.agent;

public class Action {

	private int actionId;
	private String actionName;

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public Action(int actionId, String actionName) {
		super();
		this.actionId = actionId;
		this.actionName = actionName;
	}

	public Action(int actionId) {
		super();
		this.actionId = actionId;
	}

}
