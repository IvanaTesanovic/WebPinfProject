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
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private String ptt_oznaka;
	
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


	public String getPtt_oznaka() {
		return ptt_oznaka;
	}

	public void setPtt_oznaka(String ptt_oznaka) {
		this.ptt_oznaka = ptt_oznaka;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
	
}
