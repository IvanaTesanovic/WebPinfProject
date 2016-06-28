package service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Drzava;
import repository.DrzavaRepository;

@Service
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
	
	@Transactional
	public void update(Long id, String naziv) {
		Drzava drzava = drzavaRepo.findOne(id);
		drzava.setNaziv(naziv);
		drzavaRepo.save(drzava);
	}
}
