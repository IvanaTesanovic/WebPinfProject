package controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.constants.RequestMappings;
import dto.AkcijaDTO;
import model.Drzava;
import service.DrzavaService;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.DRZAVE)
public class DrzaveAPIController {
	
	@Autowired
	DrzavaService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public void izvrsiAkciju(@RequestBody AkcijaDTO akcijaDTO) {
		
		List<Drzava> drzave = service.listAll();
		
		//1 - izmena, 2 - dodavanje, 3 - pretraga
		String rezim = akcijaDTO.getRezim();
		
		if(rezim.equals("1")) {
			
		}
		else if(rezim.equals("2")) {
			Drzava drzava = new Drzava("Srbija");
			service.save(drzava);
		}
		else if(rezim.equals("3")) {
			
		}
		
	}

}
