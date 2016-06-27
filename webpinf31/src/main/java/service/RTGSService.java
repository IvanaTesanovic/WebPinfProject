package service;

import java.util.List;

import model.RTGS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.RTGSRepository;

@Service
public class RTGSService {

	@Autowired
	RTGSRepository rtgsRepo;
	
	public List<RTGS> listAll() {
		return (List<RTGS>) rtgsRepo.findAll();
	}
	
	public void deleteRow(Long id) {
		rtgsRepo.delete(id);
	}
}