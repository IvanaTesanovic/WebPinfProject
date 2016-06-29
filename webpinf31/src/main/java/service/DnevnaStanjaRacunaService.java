package service;

import java.sql.Date;
import java.util.List;

import model.DnevnoStanjeRacuna;
import model.Racun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.DnevnaStanjaRacunaRepository;

@Service
@Transactional
public class DnevnaStanjaRacunaService {
	
	@Autowired
	DnevnaStanjaRacunaRepository dnevnaStanjaRacunaRepo;
	
	public List<DnevnoStanjeRacuna> listAll() {
		return (List<DnevnoStanjeRacuna>) dnevnaStanjaRacunaRepo.findAll();
	}
	
	public void save(DnevnoStanjeRacuna dsr){
		dnevnaStanjaRacunaRepo.save(dsr);		
	}

	public void deleteRow(Long id) {
		dnevnaStanjaRacunaRepo.delete(id);
	}
	
	public DnevnoStanjeRacuna findById(Long id){
		return dnevnaStanjaRacunaRepo.findOne(id);
	}
	
	public void update(Long id,Date datum_prometa, Double promet_u_korist,
			Double prethodno_stanje, Double promet_na_teret,
			Double novo_stanje, Racun id_racuna){
		
		DnevnoStanjeRacuna dsRacuna = dnevnaStanjaRacunaRepo.findOne(id);
		dsRacuna.setDatum_prometa(datum_prometa);
		dsRacuna.setPromet_u_korist(promet_u_korist);
		dsRacuna.setPromet_na_teret(promet_na_teret);
		dsRacuna.setPromet_na_teret(promet_na_teret);
		dsRacuna.setNovo_stanje(novo_stanje);
		dsRacuna.setId_racuna(id_racuna);
		dnevnaStanjaRacunaRepo.save(dsRacuna);
		
	}
	
}
