package lu.list.organization.service.agent;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import lu.list.organization.model.OObject;
import lu.list.organization.model.Subject;

public class InformationAgent {

	/**
	 * This method reads the XML which contains the EmpowerRules and returns all
	 * the roles that can be played by the subject
	 * 
	 * @param s
	 *            - subject of the request
	 * @param orga
	 *            - Organization
	 * @return Role - role played by the subject in the organization
	 */
	public Role getRole(Subject s, Organization org) {

		Role role = null;
		try {
			FileInputStream file = new FileInputStream(new File("C:/Users/benabdelkrim/COrBAC/xml/Empower.xml"));

			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = builderFactory.newDocumentBuilder();

			Document xmlDocument = builder.parse(file);

			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "//subject[id=" + s.getSubject_id() + "]/parent::subjects[@organizationId="
					+ org.getOrganizationId() + "]/parent::role/id";
			// System.out.println(expression);
			String result = xPath.compile(expression).evaluate(xmlDocument);
			// System.out.println(result);
			role = new Role(Integer.parseInt(result));
			System.out.println(role.getRoleId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	/**
	 * This method reads the XML which contains the UseRules and returns the
	 * view associated to the Object
	 * 
	 * @param o
	 *            - object of the request
	 * @param orga
	 *            - Organization
	 * @return View - View containing the object
	 */

	public View getView(OObject o, Organization org) {
		View view = null;
		try {
			FileInputStream file = new FileInputStream(new File("C:/Users/benabdelkrim/COrBAC/xml/Use.xml"));

			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = builderFactory.newDocumentBuilder();

			Document xmlDocument = builder.parse(file);

			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "//object[id=" + o.getObject_id() + "]/parent::objects[@organizationId="
					+ org.getOrganizationId() + "]/parent::view/id";
			// System.out.println(expression);
			String result = xPath.compile(expression).evaluate(xmlDocument);

			view = new View(Integer.parseInt(result));
			System.out.println(view.getViewId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;

	}

	/**
	 * This method reads the XML which contains the ConsiderRules and returns
	 * the activity associated to the action
	 * 
	 * @param a
	 *            - action of the request
	 * @param orga
	 *            - Organization
	 * @return Activity - Activity containing the action
	 */

	public Activity getActivity(Action a, Organization org) {
		Activity activity = null;
		try {
			FileInputStream file = new FileInputStream(new File("C:/Users/benabdelkrim/COrBAC/xml/Consider.xml"));

			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = builderFactory.newDocumentBuilder();

			Document xmlDocument = builder.parse(file);

			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "//action[id=" + a.getActionId() + "]/parent::actions[@organizationId="
					+ org.getOrganizationId() + "]/parent::activity/id";
			// System.out.println(expression);
			String result = xPath.compile(expression).evaluate(xmlDocument);

			activity = new Activity(Integer.parseInt(result));
			System.out.println(activity.getActivityId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activity;
	}
}
