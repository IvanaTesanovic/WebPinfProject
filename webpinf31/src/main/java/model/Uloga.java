package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "uloga")
public class Uloga extends AbstractEntity {
	
/*	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_korisnika")
	private Korisnik korisnik; */
	
	@Column(nullable = false, length = 255)
	private String uloga;
	
	public Uloga() {}
/*
	public Uloga(Korisnik korisnik, String uloga) {
		super();
		this.korisnik = korisnik;
		this.uloga = uloga;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	*/
}
