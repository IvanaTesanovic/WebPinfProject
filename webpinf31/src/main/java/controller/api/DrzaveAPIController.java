package controller.api;

import java.util.ArrayList;
import java.util.List;

import model.Drzava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.DrzavaService;
import api.constants.MimeTypes;
import api.constants.RequestMappings;

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
	public List<Drzava> pretrazi(@RequestBody Drzava obj) {
		
		List<Drzava> sveDrzave = service.listAll();
		List<Drzava> result = new ArrayList<Drzava>();
		
		if(obj.getId()!= null || obj.getNaziv()!=null){
			for(Drzava d: sveDrzave){
				if(d.getNaziv().contains(obj.getNaziv())) {
						result.add(d);
						return result;
				}
				else if(d.getId().equals(obj.getId())){
						result.add(d);
						return result;
				}
		}
	}
		
		return result;
}
	
}
