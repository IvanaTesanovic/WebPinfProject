package dto;

import javax.persistence.Column;

public class BankaDTO {
	
	private String id;
	private String pib;
	private String naziv;
	private String adresa;
	private String telefon;
	private String email;
	private String web;
	private String fax;
	private String narodna_banka;
	
	public BankaDTO() {}

	public BankaDTO(String id, String pib, String naziv, String adresa, String telefon, String email, String web,
			String fax, String narodna_banka) {
		super();
		this.id = id;
		this.pib = pib;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.web = web;
		this.fax = fax;
		this.narodna_banka = narodna_banka;
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
