package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.AbstractEntity;

@Entity
@Table(name = "drzava")
public class Drzava extends AbstractEntity {
	
	@Column
	private String naziv;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "drzava")
	private List<NaseljenoMesto> naseljenaMesta;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "drzava")
	private List<Valuta> valute;
	
	public Drzava() {}
	
	public Drzava(String naziv, List<NaseljenoMesto> naseljenaMesta, List<Valuta> valute) {
		super();
		this.naziv = naziv;
		this.naseljenaMesta = naseljenaMesta;
		this.valute = valute;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<NaseljenoMesto> getNaseljenaMesta() {
		return naseljenaMesta;
	}

	public void setNaseljenaMesta(List<NaseljenoMesto> naseljenaMesta) {
		this.naseljenaMesta = naseljenaMesta;
	}
	
}
