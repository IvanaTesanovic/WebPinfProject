package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Drzava;
import repository.DrzavaRepository;

@Service
@Transactional
public class DrzavaService {
	
	@Autowired
	DrzavaRepository drzavaRepo;
		
	public List<Drzava> listAll() {
		return (List<Drzava>) drzavaRepo.findAll();
	}
	
	public void save(Drzava drzava) {
		drzavaRepo.save(drzava);
	}
	
	public Drzava findByNaziv(String naziv) {
		return drzavaRepo.findByNaziv(naziv);
	}
	
	public void deleteRow(Long id) {
		drzavaRepo.delete(id);
	}
	
	public Drzava findById(Long id) {
		return drzavaRepo.findOne(id);
	}
	
	public void update(Long id, String sifra, String naziv) {
		Drzava drzava = drzavaRepo.findOne(id);
		drzava.setSifra(sifra);
		drzava.setNaziv(naziv);
		drzavaRepo.save(drzava);
	}
	
}
