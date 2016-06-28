package controller.api;

import model.AnalitikaIzvoda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.AnalitikaIzvodaService;
import service.DnevnaStanjaRacunaService;
import service.NaseljenoMestoService;
import service.ValutaService;
//import service.VrstePlacanjaService;
import api.constants.RequestMappings;
//import dto.AnalitikaIzvodaDTO;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.ANALITIKE_IZVODA)
public class AnalitikeIzvodaAPIController {

	@Autowired
	AnalitikaIzvodaService analitikaIzvodaService;
	/*	
	@Autowired
	DnevnaStanjaRacunaService dnevnaStanjaRacunaService;
	
	@Autowired
	VrstePlacanjaService vpService;
	
	@Autowired
	NaseljenoMestoService nmService;
	
	@Autowired
	ValutaService valutaService;
	*/
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public void dodaj(/*@RequestBody AnalitikaIzvodaDTO obj*/) {
	
		analitikaIzvodaService.save(new AnalitikaIzvoda()); }/*(obj.getDuznik(), obj.getPoverilac(), obj.getSvrha_placanja(), obj.getDatum_prijema(),
				obj.getDatum_valute(), obj.getRacun_duznika(), obj.getRacun_poverioca(), obj.getModel_odobrenja(), obj.getModel_zaduzenja(),
				obj.getPoziv_na_broj_odobrenja(),obj.getPoziv_na_broj_zaduzenja(),obj.getHitno(), obj.getIznos(), obj.getTip_greske(),
				obj.getStatus(), dnevnaStanjaRacunaService.findById(Long.parseLong(obj.getId_dnevnog_stanja_racuna())),
				vpService.findById(Long.parseLong(obj.getId_vrste_placanja())), valutaService.findById(Long.parseLong(obj.getId_valute())),
				nmService.findById(Long.parseLong(obj.getId_naseljenog_mesta())))); 
	} */
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}
	
	
}
