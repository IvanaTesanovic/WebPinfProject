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
	
	@Column(name = "nm_naziv")
	private String naziv;
	
	@Column(name = "nm_pttoznaka")
	private String pttOznaka;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dr_sifra")
	private Drzava drzava;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "naseljenoMesto")
	private List<AnalitikaIzvoda> analitikeIzvoda;
	
	public NaseljenoMesto() {}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPttOznaka() {
		return pttOznaka;
	}

	public void setPttOznaka(String pttOznaka) {
		this.pttOznaka = pttOznaka;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
	
}
