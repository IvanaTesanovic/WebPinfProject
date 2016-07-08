package controller.api;

import model.NaseljenoMesto;

import java.util.ArrayList;
import java.util.List;

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
	public NaseljenoMesto izmeni(@RequestBody NaseljenoMestoDTO obj) {
		nmService.update(Long.parseLong(obj.getId()), obj.getNaziv(), obj.getPtt_oznaka(), drzavaService.findById(Long.parseLong(obj.getId_drzave())));
		return nmService.findById(Long.parseLong(obj.getId()));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public NaseljenoMesto dodaj(@RequestBody NaseljenoMestoDTO obj) {
		NaseljenoMesto nasMesto = new NaseljenoMesto(obj.getNaziv(), obj.getPtt_oznaka(), 
				drzavaService.findById(Long.parseLong(obj.getId_drzave())));
		nmService.save(nasMesto);
		return nasMesto;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public List<NaseljenoMesto> pretrazi(@RequestBody NaseljenoMestoDTO obj) {
		List<NaseljenoMesto> naseljenaMesta = nmService.listAll();
		List<NaseljenoMesto> result = new ArrayList<NaseljenoMesto>();
		
		if(obj.getId() != null || obj.getNaziv() != null || obj.getPtt_oznaka() != null || obj.getId_drzave() != null)
			
			for(NaseljenoMesto nm: naseljenaMesta) {
				
				if(obj.getId() != null)
					if(nm.getId().equals(Long.parseLong(obj.getId())))
						result.add(nm);
				
				if(obj.getId_drzave() != null)
					if(nm.getId_drzave().getId().equals(Long.parseLong(obj.getId_drzave())))
						result.add(nm);
				
				if(obj.getNaziv() != null)
					if(nm.getNaziv().toLowerCase().contains(obj.getNaziv().toLowerCase()))
						result.add(nm);
				
				if(obj.getPtt_oznaka() != null)
					if(nm.getPtt_oznaka().toLowerCase().contains(obj.getPtt_oznaka().toLowerCase()))
						result.add(nm);
				
		}
		
		return result;
			
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public List<NaseljenoMesto> pretrazi(@RequestBody NaseljenoMesto obj) {
		
		List<NaseljenoMesto> naseljenaMesta = nmService.listAll();
		List<NaseljenoMesto> result = new ArrayList<NaseljenoMesto>(); 
		
		if(obj.getId()!= null || obj.getNaziv()!=null || obj.getPtt_oznaka()!= null){
			for(NaseljenoMesto nm : naseljenaMesta){
				
				if( nm.getId().equals(obj.getId())){
					result.add(nm);
					return result;
				}
				else if(nm.getNaziv().contains(obj.getNaziv())){
					result.add(nm);
					return result;
				}
				else if(nm.getPtt_oznaka().contains(obj.getPtt_oznaka())){
					result.add(nm);
					return result;
				}
			/*	else if(drzavaService.findById(Long.parseLong(obj.getId_drzave())).equals(nm.getId_drzave())){
					result.add(nm);
					return result;
				}*/
			/*	}
			}
		return result; 
	}*/
	
}
