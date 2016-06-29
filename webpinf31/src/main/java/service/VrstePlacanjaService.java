package service;

import java.util.List;
import model.VrstePlacanja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.VrstePlacanjaRepository;

@Service
@Transactional
public class VrstePlacanjaService {

	@Autowired
	VrstePlacanjaRepository vpRepo;
	
	public List<VrstePlacanja> listAll() {
		return (List<VrstePlacanja>) vpRepo.findAll();
	}
	
	public void save(VrstePlacanja vp){
		vpRepo.save(vp);
	}
	
	public void deleteRow(Long id) {
		vpRepo.delete(id);
	}
	
	 public VrstePlacanja findById(Long id){
		 return vpRepo.findOne(id);
	 }
}
