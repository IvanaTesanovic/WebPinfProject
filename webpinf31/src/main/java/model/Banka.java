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
	
	@Column(name = "sifra_banke")
	private String sifra;
	
	@Column(name = "pr_pib")
	private String pib;
	
	@Column(name = "pr_naziv")
	private String naziv;
	
	@Column(name = "pr_adresa")
	private String adresa;
	
	@Column(name = "pr_telefon")
	private String telefon;
	
	@Column(name = "pr_email")
	private String email;
	
	@Column(name = "pr_web")
	private String web;
	
	@Column(name = "pr_fax")
	private String fax;
	
	@Column(name = "pr_banka")
	private Boolean jesteBanka;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "banka")
	private List<KursnaLista> kursneListe;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "banka")
	private List<Racun> racuni;
	
	public Banka() {}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
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

	public Boolean getJesteBanka() {
		return jesteBanka;
	}

	public void setJesteBanka(Boolean jesteBanka) {
		this.jesteBanka = jesteBanka;
	}

	public List<KursnaLista> getKursneListe() {
		return kursneListe;
	}

	public void setKursneListe(List<KursnaLista> kursneListe) {
		this.kursneListe = kursneListe;
	}
	
}
