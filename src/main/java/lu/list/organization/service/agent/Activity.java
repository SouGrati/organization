package lu.list.organization.service.agent;

public class Activity {
	private int activityId;
	private String activityName;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Activity(int activityId, String activityName) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
	}

	public Activity(int activityId) {
		super();
		this.activityId = activityId;
	}

}
