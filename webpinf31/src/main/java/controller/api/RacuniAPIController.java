package controller.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import api.constants.MimeTypes;
import api.constants.RequestMappings;
import dto.RacunDTO;
import model.Banka;
import model.DnevnoStanjeRacuna;
import model.Klijent;
import model.Racun;
import model.SPTable;
import model.UkidanjeRacuna;
import model.Valuta;
import service.BankaService;
import service.DnevnaStanjaRacunaService;
import service.KlijentService;
import service.RacunService;
import service.SPTableService;
import service.UkidanjeRacunaService;
import service.ValutaService;

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
	
	@Autowired
	DnevnaStanjaRacunaService dsrService;
	
	@Autowired
	UkidanjeRacunaService ukidanjeService;
	
	@Autowired
	SPTableService spTableService;
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.IZMENA)
	public void izmeni(@RequestBody RacunDTO obj) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		java.sql.Date sqlDatum = null;
		
		if(obj.getDatum_otvaranja() != null) {
			String inputDatum = obj.getDatum_otvaranja().split("-")[0] + "/" + obj.getDatum_otvaranja().split("-")[1] + "/" + obj.getDatum_otvaranja().split("-")[2];
			LocalDate localDatum = LocalDate.parse(inputDatum, formatter);
			sqlDatum = java.sql.Date.valueOf(localDatum);
		}
		
		service.update(Long.parseLong(obj.getId()), obj.getBroj_racuna(), sqlDatum, Boolean.parseBoolean(obj.getVazeci()),
				bankaService.findById(Long.parseLong(obj.getId_banke())),valutaService.findById(Long.parseLong(obj.getId_valute())),
				klijentService.findById(Long.parseLong(obj.getId_klijenta())));
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.DODAVANJE, produces = MimeTypes.APPLICATION_JSON)
	public Racun dodaj(@RequestBody RacunDTO obj) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		java.sql.Date sqlDatum = null;
		Banka banka = null;
		Valuta valuta = null;
		Klijent klijent = null;
		
		if(obj.getDatum_otvaranja() != null) {
			String inputDatum = obj.getDatum_otvaranja().split("-")[0] + "/" + obj.getDatum_otvaranja().split("-")[1] + "/" + obj.getDatum_otvaranja().split("-")[2];
			LocalDate localDatum = LocalDate.parse(inputDatum, formatter);
			sqlDatum = java.sql.Date.valueOf(localDatum);
		}
		
		if(obj.getId_banke() != null)
			banka = bankaService.findById(Long.parseLong(obj.getId_banke()));
		
		if(obj.getId_valute() != null)
			valuta = valutaService.findById(Long.parseLong(obj.getId_valute()));
		
		if(obj.getId_klijenta() != null)
			klijent = klijentService.findById(Long.parseLong(obj.getId_klijenta()));
		
		Racun racun = new Racun(obj.getBroj_racuna(), sqlDatum, Boolean.parseBoolean(obj.getVazeci()), banka,
				valuta, klijent);
		service.save(racun);
		return racun;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.PRETRAGA)
	public void pretrazi() {
		
	}
	
	/** ovde nam ne treba broj racuna za prebacivanje jer ne prebacujemo novac **/
	/** samo ukidamo racun i postavljamo flag vazeci na false **/
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.UKIDANJE + "/bez/" + "{id}")
	public void ukiniBezPrebacivanja(@Validated @PathVariable final Long id, @RequestBody String broj) {
		
		java.util.Date datum = new java.util.Date();
		java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
		
		/** preostala sredstva iz dnevnog_stanja_racuna **/
		List<DnevnoStanjeRacuna> dnevnaStanja = dsrService.listAll();
		ArrayList<DnevnoStanjeRacuna> stanjaRacuna = new ArrayList<DnevnoStanjeRacuna>();
		
		for(DnevnoStanjeRacuna dsr: dnevnaStanja)
			if(dsr.getId_racuna().getId().equals(id))
				stanjaRacuna.add(dsr);
		
		//ovo vraca najveci id
		Collections.sort(stanjaRacuna, (r1, r2) -> r1.getId().compareTo(r2.getId()));
		DnevnoStanjeRacuna dsr = dsrService.findById(stanjaRacuna.get(stanjaRacuna.size()-1).getId());
		
		Racun racun = service.findById(id);
		
		ukidanjeService.save(new UkidanjeRacuna(sqlDatum, String.valueOf(dsr.getNovo_stanje()), racun));
		service.update(id, racun.getBroj_racuna(), racun.getDatum_otvaranja(), false, racun.getId_banke(),
				racun.getId_valute(), racun.getId_klijenta());
	}
	
	/** ovde prihvatamo i broj racuna na koji prebacujemo novac **/
	/** prebacimo novac i ukinemo racun
	    novac se prebacuje i definisanjem dnevnog stanja racuna na koji prebacujemo a i sa kog prebacujemo (?) **/
	@RequestMapping(method = RequestMethod.POST, value = RequestMappings.UKIDANJE + "/sa/" + "{id}")
	public String ukiniSaPrebacivanjem(@Validated @PathVariable final Long id, @RequestBody String broj) {
		
		try {
			
		java.util.Date datum = new java.util.Date();
		java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
		
		Racun racun = service.findById(id);
		Racun racunPrebacivanja = new Racun();
		List<Racun> racuni = service.listAll();
		
		for(Racun r: racuni)
			if(r.getBroj_racuna().equals(broj)) {
				racunPrebacivanja = r;
				break;
			}
		
		Klijent klijent = new Klijent();
		Klijent klijentPrebacivanja = new Klijent();
		List<Klijent> klijenti = klijentService.listAll();
		
		for(Klijent k: klijenti)
			if(k.getId().equals(racun.getId_klijenta().getId())) {
				klijent = k;
				break;
			}
		
		for(Klijent k: klijenti)
			if(k.getId().equals(racunPrebacivanja.getId_klijenta().getId())) {
				klijentPrebacivanja = k;
				break;
			}
		
		//treba mi racun sa kog prebacujem
		//poslednji u dnevnom stanju racuna
		//njegovo novo stanje
		
		ArrayList<DnevnoStanjeRacuna> stanja = new ArrayList<DnevnoStanjeRacuna>();
		
		for(DnevnoStanjeRacuna d: dsrService.listAll())
			if(d.getId_racuna().getId().equals(id))
				stanja.add(d);
		
		//vraca najveci id
		Collections.sort(stanja, (dr1, dr2) -> dr1.getId().compareTo(dr2.getId()));
		
		spTableService.save(new SPTable("UYDTV73748BJDBN", getNaziv(klijent), getNaziv(klijentPrebacivanja),
				"Prebacivanje sredstava radi ukidanja racuna", sqlDatum, racun.getBroj_racuna(), "97",
    			"65749368499", racunPrebacivanja.getBroj_racuna(),
    			"97", "12300009833", false, "RSD", new BigDecimal(stanja.get(stanja.size()-1).getNovo_stanje()), true));
		
		ukidanjeService.save(new UkidanjeRacuna(sqlDatum, String.valueOf(0), racun));
		service.update(id, racun.getBroj_racuna(), racun.getDatum_otvaranja(), false, racun.getId_banke(),
				racun.getId_valute(), racun.getId_klijenta());
		
		return "";
		
		} catch (Exception e) {
	    	if(e.getCause() instanceof SQLGrammarException) {
	    		SQLServerException eee = (SQLServerException)e.getCause().getCause();
	    		return eee.getMessage();
	    	}
	    	return e.getMessage();
		}
	}
	
	
	/** POMOCNE METODE **/
	
	public String getNaziv(Klijent k) {
		String nazivKlijenta = "";
		
		if(k.getFizicko_lice())
			nazivKlijenta = k.getIme() + " " + k.getPrezime();
		else
			nazivKlijenta = k.getNaziv();
		
		return nazivKlijenta;
	}
		
		
		
		
		
