package controller.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.constants.RequestMappings;
import dto.KursnaListaDTO;
import model.KursnaLista;
import service.BankaService;
import service.KursnaListaService;

@RestController
@RequestMapping(RequestMappings.ACTIONS_API + RequestMappings.KURSNA_LISTA)
public class KursnaListaAPIController {
	
	@Autowired
	KursnaListaService service;
	
	@Autowired
	BankaService bankaService;

	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public KursnaLista izmeni(@RequestBody KursnaListaDTO obj) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String inputDatum = obj.getDatum().split("-")[0] + "/" + obj.getDatum().split("-")[1] + "/" + obj.getDatum().split("-")[2];
		LocalDate localDatum = LocalDate.parse(inputDatum, formatter);
		
		String inputDatumPrimene = obj.getDatum_primene().split("-")[0] + "/" + obj.getDatum_primene().split("-")[1] + "/" + obj.getDatum_primene().split("-")[2];
		LocalDate localDatumPrimene = LocalDate.parse(inputDatumPrimene, formatter);
		
		java.sql.Date sqlDatum = java.sql.Date.valueOf(localDatum);
		java.sql.Date sqlDatumPrimene = java.sql.Date.valueOf(localDatumPrimene);
		
		service.update(Long.parseLong(obj.getId()), sqlDatum, Integer.parseInt(obj.getBroj_kursne_liste()), sqlDatumPrimene, bankaService.findById(Long.parseLong(obj.getId_banke())));
		return service.findById(Long.parseLong(obj.getId()));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE)
	public KursnaLista dodaj(@RequestBody KursnaListaDTO obj) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String inputDatum = obj.getDatum().split("-")[0] + "/" + obj.getDatum().split("-")[1] + "/" + obj.getDatum().split("-")[2];
		LocalDate localDatum = LocalDate.parse(inputDatum, formatter);
		
		String inputDatumPrimene = obj.getDatum_primene().split("-")[0] + "/" + obj.getDatum_primene().split("-")[1] + "/" + obj.getDatum_primene().split("-")[2];
		LocalDate localDatumPrimene = LocalDate.parse(inputDatumPrimene, formatter);
		
		java.sql.Date sqlDatum = java.sql.Date.valueOf(localDatum);
		java.sql.Date sqlDatumPrimene = java.sql.Date.valueOf(localDatumPrimene);
		
		KursnaLista lista = new KursnaLista(sqlDatum, Integer.parseInt(obj.getBroj_kursne_liste()), sqlDatumPrimene, bankaService.findById(Long.parseLong(obj.getId_banke())));
		service.save(lista);
		return lista;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}

}
