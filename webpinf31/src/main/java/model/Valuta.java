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
	private String id_valute;
	
	@Column(nullable = true)
	private String naziv;
	
	@Column(nullable = true)
	private Boolean domicilna;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "drzava")
	private Drzava drzava;
	
	
	public Valuta() {}


	public String getId_valute() {
		return id_valute;
	}

	public void setId_valute(String id_valute) {
		this.id_valute = id_valute;
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
