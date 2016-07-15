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

	@Column(nullable = false, unique = false)
	private String sifra;
	
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
	private String web;
	
	@Column(nullable = true)
	private String fax;
	
	@Column(nullable = false)
	private Boolean narodna_banka;
	
	@Column(nullable = false)
	private String obracunski_racun;
	
	@Column(nullable = false)
	private String swift_kod;
	
	public Banka() {}
	
	public String getObracunski_racun() {
		return obracunski_racun;
	}

	public void setObracunski_racun(String obracunski_racun) {
		this.obracunski_racun = obracunski_racun;
	}

	public String getSwift_kod() {
		return swift_kod;
	}

	public void setSwift_kod(String swift_kod) {
		this.swift_kod = swift_kod;
	}

	public Banka(String sifra, String pib, String naziv, String adresa, String telefon, String email, String web,
			String fax, Boolean narodna_banka, String obracunski_racun, String swift_kod) {
		super();
		this.sifra = sifra;
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.web = web;
		this.fax = fax;
		this.narodna_banka = narodna_banka;
		this.obracunski_racun = obracunski_racun;
		this.swift_kod = swift_kod;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Boolean getNarodna_banka() {
		return narodna_banka;
	}

	public void setNarodna_banka(Boolean narodna_banka) {
		this.narodna_banka = narodna_banka;
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


}
