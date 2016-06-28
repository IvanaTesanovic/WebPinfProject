package service;

import java.util.List;

import model.Kliring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.KliringRepository;

@Service
public class KliringService {
	
	@Autowired
	KliringRepository kliringRepo;
	
	public List<Kliring> listAll() {
		return (List<Kliring>) kliringRepo.findAll();
	}
	
	public void save(Kliring kliring){
		kliringRepo.save(kliring);
	}

	public void deleteRow(Long id) {
		kliringRepo.delete(id);
	}
}
