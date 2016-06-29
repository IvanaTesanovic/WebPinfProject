package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.NaseljenoMestoDTO;
import model.Drzava;
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
	 
	 public void update(Long id, String naziv, String ptt_oznaka, Drzava id_drzave){
		 NaseljenoMesto nm = nasMestoRepo.findOne(id);
		 nm.setNaziv(naziv);
		 nm.setPtt_oznaka(ptt_oznaka);
		 nm.setId_drzave(id_drzave);
		 nasMestoRepo.save(nm);
	 }
}
