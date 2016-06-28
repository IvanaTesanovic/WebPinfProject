package service;

import java.util.List;

import model.Racun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.RacunRepository;

@Service
@Transactional
public class RacunService {

	@Autowired
	RacunRepository racunRepo;
	
	public List<Racun> listAll() {
		return (List<Racun>) racunRepo.findAll();
	}
	
	public void save(Racun racun){
		racunRepo.save(racun);
		
	}
	public void deleteRow(Long id) {
		racunRepo.delete(id);
	}

	 public Racun findById(Long id){
		 return racunRepo.findOne(id);
	 }
}
