package lu.list.organization.service.agent;

public class View {
	private int viewId;
	private String viewName;

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public View(int viewId, String viewName) {
		super();
		this.viewId = viewId;
		this.viewName = viewName;
	}

	public View(int viewId) {
		super();
		this.viewId = viewId;
	}

}
