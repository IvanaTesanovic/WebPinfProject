package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Banka;
import repository.BankaRepository;

@Service
@Transactional
public class BankaService {

	@Autowired
	BankaRepository bankaRepo;

	public List<Banka> listAll() {
		return (List<Banka>) bankaRepo.findAll();
	}

	public void save(Banka banka) {
		bankaRepo.save(banka);
	}

	public void deleteRow(Long id) {
		bankaRepo.delete(id);
	}

	public Banka findById(Long id) {
		return bankaRepo.findOne(id);
	}

	public void update(Long id, String pib, String naziv, String adresa, String telefon, String email, String web,
			String fax, Boolean nb) {
		Banka banka = bankaRepo.findOne(id);
		banka.setAdresa(adresa);
		banka.setEmail(email);
		banka.setFax(fax);
		banka.setNarodna_banka(nb);
		banka.setNaziv(naziv);
		banka.setPib(pib);
		banka.setTelefon(telefon);
		banka.setWeb(web);
		bankaRepo.save(banka);
	}

}
