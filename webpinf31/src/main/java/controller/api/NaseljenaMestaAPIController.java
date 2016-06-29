package controller.api;

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
	public NaseljenoMesto dodaj(@RequestBody NaseljenoMestoDTO obj){
		NaseljenoMesto nasMesto = new NaseljenoMesto(obj.getNaziv(), obj.getPtt_oznaka(), 
				drzavaService.findById(Long.parseLong(obj.getId_drzave())));
		nmService.save(nasMesto);
		return nasMesto;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}
	
	
	
}
