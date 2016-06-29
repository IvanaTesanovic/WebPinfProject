package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "korisnik")
public class Korisnik extends AbstractEntity {
	
	@Column(name = "korisnicko_ime")
	private String korisnickoIme;
	
	private String lozinka;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "korisnik")
	private List<Uloga> uloge;
	
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
	
	public List<Uloga> getUloge() {
		return uloge;
	}

	public void setUloge(List<Uloga> uloge) {
		this.uloge = uloge;
	}
	
}
