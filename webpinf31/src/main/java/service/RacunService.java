package service;

import java.util.List;

import model.Racun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.RacunRepository;

@Service
public class RacunService {

	@Autowired
	RacunRepository racunRepo;
	
	public List<Racun> listAll() {
		return (List<Racun>) racunRepo.findAll();
	}
	
	public void deleteRow(Long id) {
		racunRepo.delete(id);
	}
}
