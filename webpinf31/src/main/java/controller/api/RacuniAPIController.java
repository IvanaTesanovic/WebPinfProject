package controller.api;

import model.Racun;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.BankaService;
import service.KlijentService;
import service.RacunService;
import service.ValutaService;
import api.constants.MimeTypes;
import api.constants.RequestMappings;
import dto.RacunDTO;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.RACUNI)
public class RacuniAPIController {

	@Autowired
	RacunService service;
	
	@Autowired
	BankaService bankaService;
	
	@Autowired
	ValutaService valutaService;
	
	@Autowired
	KlijentService klijentService;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE, produces = MimeTypes.APPLICATION_JSON)
	public Racun dodaj(@RequestBody RacunDTO obj) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		java.sql.Date sqlDatum = null;
		
		if(obj.getDatum_otvaranja() != null) {
			String inputDatum = obj.getDatum_otvaranja().split("-")[0] + "/" + obj.getDatum_otvaranja().split("-")[1] + "/" + obj.getDatum_otvaranja().split("-")[2];
			LocalDate localDatum = LocalDate.parse(inputDatum, formatter);
			sqlDatum = java.sql.Date.valueOf(localDatum);
		}
		
		Racun racun = new Racun(obj.getBroj_racuna(), sqlDatum, Boolean.parseBoolean(obj.getVazeci()), bankaService.findById(Long.parseLong(obj.getId_banke())),
				valutaService.findById(Long.parseLong(obj.getId_valute())), klijentService.findById(Long.parseLong(obj.getId_klijenta())));
		service.save(racun);
		return racun;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}

}
