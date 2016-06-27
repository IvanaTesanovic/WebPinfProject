package service;

import org.springframework.beans.factory.annotation.Autowired;

import repository.KlijentRepository;

public class KlijentService {

	@Autowired 
	KlijentRepository klijentRepo;
	
}
