package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Drzava;
import repository.DrzavaRepository;

@Service
public class DrzavaService {
	
	@Autowired
	DrzavaRepository drzavaRepo;
	
	public List<Drzava> listAll() {
		return (List<Drzava>) drzavaRepo.findAll();
	}
	
	public Drzava findByNaziv(String naziv) {
		return drzavaRepo.findByNaziv(naziv);
	}

}
