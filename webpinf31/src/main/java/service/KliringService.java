package service;

import java.util.Date;
import java.util.List;

import model.GrupaIzvoda;
import model.Kliring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.KliringRepository;

@Service
@Transactional
public class KliringService {
	
	@Autowired
	KliringRepository kliringRepo;
	
	public List<Kliring> listAll() {
		return (List<Kliring>) kliringRepo.findAll();
	}
	
	public void save(Kliring kliring){
		kliringRepo.save(kliring);
	}

	public void deleteRow(Long id) {
		kliringRepo.delete(id);
	}
	
	 public Kliring findById(Long id){
		 return kliringRepo.findOne(id);
	 }
	 
	 public void update(Long id, String id_poruke, String swift_banke_duznika,
				String obracunski_racun_banke_duznika,
				String swift_banke_poverioca,
				String obracunski_racun_banke_poverioca, Date datum_naloga,
				String id_valute, Date datum_valute, Double ukupan_iznos,
				GrupaIzvoda id_grupe_izvoda){
		 
		 
		 Kliring kliring = kliringRepo.findOne(id);
		 kliring.setId_poruke(id_poruke);
		 kliring.setSwift_banke_duznika(swift_banke_duznika);
		 kliring.setObracunski_racun_banke_duznika(obracunski_racun_banke_duznika);
		 kliring.setSwift_banke_poverioca(swift_banke_poverioca);
		 kliring.setObracunski_racun_banke_poverioca(obracunski_racun_banke_poverioca);
		 kliring.setDatum_naloga(datum_naloga);
		 kliring.setId_valute(id_valute);
		 kliring.setDatum_valute(datum_valute);
		 kliring.setUkupan_iznos(ukupan_iznos);
		 kliring.setId_grupe_izvoda(id_grupe_izvoda);
		 kliringRepo.save(kliring);
	 }
}
