package controller.api;

import model.Drzava;
import model.KursnaLista;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.BankaService;
import service.KursnaListaService;
import api.constants.RequestMappings;
import dto.KursnaListaDTO;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.KURSNA_LISTA)
public class KursnaListaAPIController {
	
	@Autowired
	KursnaListaService service;
	
	@Autowired
	BankaService bankaService;

	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public KursnaLista dodaj(@RequestBody KursnaListaDTO obj) {
//		Date datum = obj.getDatum();
//		Date datumPrimene = obj.getDatum_primene();
		
		
		return null;
		//KursnaLista lista = new KursnaLista(new Date(year, month, day), broj_kursne_liste, datum_primene, id_banke)
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}

}
