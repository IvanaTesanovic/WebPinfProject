package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rtgs")
public class RTGS extends AbstractEntity {
	
	@Column(nullable = true)
	private String id_poruke;
	
	@Column(nullable = true)
	private String swift_banke_duznika;
	
	@Column(nullable = true)
	private String duznik;
	
	@Column(nullable = true)
	private String racun_duznika;
	
	@Column(nullable = true)
	private String obracunski_racun_banke_duznika;
	
	@Column(nullable = true)
	private String swift_banke_poverioca;
	
	@Column(nullable = true)
	private String poverilac;
	
	@Column(nullable = true)
	private String racun_poverioca;
	
	@Column(nullable = true)
	private String obracunski_racun_banke_poverioca;

	@Column(nullable = true)
	private String model_zaduzenja;
	
	@Column(nullable = true)
	private String poziv_na_broj_zaduzenja;
	
	@Column(nullable = true)
	private String model_odobrenja;
	
	@Column(nullable = true)
	private String poziv_na_broj_odobrenja;
	
	@Column(nullable = true)
	private String svrha_placanja;
	
	@Column(nullable = true)
	private Date datum_naloga;
	
	@Column(nullable = true)
	private String sifra_valute;
	
	@Column(nullable = true)
	private Date datum_valute;
	
	@Column(nullable = true)
	private Double ukupan_iznos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_analitike_izvoda")
	private AnalitikaIzvoda analitika_izvoda;
	
	public RTGS() {}

	public String getId_poruke() {
		return id_poruke;
	}

	public void setId_poruke(String id_poruke) {
		this.id_poruke = id_poruke;
	}

	public String getSwift_banke_duznika() {
		return swift_banke_duznika;
	}

	public void setSwift_banke_duznika(String swift_banke_duznika) {
		this.swift_banke_duznika = swift_banke_duznika;
	}

	public String getDuznik() {
		return duznik;
	}

	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}

	public String getRacun_duznika() {
		return racun_duznika;
	}

	public void setRacun_duznika(String racun_duznika) {
		this.racun_duznika = racun_duznika;
	}

	public String getObracunski_racun_banke_duznika() {
		return obracunski_racun_banke_duznika;
	}

	public void setObracunski_racun_banke_duznika(
			String obracunski_racun_banke_duznika) {
		this.obracunski_racun_banke_duznika = obracunski_racun_banke_duznika;
	}

	public String getSwift_banke_poverioca() {
		return swift_banke_poverioca;
	}

	public void setSwift_banke_poverioca(String swift_banke_poverioca) {
		this.swift_banke_poverioca = swift_banke_poverioca;
	}

	public String getPoverilac() {
		return poverilac;
	}

	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}

	public String getRacun_poverioca() {
		return racun_poverioca;
	}

	public void setRacun_poverioca(String racun_poverioca) {
		this.racun_poverioca = racun_poverioca;
	}

	public String getObracunski_racun_banke_poverioca() {
		return obracunski_racun_banke_poverioca;
	}

	public void setObracunski_racun_banke_poverioca(
			String obracunski_racun_banke_poverioca) {
		this.obracunski_racun_banke_poverioca = obracunski_racun_banke_poverioca;
	}

	public String getModel_zaduzenja() {
		return model_zaduzenja;
	}

	public void setModel_zaduzenja(String model_zaduzenja) {
		this.model_zaduzenja = model_zaduzenja;
	}

	public String getPoziv_na_broj_zaduzenja() {
		return poziv_na_broj_zaduzenja;
	}

	public void setPoziv_na_broj_zaduzenja(String poziv_na_broj_zaduzenja) {
		this.poziv_na_broj_zaduzenja = poziv_na_broj_zaduzenja;
	}

	public String getModel_odobrenja() {
		return model_odobrenja;
	}

	public void setModel_odobrenja(String model_odobrenja) {
		this.model_odobrenja = model_odobrenja;
	}

	public String getPoziv_na_broj_odobrenja() {
		return poziv_na_broj_odobrenja;
	}

	public void setPoziv_na_broj_odobrenja(String poziv_na_broj_odobrenja) {
		this.poziv_na_broj_odobrenja = poziv_na_broj_odobrenja;
	}

	public String getSvrha_placanja() {
		return svrha_placanja;
	}

	public void setSvrha_placanja(String svrha_placanja) {
		this.svrha_placanja = svrha_placanja;
	}

	public Date getDatum_naloga() {
		return datum_naloga;
	}

	public void setDatum_naloga(Date datum_naloga) {
		this.datum_naloga = datum_naloga;
	}

	public String getSifra_valute() {
		return sifra_valute;
	}

	public void setSifra_valute(String sifra_valute) {
		this.sifra_valute = sifra_valute;
	}

	public Date getDatum_valute() {
		return datum_valute;
	}

	public void setDatum_valute(Date datum_valute) {
		this.datum_valute = datum_valute;
	}

	public Double getUkupan_iznos() {
		return ukupan_iznos;
	}

	public void setUkupan_iznos(Double ukupan_iznos) {
		this.ukupan_iznos = ukupan_iznos;
	}

	public AnalitikaIzvoda getAnalitika_izvoda() {
		return analitika_izvoda;
	}

	public void setAnalitika_izvoda(AnalitikaIzvoda analitika_izvoda) {
		this.analitika_izvoda = analitika_izvoda;
	}

}
