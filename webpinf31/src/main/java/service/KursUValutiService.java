package service;

import java.util.List;

import model.KursUValuti;
import model.KursnaLista;
import model.Valuta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.KursUValutiRepository;

@Service
@Transactional
public class KursUValutiService {

	@Autowired
	KursUValutiRepository kursUValutiRepo;
	
	public List<KursUValuti> listAll() {
		return (List<KursUValuti>) kursUValutiRepo.findAll();
	}
	
	public void save(KursUValuti kursUValuti){
		kursUValutiRepo.save(kursUValuti);
	}
	
	public void deleteRow(Long id) {
		kursUValutiRepo.delete(id);
	}

	 public KursUValuti findById(Long id){
		 return kursUValutiRepo.findOne(id);
	 }
	 
	 public void update(Long id, Double kupovni_kurs, Double srednji_kurs,
			Double prodajni_kurs, KursnaLista id_kursne_liste,
			Valuta id_valute, Valuta id_osnovne_valute){
		 
		 KursUValuti kursUValuti = kursUValutiRepo.findOne(id);
		 kursUValuti.setKupovni_kurs(kupovni_kurs);
		 kursUValuti.setSrednji_kurs(srednji_kurs);
		 kursUValuti.setProdajni_kurs(prodajni_kurs);
		 kursUValuti.setId_kursne_liste(id_kursne_liste);
		 kursUValuti.setId_valute(id_valute);
		 kursUValuti.setId_osnovne_valute(id_osnovne_valute);
		 kursUValutiRepo.save(kursUValuti);
	 }
}
