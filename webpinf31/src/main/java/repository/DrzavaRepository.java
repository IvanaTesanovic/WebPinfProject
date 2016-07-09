package repository;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.Drzava;

public interface DrzavaRepository extends CrudRepository<Drzava, Long> {
	
	public Drzava findByNaziv(String naziv);
	
}
