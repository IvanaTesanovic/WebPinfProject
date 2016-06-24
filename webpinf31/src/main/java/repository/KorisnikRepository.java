package repository;

import org.springframework.data.repository.CrudRepository;

import model.Korisnik;

public interface KorisnikRepository extends CrudRepository<Korisnik, Long> {
	
	public Korisnik findByKorisnickoIme(String korisnickoIme);

}
