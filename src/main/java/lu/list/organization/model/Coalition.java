package lu.list.organization.model;

public class Coalition {

	public static String COALITIONID="coalition_id";
	private int coalitionId;
	private String coalitionName;
	
	public  Coalition(int coalitionId) {
		this.coalitionId = coalitionId;
		
	}
	
	public Coalition() {
	}

	public int getCoalitionId() {
        return this.coalitionId;
    }
 
    public void setCoalitionId(int num) {
        this.coalitionId = num;
    }


	public String getCoalitionName() {
    return this.coalitionName;
	}

	public void setCoalitionName(String name) {
    this.coalitionName = name;
	}
}
