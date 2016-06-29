package service;

import java.sql.Date;
import java.util.List;

import model.AnalitikaIzvoda;
import model.DnevnoStanjeRacuna;
import model.Drzava;
import model.NaseljenoMesto;
import model.Valuta;
import model.VrstePlacanja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.AnalitikaIzvodaRepository;

@Service
@Transactional
public class AnalitikaIzvodaService {
	
	@Autowired
	AnalitikaIzvodaRepository analitikaIzvodaRepo;
	
	public List<AnalitikaIzvoda> listAll() {
		return (List<AnalitikaIzvoda>) analitikaIzvodaRepo.findAll();
	}
	
	public void save(AnalitikaIzvoda ai){
		analitikaIzvodaRepo.save(ai);
	}
	
	public void deleteRow(Long id) {
		analitikaIzvodaRepo.delete(id);
	}

	public AnalitikaIzvoda findById(Long id) {
		return analitikaIzvodaRepo.findOne(id);
	}
	
	public void update(Long id,String duznik, String poverilac,
			String svrha_placanja, Date datum_prijema, Date datum_valute,
			String racun_duznika, String racun_poverioca,
			String model_odobrenja, String model_zaduzenja,
			String poziv_na_broj_odobrenja, String poziv_na_broj_zaduzenja,
			Boolean hitno, Double iznos, Integer tip_greske, String status,
			DnevnoStanjeRacuna id_dnevnog_stanja_racuna,
			VrstePlacanja id_vrste_placanja, Valuta id_valute,
			NaseljenoMesto id_naseljenog_mesta){
		
		AnalitikaIzvoda analitikaIzvoda = analitikaIzvodaRepo.findOne(id);
		analitikaIzvoda.setDuznik(duznik);
		analitikaIzvoda.setPoverilac(poverilac);
		analitikaIzvoda.setSvrha_placanja(svrha_placanja);
		analitikaIzvoda.setDatum_prijema(datum_prijema);
		analitikaIzvoda.setDatum_valute(datum_valute);
		analitikaIzvoda.setRacun_duznika(racun_duznika);
		analitikaIzvoda.setRacun_poverioca(racun_poverioca);
		analitikaIzvoda.setModel_odobrenja(model_odobrenja);
		analitikaIzvoda.setModel_zaduzenja(model_zaduzenja);
		analitikaIzvoda.setPoziv_na_broj_odobrenja(poziv_na_broj_odobrenja);
		analitikaIzvoda.setPoziv_na_broj_zaduzenja(poziv_na_broj_zaduzenja);
		analitikaIzvoda.setHitno(hitno);
		analitikaIzvoda.setIznos(iznos);
		analitikaIzvoda.setTip_greske(tip_greske);
		analitikaIzvoda.setStatus(status);
		analitikaIzvoda.setId_dnevnog_stanja_racuna(id_dnevnog_stanja_racuna);
		analitikaIzvoda.setId_vrste_placanja(id_vrste_placanja);
		analitikaIzvoda.setId_valute(id_valute);
		analitikaIzvoda.setId_naseljenog_mesta(id_naseljenog_mesta);
		analitikaIzvodaRepo.save(analitikaIzvoda);
		
	}
}
