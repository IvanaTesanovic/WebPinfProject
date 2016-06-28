package service;

import java.util.List;

import model.Klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.KlijentRepository;

@Service
@Transactional
public class KlijentService {

	@Autowired 
	KlijentRepository klijentRepo;
	
	public List<Klijent> listAll() {
		return (List<Klijent>) klijentRepo.findAll();
	}
	
	public void save(Klijent k){
		klijentRepo.save(k);
	}
	
	public void deleteRow(Long id) {
		klijentRepo.delete(id);
	}
	
	 public Klijent findById(Long id){
		 return klijentRepo.findOne(id);
	 }
}
