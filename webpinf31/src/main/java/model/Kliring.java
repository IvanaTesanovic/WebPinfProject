package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kliring")
public class Kliring extends AbstractEntity {
	
	@Column(nullable = true)
	private String id_poruke;
	
	@Column(nullable = true)
	private String swift_banke_duznika;
	
	@Column(nullable = true)
	private String obracunski_racun_banke_duznika;
	
	@Column(nullable = true)
	private String swift_banke_poverioca;
	
	@Column(nullable = true)
	private String obracunski_racun_banke_poverioca;
	
	@Column(nullable = true)
	private Date datum_naloga;
	
	@Column(nullable = true)
	private String sifra_valute;
	
	@Column(nullable = true)
	private Date datum_valute;
	
	@Column(nullable = true)
	private Double ukupan_iznos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_grupe_izvoda")
	private GrupaIzvoda grupa_izvoda;
	
	public Kliring() {}

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

	public String getObracunski_racun_banke_poverioca() {
		return obracunski_racun_banke_poverioca;
	}

	public void setObracunski_racun_banke_poverioca(
			String obracunski_racun_banke_poverioca) {
		this.obracunski_racun_banke_poverioca = obracunski_racun_banke_poverioca;
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

	public GrupaIzvoda getGrupa_izvoda() {
		return grupa_izvoda;
	}

	public void setGrupa_izvoda(GrupaIzvoda grupa_izvoda) {
		this.grupa_izvoda = grupa_izvoda;
	}

	
	
}
