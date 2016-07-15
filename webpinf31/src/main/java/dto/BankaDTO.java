package dto;

import javax.persistence.Column;

public class BankaDTO {
	
	private String id;
	private String sifra;
	private String pib;
	private String naziv;
	private String adresa;
	private String telefon;
	private String email;
	private String web;
	private String fax;
	private String narodna_banka;
	private String obracunski;
	private String swift;
	
	public BankaDTO() {}

	public String getObracunski() {
		return obracunski;
	}

	public void setObracunski(String obracunski) {
		this.obracunski = obracunski;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public BankaDTO(String id, String sifra, String pib, String naziv, String adresa, String telefon, String email,
			String web, String fax, String narodna_banka, String obracunski, String swift) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.web = web;
		this.fax = fax;
		this.narodna_banka = narodna_banka;
		this.obracunski = obracunski;
		this.swift = swift;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getNarodna_banka() {
		return narodna_banka;
	}

	public void setNarodna_banka(String narodna_banka) {
		this.narodna_banka = narodna_banka;
	}
	
}
