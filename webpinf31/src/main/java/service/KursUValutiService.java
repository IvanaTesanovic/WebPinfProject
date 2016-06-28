package service;

import java.util.List;

import model.KursUValuti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.KursUValutiRepository;

@Service
public class KursUValutiService {

	@Autowired
	KursUValutiRepository kursUValutiRepo;
	
	public List<KursUValuti> listAll() {
		return (List<KursUValuti>) kursUValutiRepo.findAll();
	}
	
	public void save(KursUValuti kursUValuti){
		kursUValutiRepo.save(kursUValuti);
	}
	
	public void deleteRow(Long id) {
		kursUValutiRepo.delete(id);
	}
}
