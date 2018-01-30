package lu.list.organization.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lu.list.organization.model.Coalition;
import lu.list.organization.model.OObject;
import lu.list.organization.model.Organization;
import lu.list.organization.model.Subject;
import lu.list.organization.service.ObjectService;
import lu.list.organization.service.OrganizationService;
import lu.list.organization.service.SubjectService;

@Controller
public class BaseController {
	
		private static final String VIEW_INDEX = "index";
		private static final String VIEW_LOGIN = "login";
		private static final String VIEW_SERVICE = "service";
		private static final String VIEW_LIST_ORGANIZATIONS = "listOrganizations";
		private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
		
		@Autowired
		private OrganizationService organizationService;
		@Autowired
		private SubjectService subjectService;
		@Autowired
		private ObjectService objectService;

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String index(ModelMap model, HttpServletRequest request) {
			
			String page;
			
			HttpSession session =request.getSession();
			
			Subject user = (Subject) session.getAttribute("user");
			
			if (user != null) {
				Organization organization = new Organization();
				organization.setCoalition(new Coalition());
				model.addAttribute("organization",organization);
				page = VIEW_INDEX;
			} else {
				page = "redirect:/login";
			}

			return page;

		}
		
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String afficherLogin(ModelMap model, @ModelAttribute("msgLoginFailed") String msgLoginFailed) {
			
			model.addAttribute("user",new Subject());
			model.addAttribute("msgLoginFailed", msgLoginFailed);

			return VIEW_LOGIN;

		}
		
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String login(Model model, @ModelAttribute("user") Subject subject, HttpServletRequest request,
				RedirectAttributes redirectAttrs) {
			
			HttpSession session =request.getSession();
			
			Subject userConneceted = subjectService.login(subject);
			
			String page;
			
			if (userConneceted != null) {
				session.setAttribute("user", userConneceted);
				page = "redirect:/";
			} else {
				redirectAttrs.addFlashAttribute("msgLoginFailed", "Username or password incorrect !");
				page = "redirect:/login";
			}
			
			return page;
		}
		
		@RequestMapping(value = "/logOut", method = RequestMethod.GET)
		public String logOut(HttpServletRequest request) {
			
			HttpSession session =request.getSession();
			session.removeAttribute("user");
			
			return "redirect:/login";
		}
		
		@RequestMapping(value = "/addOrganization", method = RequestMethod.POST)
		public String addOrganization(ModelMap model, @ModelAttribute("organization") Organization organization, 
				RedirectAttributes redirectAttrs) {
			
			organizationService.addOrganization(organization);
			
			model.addAttribute("msgOrgAdded", "Organization has been added.");

			LOGGER.debug("Insret organization into DB : " + organization.getNameOrganization());

			return VIEW_INDEX;

		}
		
		@RequestMapping(value = "/allOrganizations", method = RequestMethod.GET)
		public String getAllOrganizations(ModelMap model, HttpServletRequest request) {
			
			HttpSession session =request.getSession();
			
			Subject user = (Subject) session.getAttribute("user");
			
			if (user != null) {
				model.addAttribute("listOrganizations",organizationService.getAllOrganization());
				model.addAttribute("user",new Subject());
				return VIEW_LIST_ORGANIZATIONS;
			} else {
				return "redirect:/login";
			}

		}
		
		@RequestMapping(value = "/addUser", method = RequestMethod.POST)
		public String addUser(ModelMap model, @ModelAttribute("user") Subject subject, 
				@RequestParam("idOrg") int idOrganization, RedirectAttributes redirectAttrs) {
			
			subject.setOrganization_id(idOrganization);
			subjectService.addSubject(subject);
			
			redirectAttrs.addFlashAttribute("msgUserAdded", "User has been added.");
			
			LOGGER.debug("Insret user into DB : " + subject.getSubject_name());

			return "redirect:/allOrganizations";

		}
		
		@RequestMapping(value = "/addService", method = RequestMethod.POST)
		public String addObject(ModelMap model, @ModelAttribute("object") OObject object, 
				RedirectAttributes redirectAttrs, HttpServletRequest request) {
			
			HttpSession session =request.getSession();
			Subject user = (Subject) session.getAttribute("user");
			object.setOrganization_id(user.getOrganization_id());
			objectService.addObject(object);
			
			model.addAttribute("msgServiceAdded", "Service has been added.");

			LOGGER.debug("Insret object into DB : " + object.getObject_name());

			return VIEW_SERVICE;

		}
		
		@RequestMapping(value = "/addService", method = RequestMethod.GET)
		public String afficherAddObject(ModelMap model, HttpServletRequest request) {
			
			HttpSession session =request.getSession();
			Subject user = (Subject) session.getAttribute("user");
			
			if (user != null) {
				model.addAttribute("object", new OObject());
			} else {
				return "redirect:/login";
			}
			
			return VIEW_SERVICE;
		}

}
