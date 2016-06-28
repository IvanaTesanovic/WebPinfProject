package service;

import java.util.List;

import model.AnalitikaIzvoda;
import model.Drzava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.AnalitikaIzvodaRepository;

@Service
@Transactional
public class AnalitikaIzvodaService {
	
	@Autowired
	AnalitikaIzvodaRepository analitikaIzvodaRepo;
	
	public List<AnalitikaIzvoda> listAll() {
		return (List<AnalitikaIzvoda>) analitikaIzvodaRepo.findAll();
	}
	
	public void save(AnalitikaIzvoda ai){
		analitikaIzvodaRepo.save(ai);
	}
	
	public void deleteRow(Long id) {
		analitikaIzvodaRepo.delete(id);
	}

	public AnalitikaIzvoda findById(Long id) {
		return analitikaIzvodaRepo.findOne(id);
	}
}
