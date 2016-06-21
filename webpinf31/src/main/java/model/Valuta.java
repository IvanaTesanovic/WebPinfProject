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

	@Column(name = "va_sifra")
	private String sifra;
	
	@Column(name = "va_naziv")
	private String naziv;
	
	@Column(name = "va_domicilna")
	private Boolean domicilna;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dr_sifra")
	private Drzava drzava;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "valuta")
	private List<KursUValuti> kursevi;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "valuta")
	private List<AnalitikaIzvoda> analitikeIzvoda;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "valuta")
	private List<Racun> racuni;
	
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

	public List<KursUValuti> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<KursUValuti> kursevi) {
		this.kursevi = kursevi;
	}
}
