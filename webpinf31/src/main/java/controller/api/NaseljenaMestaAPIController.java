package controller.api;

import java.util.ArrayList;
import java.util.List;

import model.NaseljenoMesto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.DrzavaService;
import service.NaseljenoMestoService;
import api.constants.RequestMappings;
import dto.NaseljenoMestoDTO;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.NASELJENA_MESTA)
public class NaseljenaMestaAPIController {

	@Autowired 
	NaseljenoMestoService nmService;
	
	@Autowired
	DrzavaService drzavaService;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public void dodaj(@RequestBody NaseljenoMestoDTO obj){
		nmService.save(new NaseljenoMesto(obj.getNaziv(), obj.getPtt_oznaka(), 
				drzavaService.findById(Long.parseLong(obj.getId_drzave()))));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public List<NaseljenoMesto> pretrazi(@RequestBody NaseljenoMesto obj) {
		List<NaseljenoMesto> nm = nmService.listAll();
		List<NaseljenoMesto> result = new ArrayList<NaseljenoMesto>();
		
		if(obj.getId()!= null || obj.getNaziv()!=null || obj.getPtt_oznaka() != null || obj.getId_drzave() != null){
			for(NaseljenoMesto n: nm){
				if(n.getNaziv().contains(obj.getNaziv())) {
						result.add(n);
						return result;
				}
				else if(n.getId().equals(obj.getId())){
						result.add(n);
						return result;
				}
				else if(n.getPtt_oznaka().equals(obj.getPtt_oznaka())){
					result.add(n);
					return result;
			}
				else if(n.getId_drzave().equals(obj.getId_drzave())){
					result.add(n);
					return result;
			}
		}
	}
		
		return result;
}
	
		
	
}
