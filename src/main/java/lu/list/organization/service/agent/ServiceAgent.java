package lu.list.organization.service.agent;
import java.util.Calendar;

import lu.list.organization.model.OObject;
import lu.list.organization.model.Subject;
public class ServiceAgent {
	private ConstraintAgent CA = ConstraintAgent.getInstance();
	private Organization organization;
	public ServiceAgent(Organization organization){
		this.organization = organization;
	}
	/** This method evaluates a time context. 
	 * @return Context(1) during the day, Context(2) during the night and Context(3) during the week-end
	 */
	
	public static Context getTimeContext() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (day>5) { //Week-end
			return new Context(3);
		} else if ((hour < 7) || (hour > 20)) { //Night
			//FIXME 
			return new Context(1);
		} else { //Day
			return new Context(1);
		}
	}
	
	/** This method forward the request to the ConstraintAgent 
	 * and send back the result of the request
	 * @param s - subject of the request 
	 * @param o - object of the request
	 * @param a - action of the request
	 * @return String describing a rule
	 */
	public Rule access(int id_subject, int id_object, int id_action) throws Exception {
		Subject s = new Subject(id_subject);
		OObject o = new OObject(id_object);
		Action a = new Action(id_action);
		
		Context c = getTimeContext();
	
		
		return CA.access(s, o, a, c,organization);
	}
}
