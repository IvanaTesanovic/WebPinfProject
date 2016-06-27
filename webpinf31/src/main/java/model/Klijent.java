package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "klijent")
public class Klijent extends AbstractEntity {

	@Column(nullable = true)
	private Boolean fizicko_lice;
	
	@Column(nullable = true)
	private String jmbg;
	
	@Column(nullable = true)
	private String ime;
	
	@Column(nullable = true)
	private String prezime;
	
	@Column(nullable = true)
	private String adresa;
	
	@Column(nullable = true)
	private String telefon;
	
	@Column(nullable = true)
	private String email;
	
	@Column(nullable = true)
	private String naziv;
	
	@Column(nullable = true)
	private String pib;
	
	@Column(nullable = true)
	private String fax;
	
	@Column(nullable = true)
	private String sajt;
	
	@Column(nullable = true)
	private String sifra_delatnosti;
	
	@Column(nullable = true)
	private String naziv_delatnosti;
	
	@Column(nullable = true)
	private String odgovorno_lice;
	
		
	public Klijent() {}


	public Boolean getFizicko_lice() {
		return fizicko_lice;
	}


	public void setFizicko_lice(Boolean fizicko_lice) {
		this.fizicko_lice = fizicko_lice;
	}


	public String getJmbg() {
		return jmbg;
	}


	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
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


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getPib() {
		return pib;
	}


	public void setPib(String pib) {
		this.pib = pib;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getSajt() {
		return sajt;
	}


	public void setSajt(String sajt) {
		this.sajt = sajt;
	}


	public String getSifra_delatnosti() {
		return sifra_delatnosti;
	}


	public void setSifra_delatnosti(String sifra_delatnosti) {
		this.sifra_delatnosti = sifra_delatnosti;
	}


	public String getNaziv_delatnosti() {
		return naziv_delatnosti;
	}


	public void setNaziv_delatnosti(String naziv_delatnosti) {
		this.naziv_delatnosti = naziv_delatnosti;
	}


	public String getOdgovorno_lice() {
		return odgovorno_lice;
	}


	public void setOdgovorno_lice(String odgovorno_lice) {
		this.odgovorno_lice = odgovorno_lice;
	}

	
}
