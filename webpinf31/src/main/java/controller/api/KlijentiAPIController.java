package controller.api;

import model.Klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.KlijentService;
import api.constants.RequestMappings;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.KLIJENTI)
public class KlijentiAPIController {

	@Autowired
	KlijentService service;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public Klijent dodaj(@RequestBody Klijent obj) {
		Klijent klijent = new Klijent(obj.getFizicko_lice(), obj.getJmbg(), obj.getIme(), obj.getPrezime(), obj.getAdresa(), 
				obj.getTelefon(), obj.getEmail(), obj.getNaziv(), obj.getPib(), obj.getFax(), obj.getSajt(), obj.getId_delatnosti(), 
				obj.getNaziv_delatnosti(), obj.getOdgovorno_lice());
		service.save(klijent);
		return klijent;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}

}
