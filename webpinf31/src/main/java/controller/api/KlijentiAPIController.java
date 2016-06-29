package controller.api;

import java.util.ArrayList;
import java.util.List;

import model.Drzava;
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
	public void dodaj(@RequestBody Klijent obj) {
		service.save(new Klijent());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public List<Klijent> pretrazi(@RequestBody Klijent obj) {
		
		
		List<Klijent> klijenti = service.listAll();
		List<Klijent> result = new ArrayList<Klijent>();
		
		if(obj.getId()!= null || obj.getNaziv()!=null || obj.getAdresa() != null || obj.getIme()!= null || obj.getPrezime()!= null
				|| obj.getJmbg()!= null || obj.getEmail()!= null || obj.getTelefon() != null || obj.getFax()!= null || obj.getNaziv()!= null || obj.getPib() != null
				||obj.getId_delatnosti() != null
				|| obj.getNaziv_delatnosti()!= null || obj.getFizicko_lice() != null || obj.getOdgovorno_lice() != null){
			
				for(Klijent k: klijenti){
					if(k.getNaziv().contains(obj.getNaziv())) {
						result.add(k);
						return result;
					}
					else if(k.getId().equals(obj.getId())){
						result.add(k);
						return result;
					}
					else if(k.getIme().contains(obj.getIme())){
						result.add(k);
						return result;
					}
					else if(k.getPrezime().contains(obj.getPrezime())){
						result.add(k);
						return result;
					}
					else if(k.getJmbg().contains(obj.getJmbg())){
						result.add(k);
						return result;
					}
					else if(k.getAdresa().contains(obj.getAdresa())){
						result.add(k);
						return result;
					}
					else if(k.getEmail().contains(obj.getEmail())){
						result.add(k);
						return result;
					}
					else if(k.getFax().contains(obj.getFax())){
						result.add(k);
						return result;
					}
					else if(k.getTelefon().contains(obj.getTelefon())){
						result.add(k);
						return result;
					}
					else if(k.getNaziv().contains(obj.getNaziv())){
						result.add(k);
						return result;
					}
					
					else if(k.getPib().contains(obj.getPib())){
						result.add(k);
						return result;
					}
					
					else if(k.getNaziv_delatnosti().contains(obj.getNaziv_delatnosti())){
						result.add(k);
						return result;
					}
					
					else if(k.getId_delatnosti().contains(obj.getId_delatnosti())){
						result.add(k);
						return result;
					}
					
					else if(k.getId().equals(obj.getId())){
						result.add(k);
						return result;
				}
					
					else if(k.getFizicko_lice().equals(obj.getFizicko_lice())){
						result.add(k);
						return result;
					}
					else if(k.getOdgovorno_lice().contains(obj.getOdgovorno_lice())){
						result.add(k);
						return result;
					}
		}
	}
		
		return result;
		
	}

}
