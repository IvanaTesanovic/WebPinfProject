package service;

import java.util.List;

import model.Valuta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ValutaRepository;
@Service
public class ValutaService {
	
	@Autowired
	ValutaRepository valutaRepo;

	public List<Valuta> listAll() {
		return (List<Valuta>) valutaRepo.findAll();
	}
	
	public void deleteRow(Long id) {
		valutaRepo.delete(id);
	}
	
	 public Valuta findById(Long id){
		 return valutaRepo.findOne(id);
	 }
}
