package model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "racun")
public class Racun extends AbstractEntity {
	
	
	@Column(nullable = true)
	private String broj_racuna;
	
	@Column(nullable = true)
	private Date datum_otvaranja;
	
	@Column(nullable = true)
	private Boolean vazeci;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "banka")
	private Banka banka;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "valuta")
	private Valuta valuta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "klijent")
	private Klijent klijent;
	
	
	public Racun() {}


	public String getBroj_racuna() {
		return broj_racuna;
	}


	public void setBroj_racuna(String broj_racuna) {
		this.broj_racuna = broj_racuna;
	}


	public Date getDatum_otvaranja() {
		return datum_otvaranja;
	}


	public void setDatum_otvaranja(Date datum_otvaranja) {
		this.datum_otvaranja = datum_otvaranja;
	}


	public Boolean getVazeci() {
		return vazeci;
	}


	public void setVazeci(Boolean vazeci) {
		this.vazeci = vazeci;
	}


	public Banka getBanka() {
		return banka;
	}


	public void setBanka(Banka banka) {
		this.banka = banka;
	}


	public Valuta getValuta() {
		return valuta;
	}


	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}


	public Klijent getKlijent() {
		return klijent;
	}


	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	
	
	
}
