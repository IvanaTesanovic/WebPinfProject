package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banka")
public class Banka extends AbstractEntity {
	
	@Column(nullable = false)
	private String sifra_banke;
	
	@Column(nullable = false)
	private String pib;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private String adresa;
	
	@Column(nullable = true)
	private String telefon;
	
	@Column(nullable = true)
	private String email;
	
	@Column(nullable = true)
	private String sajt;
	
	@Column(nullable = true)
	private String fax;
	
	@Column(nullable = false)
	private Boolean banka;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "banka")
	private List<KursnaLista> kursneListe;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "banka")
	private List<Racun> racuni;
	
	public Banka() {}

	

	public String getSifra_banke() {
		return sifra_banke;
	}



	public void setSifra_banke(String sifra_banke) {
		this.sifra_banke = sifra_banke;
	}



	public String getPib() {
		return pib;
	}



	public void setPib(String pib) {
		this.pib = pib;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public String getTelefon() {
		return telefon;
	}



	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSajt() {
		return sajt;
	}



	public void setSajt(String sajt) {
		this.sajt = sajt;
	}



	public String getFax() {
		return fax;
	}



	public void setFax(String fax) {
		this.fax = fax;
	}



	public Boolean getBanka() {
		return banka;
	}



	public void setBanka(Boolean banka) {
		this.banka = banka;
	}



	public List<Racun> getRacuni() {
		return racuni;
	}



	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}



	public List<KursnaLista> getKursneListe() {
		return kursneListe;
	}

	public void setKursneListe(List<KursnaLista> kursneListe) {
		this.kursneListe = kursneListe;
	}
	
}
