package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import api.constants.RequestMappings;

@Controller
@RequestMapping(RequestMappings.LOGIN)
public class LoginController {

	@RequestMapping(method = { RequestMethod.GET })
	public ModelAndView get() {
		return new ModelAndView("login");
	}
}