//		List<Racun> racuni = service.listAll();
//		
//		/** preostala sredstva iz dnevnog_stanja_racuna **/
//		List<DnevnoStanjeRacuna> dnevnaStanja = dsrService.listAll();
//		ArrayList<DnevnoStanjeRacuna> stanjaRacuna = new ArrayList<DnevnoStanjeRacuna>();
//		
//		for(DnevnoStanjeRacuna dsr: dnevnaStanja)
//			if(dsr.getId_racuna().getId().equals(id))
//				stanjaRacuna.add(dsr);
//		
//		//ovo vraca najveci id racuna koji zelimo da ukinemo
//		Collections.sort(stanjaRacuna, (r1, r2) -> r1.getId().compareTo(r2.getId()));
//		DnevnoStanjeRacuna dsr = dsrService.findById(stanjaRacuna.get(stanjaRacuna.size()-1).getId());
//		
//		/** racun koji zelimo da ukinemo **/
//		Racun racun = service.findById(id);
//		
//		/** racun na koji prebacujemo novac **/
//		Racun racunPrebacivanja = new Racun();
//		
//		/** trazimo racun na koji zelimo da prebacimo novac po broju racuna **/
//		for(Racun r: racuni)
//			if(r.getBroj_racuna().equals(broj)) {
//				racunPrebacivanja = r;
//				break;
//			}
//		
//		/** uvecavamo dati racun na koji prebacujemo novac **/
//		//pronalazimo ga u dsr i uvecavamo za novo_stanje od racuna koji ukidamo
//		ArrayList<DnevnoStanjeRacuna> stanjaRacunaPrebacivanja = new ArrayList<DnevnoStanjeRacuna>();
//		
//		for(DnevnoStanjeRacuna dsr1: dnevnaStanja)
//			if(dsr1.getId_racuna().getId().equals(racunPrebacivanja.getId()))
//				stanjaRacunaPrebacivanja.add(dsr1);
//		
//		//ovo vraca najveci id
//		Collections.sort(stanjaRacunaPrebacivanja, (rp1, rp2) -> rp1.getId().compareTo(rp2.getId()));
//		DnevnoStanjeRacuna dsrPrebacivanja = dsrService.findById(stanjaRacunaPrebacivanja.get(stanjaRacunaPrebacivanja.size()-1).getId());
//		
//		/** uvecavamo dati racun za iznos **/
//		dsrService.save(new DnevnoStanjeRacuna(sqlDatum, dsr.getNovo_stanje(), dsrPrebacivanja.getNovo_stanje(), 0.0,
//				dsrPrebacivanja.getNovo_stanje()+dsr.getNovo_stanje(), racunPrebacivanja));
//		
//		/** stavljamo vazeci na false i ubacujemo u tabelu ukidanja **/
//		ukidanjeService.save(new UkidanjeRacuna(sqlDatum, String.valueOf(dsr.getNovo_stanje()), racun));
//		service.update(id, racun.getBroj_racuna(), racun.getDatum_otvaranja(), false, racun.getId_banke(),
//				racun.getId_valute(), racun.getId_klijenta());

}
