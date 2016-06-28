package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.NaseljenoMestoDTO;
import model.NaseljenoMesto;
import repository.NaseljenoMestoRepository;

@Service
@Transactional
public class NaseljenoMestoService {
	
	@Autowired
	NaseljenoMestoRepository nasMestoRepo;
	
	public List<NaseljenoMesto> listAll() {
		return (List<NaseljenoMesto>) nasMestoRepo.findAll();
	}
	
	public void save(NaseljenoMesto nm){
		nasMestoRepo.save(nm);
	}
	public void deleteRow(Long id) {
		nasMestoRepo.delete(id);
	}
	
	 public NaseljenoMesto findById(Long id){
		 return nasMestoRepo.findOne(id);
	 }
}
