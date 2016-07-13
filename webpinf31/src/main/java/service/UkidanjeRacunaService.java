package service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.UkidanjeRacuna;
import repository.UkidanjeRacunaRepository;

@Service
@Transactional
public class UkidanjeRacunaService {
	
	@Autowired
	UkidanjeRacunaRepository repo;
	
	public void save(UkidanjeRacuna ur) {
		repo.save(ur);
	}

}
