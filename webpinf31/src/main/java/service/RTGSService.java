package service;

import java.util.Date;
import java.util.List;

import model.AnalitikaIzvoda;
import model.RTGS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.RTGSRepository;

@Service
@Transactional
public class RTGSService {

	@Autowired
	RTGSRepository rtgsRepo;
	
	public List<RTGS> listAll() {
		return (List<RTGS>) rtgsRepo.findAll();
	}
	
	public void save(RTGS rtgs){
		rtgsRepo.save(rtgs);
	}
	
	public void deleteRow(Long id) {
		rtgsRepo.delete(id);
	}
	
	 public RTGS findById(Long id){
		 return rtgsRepo.findOne(id);
	 }
	 
	 public void update(Long id, String id_poruke, String swift_banke_duznika, String duznik,
				String racun_duznika, String obracunski_racun_banke_duznika,
				String swift_banke_poverioca, String poverilac,
				String racun_poverioca, String obracunski_racun_banke_poverioca,
				String model_zaduzenja, String poziv_na_broj_zaduzenja,
				String model_odobrenja, String poziv_na_broj_odobrenja,
				String svrha_placanja, Date datum_naloga, String id_valute,
				Date datum_valute, Double ukupan_iznos,
				AnalitikaIzvoda id_analitike_izvoda){
		 
		 RTGS rtgs = rtgsRepo.findOne(id);
		 rtgs.setId_poruke(id_poruke);
		 rtgs.setSwift_banke_duznika(swift_banke_duznika);
		 rtgs.setDuznik(obracunski_racun_banke_duznika);
		 rtgs.setRacun_duznika(racun_duznika);
		 rtgs.setObracunski_racun_banke_duznika(obracunski_racun_banke_duznika);
		 rtgs.setSwift_banke_poverioca(swift_banke_poverioca);
		 rtgs.setPoverilac(poverilac);
		 rtgs.setRacun_poverioca(racun_poverioca);
		 rtgs.setObracunski_racun_banke_poverioca(obracunski_racun_banke_poverioca);
		 rtgs.setModel_zaduzenja(model_zaduzenja);
		 rtgs.setPoziv_na_broj_zaduzenja(poziv_na_broj_zaduzenja);
		 rtgs.setModel_odobrenja(model_odobrenja);
		 rtgs.setPoziv_na_broj_odobrenja(poziv_na_broj_odobrenja);
		 rtgs.setSvrha_placanja(svrha_placanja);
		 rtgs.setDatum_naloga(datum_naloga);
		 rtgs.setId_valute(id_valute);
		 rtgs.setDatum_valute(datum_valute);
		 rtgs.setUkupan_iznos(ukupan_iznos);
		 rtgs.setId_analitike_izvoda(id_analitike_izvoda);
		 rtgsRepo.save(rtgs);
		 
	 }
}
