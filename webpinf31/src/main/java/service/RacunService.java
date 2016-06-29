package service;

import java.sql.Date;
import java.util.List;

import model.Banka;
import model.Klijent;
import model.Racun;
import model.Valuta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.RacunRepository;

@Service
@Transactional
public class RacunService {

	@Autowired
	RacunRepository racunRepo;
	
	public List<Racun> listAll() {
		return (List<Racun>) racunRepo.findAll();
	}
	
	public void save(Racun racun){
		racunRepo.save(racun);
		
	}
	public void deleteRow(Long id) {
		racunRepo.delete(id);
	}

	 public Racun findById(Long id){
		 return racunRepo.findOne(id);
	 }
	 public void update(Long id, String broj_racuna, Date datum_otvaranja, Boolean vazeci,
			Banka id_banke, Valuta id_valute, Klijent id_klijenta){
		 
		 Racun racun = racunRepo.findOne(id);
		 racun.setBroj_racuna(broj_racuna);
		 racun.setDatum_otvaranja(datum_otvaranja);
		 racun.setVazeci(vazeci);
		 racun.setId_banke(id_banke);
		 racun.setId_valute(id_valute);
		 racun.setId_klijenta(id_klijenta);
		 racunRepo.save(racun);
	 }
}
