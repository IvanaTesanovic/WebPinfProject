package controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.constants.MimeTypes;
import api.constants.RequestMappings;
import model.Drzava;
import service.DrzavaService;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.DRZAVE)
public class DrzaveAPIController {
	
	@Autowired
	DrzavaService service;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni(@RequestBody Drzava obj) {
		service.update(obj.getId(), obj.getNaziv());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE, produces = MimeTypes.APPLICATION_JSON)
	public Drzava dodaj(@RequestBody Drzava obj) {
		Drzava drzava = new Drzava(obj.getNaziv());
		service.save(drzava);
		return drzava;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}

}
