package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "korisnik")
public class Korisnik extends AbstractEntity {
	
	private String korisnickoIme;
	private String lozinka;
	
	public Korisnik() {}

	public Korisnik(String korisnickoIme, String lozinka) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
}
