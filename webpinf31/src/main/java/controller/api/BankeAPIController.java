package controller.api;

import java.util.ArrayList;
import java.util.List;

import model.Banka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.BankaService;
import api.constants.RequestMappings;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.BANKE)
public class BankeAPIController {
	
	@Autowired
	BankaService service;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public void dodaj(@RequestBody Banka obj) {
		service.save(new Banka(obj.getPib(), obj.getNaziv(), obj.getAdresa(), obj.getTelefon(),
				obj.getEmail(), obj.getWeb(), obj.getFax(), obj.getNarodna_banka()));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public List<Banka> pretrazi(@RequestBody Banka obj) {
		List<Banka> banke = service.listAll();
		List<Banka> result = new ArrayList<Banka>();
		
		if(obj.getId()!= null || obj.getNaziv()!=null || obj.getAdresa() != null || obj.getEmail() != null
				|| obj.getFax() != null || obj.getPib() != null || obj.getWeb() != null || obj.getNarodna_banka() != null){
			for(Banka b: banke){
				if(b.getNaziv().contains(obj.getNaziv())) {
						result.add(b);
						return result;
				}
				else if(b.getId().equals(obj.getId())){
						result.add(b);
						return result;
				}
				else if(b.getAdresa().contains(obj.getAdresa())){
					result.add(b);
					return result;
			}
				else if(b.getEmail().contains(obj.getEmail())){
					result.add(b);
					return result;
			}
				else if(b.getFax().contains(obj.getFax())){
					result.add(b);
					return result;
			}
				else if(b.getPib().contains(obj.getPib())){
					result.add(b);
					return result;
			}
				else if(b.getWeb().contains(obj.getWeb())){
					result.add(b);
					return result;
			}
				else if(b.getNarodna_banka().equals(obj.getNarodna_banka())){
					result.add(b);
					return result;
			}
		}
	}
		
		return result;
	}


}
