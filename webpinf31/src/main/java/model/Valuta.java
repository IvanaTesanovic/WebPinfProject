package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "valuta")
public class Valuta extends AbstractEntity {

	@Column(nullable = true)
	private String sifra;
	
	@Column(nullable = true)
	private String naziv;
	
	@Column(nullable = true)
	private Boolean domicilna;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dr_sifra")
	private Drzava drzava;
	
	
	public Valuta() {}

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

	public Boolean getDomicilna() {
		return domicilna;
	}

	public void setDomicilna(Boolean domicilna) {
		this.domicilna = domicilna;
	}

		public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	} 
	}
