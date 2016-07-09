package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import model.AbstractEntity;

@Entity
@Table(name = "drzava")
public class Drzava extends AbstractEntity {
	
	@Column(nullable = false, unique = true)
	private String sifra;
	
	@Column(nullable = false)
	private String naziv;

	public Drzava() {}
	
	public Drzava(String sifra, String naziv) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
