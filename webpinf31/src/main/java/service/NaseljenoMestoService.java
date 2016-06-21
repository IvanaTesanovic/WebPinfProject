package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.NaseljenoMesto;
import repository.NaseljenoMestoRepository;

@Service
public class NaseljenoMestoService {
	
	@Autowired
	NaseljenoMestoRepository nasMestoRepo;

	public List<NaseljenoMesto> listAll() {
		return (List<NaseljenoMesto>) nasMestoRepo.findAll();
	}
	
}
