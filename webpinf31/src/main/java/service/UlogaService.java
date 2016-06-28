package service;

import java.util.List;

import model.Uloga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.UlogaRepository;

@Service
@Transactional
public class UlogaService {

	@Autowired
	UlogaRepository ulogaRepo;
	
	public List<Uloga> listAll() {
		return (List<Uloga>) ulogaRepo.findAll();
	}
	
	public void save(Uloga uloga){
		ulogaRepo.save(uloga);
	}
	
	public void deleteRow(Long id) {
		ulogaRepo.delete(id);
	}
}
