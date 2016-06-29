package controller.api;

import model.Banka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.BankaService;
import api.constants.MimeTypes;
import api.constants.RequestMappings;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.BANKE)
public class BankeAPIController {
	
	@Autowired
	BankaService service;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE, produces = MimeTypes.APPLICATION_JSON)
	public Banka dodaj(@RequestBody Banka obj) {
		Banka banka = new Banka(obj.getPib(), obj.getNaziv(), obj.getAdresa(), obj.getTelefon(),
				obj.getEmail(), obj.getWeb(), obj.getFax(), obj.getNarodna_banka());
		service.save(banka);
		return banka;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}


}
