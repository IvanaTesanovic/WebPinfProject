package controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.constants.MimeTypes;
import api.constants.RequestMappings;
import dto.DrzavaDTO;
import model.Drzava;
import service.DrzavaService;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.DRZAVE)
public class DrzaveAPIController {
	
	@Autowired
	DrzavaService service;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA, produces = MimeTypes.APPLICATION_JSON)
	public Drzava izmeni(@RequestBody Drzava obj) {
		service.update(obj.getId(), obj.getNaziv());
		return service.findById(obj.getId());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE, produces = MimeTypes.APPLICATION_JSON)
	public Drzava dodaj(@RequestBody Drzava obj) {
		Drzava drzava = new Drzava(obj.getNaziv());
		service.save(drzava);
		return drzava;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public List<Drzava> pretrazi(@RequestBody DrzavaDTO obj) {
		List<Drzava> drzave = service.listAll();
		List<Drzava> rezultati = new ArrayList<Drzava>();
		
		String id = obj.getId();
		String naziv = obj.getNaziv();
		
		System.out.println(id);
		
		if(obj.getId() != null && obj.getNaziv() != null) {
			for(Drzava d: drzave)
				if(d.getId().equals(Long.parseLong(obj.getId())) && d.getNaziv().toLowerCase().equals(obj.getNaziv().toLowerCase()))
					rezultati.add(d);
		}
		else if(obj.getId() != null && obj.getNaziv() == null) {
			for(Drzava d: drzave)
				if(d.getId().equals(Long.parseLong(obj.getId())))
					rezultati.add(d);
		}
		else if(obj.getId() == null && obj.getNaziv() != null) {
			for(Drzava d: drzave)
				if(d.getNaziv().toLowerCase().contains(obj.getNaziv().toLowerCase()))
					rezultati.add(d);
		}
		
		return rezultati;
	}
}
