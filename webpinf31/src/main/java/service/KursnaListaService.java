package service;

import java.util.List;

import model.KursnaLista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.KursnaListaRepository;

@Service
public class KursnaListaService {
	
	@Autowired
	KursnaListaRepository kursnaListaRepo;
	
	public List<KursnaLista> listAll() {
		return (List<KursnaLista>) kursnaListaRepo.findAll();
	}
	
	public void save(KursnaLista kl){
		kursnaListaRepo.save(kl);
	}	
	public void deleteRow(Long id) {
		kursnaListaRepo.delete(id);
	}
	
	 public KursnaLista findById(Long id){
		 return kursnaListaRepo.findOne(id);
	 }

}
