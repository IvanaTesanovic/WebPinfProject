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
	
	@Column(nullable = true)
	private String sifra_banke;
	
	@Column(nullable = true)
	private String pib;
	
	@Column(nullable = true)
	private String naziv;
	
	@Column(nullable = true)
	private String adresa;
	
	@Column(nullable = true)
	private String telefon;
	
	@Column(nullable = true)
	private String email;
	
	@Column(nullable = true)
	private String web;
	
	@Column(nullable = true)
	private String fax;
	
	@Column(nullable = true)
	private Boolean narodna_banka;
	
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Boolean getJeste_banka() {
		return narodna_banka;
	}

	public void setJeste_banka(Boolean narodna_banka) {
		this.narodna_banka = narodna_banka;
	}

}
