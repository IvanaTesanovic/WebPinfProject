package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Korisnik;
import repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepository korisnikRepo;
	
	public List<Korisnik> findAll() {
		return (List<Korisnik>) korisnikRepo.findAll();
	}
	
	public Korisnik findByKorisnickoIme(String korisnickoIme) {
		return korisnikRepo.findByKorisnickoIme(korisnickoIme);
	}
	
	public void deleteRow(Long id) {
		korisnikRepo.delete(id);
	}

}
