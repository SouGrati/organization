package lu.list.organization.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lu.list.organization.model.Organization;
import lu.list.organization.service.OrganizationService;

@Controller
public class BaseController {
	
		private static final String VIEW_INDEX = "index";
		private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
		
		@Autowired
		private OrganizationService organizationService;

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String index(ModelMap model) {
			
			model.addAttribute("organization",new Organization());

			return VIEW_INDEX;

		}
		
		@RequestMapping(value = "/addOrganization", method = RequestMethod.POST)
		public String addOrganization(ModelMap model, @ModelAttribute("organization") Organization organization) {
			
			organizationService.addOrganization(organization);

			LOGGER.debug("Insret organization into DB : " + organization.getNameOrganization());

			return VIEW_INDEX;

		}
		
		@RequestMapping(value = "/allOrganizations", method = RequestMethod.GET)
		public String getAllOrganizations(ModelMap model) {
			

			return VIEW_INDEX;

		}

}
