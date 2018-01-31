package lu.list.organization.service.agent;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class PolicyAgent {
	// This method is used to get the prohibitions rules

	public ArrayList<Role> getProhibitions(View view, Activity activity, Context c, Organization org) {

		ArrayList<Role> roles_prohibition = new ArrayList<Role>();
		String file = "C:/Users/benabdelkrim/COrBAC/xml/Rule.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!

		try {

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			XPath xpath = XPathFactory.newInstance().newXPath();

			XPathExpression expr = xpath.compile(
					"/rules/rule[@effect= 'prohibition' and activity[id =" + activity.getActivityId() + "] and view[id="
							+ view.getViewId() + "] and context[id=" + c.getContextId() + "]]/roles/role/id");

			Object result = expr.evaluate(document, XPathConstants.NODESET);

			NodeList nodes = (NodeList) result;

			for (int i = 0; i < nodes.getLength(); i++) {

				roles_prohibition.add(new Role(Integer.parseInt(nodes.item(i).getFirstChild().getNodeValue())));

			}
			for (int i = 0; i < roles_prohibition.size(); i++)
				System.out.println(roles_prohibition.get(i).getRoleId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles_prohibition;

	}

	// This method is used to get the obligations rules

	public ArrayList<Role> getObligations(View view, Activity activity, Context c, Organization org) {

		ArrayList<Role> roles_obligation = new ArrayList<Role>();
		String file = "C:/Users/benabdelkrim/COrBAC/xml/Rule.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			XPath xpath = XPathFactory.newInstance().newXPath();

			XPathExpression expr = xpath.compile(
					"/rules/rule[@effect= 'obligation' and activity[id =" + activity.getActivityId() + "] and view[id="
							+ view.getViewId() + "] and context[id=" + c.getContextId() + "]]/roles/role/id");
			Object result = expr.evaluate(document, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;

			for (int i = 0; i < nodes.getLength(); i++) {
				roles_obligation.add(new Role(Integer.parseInt(nodes.item(i).getFirstChild().getNodeValue())));
			}
			for (int i = 0; i < roles_obligation.size(); i++)
				System.out.println(roles_obligation.get(i).getRoleId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles_obligation;

	}

	// This method is used to get the recommendations rules

	public ArrayList<Role> getRecommendations(View view, Activity activity, Context c, Organization org) {

		ArrayList<Role> roles_recommendation = new ArrayList<Role>();
		String file = "C:/Users/benabdelkrim/COrBAC/xml/Rule.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			XPath xpath = XPathFactory.newInstance().newXPath();

			XPathExpression expr = xpath.compile("/rules/rule[@effect= 'recommendation' and activity[id ="
					+ activity.getActivityId() + "] and view[id=" + view.getViewId() + "] and context[id="
					+ c.getContextId() + "]]/roles/role/id");
			Object result = expr.evaluate(document, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;

			for (int i = 0; i < nodes.getLength(); i++) {
				roles_recommendation.add(new Role(Integer.parseInt(nodes.item(i).getFirstChild().getNodeValue())));
			}
			for (int i = 0; i < roles_recommendation.size(); i++)
				System.out.println(roles_recommendation.get(i).getRoleId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles_recommendation;

	}

	// This method is used to get the permissions rules

	public ArrayList<Role> getPermissions(View view, Activity activity, Context c, Organization org) {

		ArrayList<Role> roles_permission = new ArrayList<Role>();
		String file = "C:/Users/benabdelkrim/COrBAC/xml/Rule.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); // never forget this!

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xpath.compile(
					"/rules/rule[@effect= 'permission' and activity[id =" + activity.getActivityId() + "] and view[id="
							+ view.getViewId() + "] and context[id=" + c.getContextId() + "]]/roles/role/id");
			Object result = expr.evaluate(document, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;

			for (int i = 0; i < nodes.getLength(); i++) {
				roles_permission.add(new Role(Integer.parseInt(nodes.item(i).getFirstChild().getNodeValue())));
			}
			for (int i = 0; i < roles_permission.size(); i++)
				System.out.println(roles_permission.get(i).getRoleId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles_permission;

	}

}
