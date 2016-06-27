package service;

import java.util.List;

import model.Uloga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.UlogaRepository;

@Service
public class UlogaService {

	@Autowired
	UlogaRepository ulogaRepo;
	
	public List<Uloga> listAll() {
		return (List<Uloga>) ulogaRepo.findAll();
	}
	
	public void deleteRow(Long id) {
		ulogaRepo.delete(id);
	}
}
