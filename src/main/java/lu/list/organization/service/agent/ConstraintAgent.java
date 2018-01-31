package lu.list.organization.service.agent;

import java.util.ArrayList;

import lu.list.organization.model.OObject;
import lu.list.organization.model.Subject;

public class ConstraintAgent {

	private InformationAgent IA;
	private PolicyAgent PA;
	private static ConstraintAgent instance = null;

	private ConstraintAgent() {
		this.setIA(new InformationAgent());
		this.setPA(new PolicyAgent());
	}

	public InformationAgent getIA() {
		return IA;
	}

	public void setIA(InformationAgent iA) {
		IA = iA;
	}

	public PolicyAgent getPA() {
		return PA;
	}

	public void setPA(PolicyAgent pA) {
		PA = pA;
	}

	public static ConstraintAgent getInstance() {
		if (ConstraintAgent.instance == null) {
			synchronized (ConstraintAgent.class) {
				if (ConstraintAgent.instance == null) {
					instance = new ConstraintAgent();
				}
			}
		}
		return ConstraintAgent.instance;
	}

	/**
	 * Access returns the rule that matches the request
	 * 
	 * @param s
	 *            Subject
	 * @param o
	 *            Object
	 * @param a
	 *            Action
	 * @param c
	 *            Context
	 * @return boolean response
	 */
	public Rule access(Subject s, OObject o, Action a, Context c, Organization orga) {
		Rule rule = new Rule(0, s, o, a, orga);
		Role role_subject = IA.getRole(s, orga);
		View view = IA.getView(o, orga);
		Activity activity = IA.getActivity(a, orga);
		if (role_subject != null && view != null && activity != null) {

			// First check if there's a prohibition
			ArrayList<Role> roles_prohibition = PA.getProhibitions(view, activity, c, orga);
			System.out.println("roles prohibition value is" + roles_prohibition);
			loop: for (Role roletoplay : roles_prohibition) {
				if (role_subject.getRoleId() == roletoplay.getRoleId()) {
					rule.setRule(1);
					System.out.println(rule.getRule());
					break loop;
				}
			}
			// Then check if there's an obligation

			ArrayList<Role> roles_obligation = PA.getObligations(view, activity, c, orga);
			System.out.println("roles obligation value is" + roles_obligation);
			loop: for (Role roletoplay : roles_obligation) {
				if (role_subject.getRoleId() == roletoplay.getRoleId()) {
					rule.setRule(2);
					break loop;
				}
			}

			// Then check if there's a recommendation
			ArrayList<Role> roles_recommendation = PA.getRecommendations(view, activity, c, orga);
			System.out.println("roles recommendation value is" + roles_recommendation);
			loop: for (Role roletoplay : roles_recommendation) {
				if (role_subject.getRoleId() == roletoplay.getRoleId()) {
					rule.setRule(3);
					break loop;
				}
			}

			// At last check if there's a permission
			ArrayList<Role> roles_permission = PA.getPermissions(view, activity, c, orga);
			System.out.println("roles permission value is" + roles_permission);
			loop: for (Role roletoplay : roles_permission) {
				if (role_subject.getRoleId() == roletoplay.getRoleId()) {
					rule.setRule(4);
					break loop;
				}
			}

		}
		return rule;
	}

}
