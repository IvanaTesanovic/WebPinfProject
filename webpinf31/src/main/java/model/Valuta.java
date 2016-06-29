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
	@JoinColumn(name = "id_drzave")
	private Drzava id_drzave;
	
	
	public Valuta() {}

	public Valuta(String id_valute, String naziv, Boolean domicilna,
			Drzava id_drzave) {
		super();
		this.id_valute = id_valute;
		this.naziv = naziv;
		this.domicilna = domicilna;
		this.id_drzave = id_drzave;
	}



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


	public Drzava getId_drzave() {
		return id_drzave;
	}


	public void setId_drzave(Drzava id_drzave) {
		this.id_drzave = id_drzave;
	}

}
