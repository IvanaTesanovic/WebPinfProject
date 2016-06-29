package service;

import java.sql.Date;
import java.util.List;

import model.Banka;
import model.KursnaLista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.KursnaListaRepository;

@Service
@Transactional
public class KursnaListaService {
	
	@Autowired
	KursnaListaRepository kursnaListaRepo;
	
	public List<KursnaLista> listAll() {
		return (List<KursnaLista>) kursnaListaRepo.findAll();
	}
	
	public void save(KursnaLista kl){
		kursnaListaRepo.save(kl);
	}	
	public void deleteRow(Long id) {
		kursnaListaRepo.delete(id);
	}
	
	 public KursnaLista findById(Long id){
		 return kursnaListaRepo.findOne(id);
	 }
	 
	 public void update(Long id,Date datum, Integer broj_kursne_liste,
				Date datum_primene, Banka id_banke){
		 
		 KursnaLista kursnaLista = kursnaListaRepo.findOne(id);
		 kursnaLista.setDatum(datum_primene);
		 kursnaLista.setBroj_kursne_liste(broj_kursne_liste);
		 kursnaLista.setDatum_primene(datum_primene);
		 kursnaLista.setBroj_kursne_liste(broj_kursne_liste);
		 kursnaListaRepo.save(kursnaLista);
	 }

}
