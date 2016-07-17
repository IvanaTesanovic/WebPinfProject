package controller.api;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.constants.RequestMappings;
import dto.NaseljenoMestoDTO;
import model.AnalitikaIzvoda;
import model.NaseljenoMesto;
import service.AnalitikaIzvodaService;
import service.DrzavaService;
import service.NaseljenoMestoService;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.NASELJENA_MESTA)
public class NaseljenaMestaAPIController {

	@Autowired 
	NaseljenoMestoService nmService;
	
	@Autowired
	DrzavaService drzavaService;
	
	@Autowired
	AnalitikaIzvodaService aiService;
	
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
		
		Set<NaseljenoMesto> hs = new LinkedHashSet<>(result);
		result.clear();
		result.addAll(hs);
		
		return result;
			
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.NEXT + "/{id}")
	public ArrayList<AnalitikaIzvoda> getChildsNM(@Validated @PathVariable final Long id){
		ArrayList<AnalitikaIzvoda> analitike = new ArrayList<AnalitikaIzvoda>();
		ArrayList<AnalitikaIzvoda> lista = (ArrayList<AnalitikaIzvoda>) aiService.listAll();
		
		for (int i = 0; i < lista.size(); i++){
			if (lista.get(i).getId_naseljenog_mesta().getId().equals(id)){
				analitike.add(lista.get(i));
			}
		}
		return analitike;
	}
	
}
