package service;

import java.util.List;

import model.AnalitikaIzvoda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.AnalitikaIzvodaRepository;

@Service
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

}
