package service;

import java.util.List;

import model.DnevnoStanjeRacuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.DnevnaStanjaRacunaRepository;

@Service
@Transactional
public class DnevnaStanjaRacunaService {
	
	@Autowired
	DnevnaStanjaRacunaRepository dnevnaStanjaRacunaRepo;
	
	public List<DnevnoStanjeRacuna> listAll() {
		return (List<DnevnoStanjeRacuna>) dnevnaStanjaRacunaRepo.findAll();
	}
	
	public void save(DnevnoStanjeRacuna dsr){
		dnevnaStanjaRacunaRepo.save(dsr);		
	}

	public void deleteRow(Long id) {
		dnevnaStanjaRacunaRepo.delete(id);
	}
	
	public DnevnoStanjeRacuna findById(Long id){
		return dnevnaStanjaRacunaRepo.findOne(id);
	}
	
}
