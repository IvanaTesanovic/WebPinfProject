package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.constants.MimeTypes;
import api.constants.RequestMappings;

@RestController
@RequestMapping(RequestMappings.LOGIN_API)
public class LoginAPIController {
	
	@RequestMapping(method = RequestMethod.GET, produces = MimeTypes.APPLICATION_JSON)
	public String getString() {
		return "login";
	}

}
