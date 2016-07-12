package repository;

import org.springframework.data.repository.CrudRepository;

import model.Drzava;

public interface DrzavaRepository extends CrudRepository<Drzava, Long> {
	
	public Drzava findByNaziv(String naziv);
	
}
