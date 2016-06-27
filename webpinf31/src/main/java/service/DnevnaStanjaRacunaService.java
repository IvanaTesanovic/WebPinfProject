package service;

import java.util.List;

import model.DnevnoStanjeRacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.DnevnaStanjaRacunaRepository;

@Service
public class DnevnaStanjaRacunaService {
	
	@Autowired
	DnevnaStanjaRacunaRepository dnevnaStanjaRacunaRepo;
	
	public List<DnevnoStanjeRacuna> listAll() {
		return (List<DnevnoStanjeRacuna>) dnevnaStanjaRacunaRepo.findAll();
	}
	
	public void deleteRow(Long id) {
		dnevnaStanjaRacunaRepo.delete(id);
	}
	
}
