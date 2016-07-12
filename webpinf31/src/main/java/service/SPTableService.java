package service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.SPTable;
import repository.SPTableRepository;

@Service
@Transactional
public class SPTableService {
	
	@Autowired
	SPTableRepository repo;
	
	public void save(SPTable t) {
		repo.save(t);
	}

}
