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

	@Column(name = "fizicko_lice")
	private Boolean fizickoLice;
	
	@Column(name = "jmbg")
	private String jmbg;
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "adresa")
	private String adresa;
	
	@Column(name = "telefon")
	private String telefon;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "naziv_klijenta")
	private String naziv;
	
	@Column(name = "pib")
	private String pib;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "sajt")
	private String sajt;
	
	@Column(name = "sifra_delatnosti")
	private String sifraDelatnosti;
	
	@Column(name = "naziv_delatnosti")
	private String nazivDelatnosti;
	
	@Column(name = "odgovorno_lice")
	private String odgovornoLice;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "klijent")
	private List<Racun> racuni;
	
	public Klijent() {}

	public Boolean getFizickoLice() {
		return fizickoLice;
	}

	public void setFizickoLice(Boolean fizickoLice) {
		this.fizickoLice = fizickoLice;
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

	public String getSifraDelatnosti() {
		return sifraDelatnosti;
	}

	public void setSifraDelatnosti(String sifraDelatnosti) {
		this.sifraDelatnosti = sifraDelatnosti;
	}

	public String getNazivDelatnosti() {
		return nazivDelatnosti;
	}

	public void setNazivDelatnosti(String nazivDelatnosti) {
		this.nazivDelatnosti = nazivDelatnosti;
	}

	public String getOdgovornoLice() {
		return odgovornoLice;
	}

	public void setOdgovornoLice(String odgovornoLice) {
		this.odgovornoLice = odgovornoLice;
	}
	
}
