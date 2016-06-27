package service;

import java.util.List;

import model.Valuta;

import org.springframework.beans.factory.annotation.Autowired;

import repository.ValutaRepository;

public class ValutaService {
	
	@Autowired
	ValutaRepository valutaRepo;

	public List<Valuta> listAll() {
		return (List<Valuta>) valutaRepo.findAll();
	}
	
	public void deleteRow(Long id) {
		valutaRepo.delete(id);
	}
}
