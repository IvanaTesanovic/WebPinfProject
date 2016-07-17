package controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.constants.MimeTypes;
import api.constants.RequestMappings;
import dto.DrzavaDTO;
import model.Drzava;
import model.NaseljenoMesto;
import service.DrzavaService;
import service.NaseljenoMestoService;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.DRZAVE)
public class DrzaveAPIController {
	
	@Autowired
	DrzavaService service;
	
	@Autowired
	NaseljenoMestoService nmService;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA, produces = MimeTypes.APPLICATION_JSON)
	public Drzava izmeni(@RequestBody Drzava obj) {
		service.update(obj.getId(), obj.getSifra(), obj.getNaziv());
		return service.findById(obj.getId());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE, produces = MimeTypes.APPLICATION_JSON)
	public Drzava dodaj(@RequestBody Drzava obj) {
		Drzava drzava = new Drzava(obj.getSifra(), obj.getNaziv());
		service.save(drzava);
		return drzava;
	}
	
	//** OVO TREBA MENJATI **//
	/** koristiti linked hash set za duplikate **/
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
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.NEXT + "/{id}")
	public ArrayList<NaseljenoMesto> getChildsNM(@Validated @PathVariable final Long id){
		ArrayList<NaseljenoMesto> naseljenaMesta = new ArrayList<NaseljenoMesto>();
		ArrayList<NaseljenoMesto> lista = (ArrayList<NaseljenoMesto>) nmService.listAll();
		
		for (int i = 0; i < lista.size(); i++){
			if (lista.get(i).getId_drzave().getId().equals(id)){
				naseljenaMesta.add(lista.get(i));
			}
		}
		return naseljenaMesta;
	}
	
	
}
