package repository;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Drzava;

public interface DrzavaRepository extends CrudRepository<Drzava, Long> {
	
	public Drzava findByNaziv(String naziv);
	
//	@Modifying(clearAutomatically = true)
//    @Query("select * from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = \'drzava\'")
//    List<Column> getColumns();

}
