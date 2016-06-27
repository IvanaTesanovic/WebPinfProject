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
@Table(name = "naseljeno_mesto")
public class NaseljenoMesto extends AbstractEntity {
	
	@Column(nullable = true)
	private String naziv;
	
	@Column(nullable = true)
	private String ptt_oznaka;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sifra_drzave")
	private Drzava drzava; 

	
	public NaseljenoMesto() {}



	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPttOznaka() {
		return ptt_oznaka;
	}

	public void setPttOznaka(String pttOznaka) {
		this.ptt_oznaka = pttOznaka;
	}


	public Drzava getDrzava() {
		return drzava;
	}


	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	
	
}
