package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Banka;
import repository.BankaRepository;

@Service
public class BankaService {
	
	@Autowired
	BankaRepository bankaRepo;
	
	public List<Banka> listAll() {
		return (List<Banka>) bankaRepo.findAll();
	}
	
	public void save(Banka banka){
		bankaRepo.save(banka);
	}
	
	public void deleteRow(Long id) {
		bankaRepo.delete(id);
	}

	public Banka findById(Long id) {
		return bankaRepo.findOne(id);
	}
	
}
