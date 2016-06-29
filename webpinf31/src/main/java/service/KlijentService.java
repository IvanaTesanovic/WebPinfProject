package service;

import java.util.List;

import model.Klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.KlijentRepository;

@Service
@Transactional
public class KlijentService {

	@Autowired 
	KlijentRepository klijentRepo;
	
	public List<Klijent> listAll() {
		return (List<Klijent>) klijentRepo.findAll();
	}
	
	public void save(Klijent k){
		klijentRepo.save(k);
	}
	
	public void deleteRow(Long id) {
		klijentRepo.delete(id);
	}
	
	 public Klijent findById(Long id){
		 return klijentRepo.findOne(id);
	 }
	 
	 public void update(Long id,Boolean fizicko_lice, String jmbg, String ime,
			String prezime, String adresa, String telefon, String email,
			String naziv, String pib, String fax, String sajt,
			String id_delatnosti, String naziv_delatnosti, String odgovorno_lice){
		 
		 Klijent klijent = klijentRepo.findOne(id);
		 klijent.setFizicko_lice(fizicko_lice);
		 klijent.setJmbg(jmbg);
		 klijent.setIme(ime);
		 klijent.setPrezime(prezime);
		 klijent.setAdresa(adresa);
		 klijent.setTelefon(telefon);
		 klijent.setEmail(email);
		 klijent.setNaziv(naziv);
		 klijent.setPib(pib);
		 klijent.setFax(fax);
		 klijent.setSajt(sajt);
		 klijent.setId_delatnosti(id_delatnosti);
		 klijent.setNaziv_delatnosti(naziv_delatnosti);
		 klijent.setOdgovorno_lice(odgovorno_lice);
		 klijentRepo.save(klijent);
	 }
}
