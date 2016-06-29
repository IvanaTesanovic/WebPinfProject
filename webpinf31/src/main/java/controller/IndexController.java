package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import api.constants.RequestMappings;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		return new ModelAndView("index");
	}

}
