package dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.DnevnoStanjeRacuna;
import model.NaseljenoMesto;
import model.Valuta;
import model.VrstePlacanja;

public class AnalitikaIzvodaDTO {

	public String duznik;
	public String poverilac;
	public String svrha_placanja;
	public String  datum_prijema;
	public String  datum_valute;
	public String racun_duznika;
	public String racun_poverioca;
	public String model_odobrenja;
	public String model_zaduzenja;
	public String poziv_na_broj_odobrenja;
	public String poziv_na_broj_zaduzenja;
	public String  hitno;
	public String  iznos;
	public Integer tip_greske;
	public String status;
	public String id_dnevnog_stanja_racuna;
	public String id_vrste_placanja;
	public String id_valute;
	public String id_naseljenog_mesta;
	
	public AnalitikaIzvodaDTO(){}

	public AnalitikaIzvodaDTO(String duznik, String poverilac,
			String svrha_placanja, String datum_prijema, String datum_valute,
			String racun_duznika, String racun_poverioca,
			String model_odobrenja, String model_zaduzenja,
			String poziv_na_broj_odobrenja, String poziv_na_broj_zaduzenja,
			String hitno, String iznos, Integer tip_greske, String status,
			String id_dnevnog_stanja_racuna, String id_vrste_placanja,
			String id_valute, String id_naseljenog_mesta) {
		super();
		this.duznik = duznik;
		this.poverilac = poverilac;
		this.svrha_placanja = svrha_placanja;
		this.datum_prijema = datum_prijema;
		this.datum_valute = datum_valute;
		this.racun_duznika = racun_duznika;
		this.racun_poverioca = racun_poverioca;
		this.model_odobrenja = model_odobrenja;
		this.model_zaduzenja = model_zaduzenja;
		this.poziv_na_broj_odobrenja = poziv_na_broj_odobrenja;
		this.poziv_na_broj_zaduzenja = poziv_na_broj_zaduzenja;
		this.hitno = hitno;
		this.iznos = iznos;
		this.tip_greske = tip_greske;
		this.status = status;
		this.id_dnevnog_stanja_racuna = id_dnevnog_stanja_racuna;
		this.id_vrste_placanja = id_vrste_placanja;
		this.id_valute = id_valute;
		this.id_naseljenog_mesta = id_naseljenog_mesta;
	}

	public String getDuznik() {
		return duznik;
	}

	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}

	public String getPoverilac() {
		return poverilac;
	}

	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}

	public String getSvrha_placanja() {
		return svrha_placanja;
	}

	public void setSvrha_placanja(String svrha_placanja) {
		this.svrha_placanja = svrha_placanja;
	}

	public String getDatum_prijema() {
		return datum_prijema;
	}

	public void setDatum_prijema(String datum_prijema) {
		this.datum_prijema = datum_prijema;
	}

	public String getDatum_valute() {
		return datum_valute;
	}

	public void setDatum_valute(String datum_valute) {
		this.datum_valute = datum_valute;
	}

	public String getRacun_duznika() {
		return racun_duznika;
	}

	public void setRacun_duznika(String racun_duznika) {
		this.racun_duznika = racun_duznika;
	}

	public String getRacun_poverioca() {
		return racun_poverioca;
	}

	public void setRacun_poverioca(String racun_poverioca) {
		this.racun_poverioca = racun_poverioca;
	}

	public String getModel_odobrenja() {
		return model_odobrenja;
	}

	public void setModel_odobrenja(String model_odobrenja) {
		this.model_odobrenja = model_odobrenja;
	}

	public String getModel_zaduzenja() {
		return model_zaduzenja;
	}

	public void setModel_zaduzenja(String model_zaduzenja) {
		this.model_zaduzenja = model_zaduzenja;
	}

	public String getPoziv_na_broj_odobrenja() {
		return poziv_na_broj_odobrenja;
	}

	public void setPoziv_na_broj_odobrenja(String poziv_na_broj_odobrenja) {
		this.poziv_na_broj_odobrenja = poziv_na_broj_odobrenja;
	}

	public String getPoziv_na_broj_zaduzenja() {
		return poziv_na_broj_zaduzenja;
	}

	public void setPoziv_na_broj_zaduzenja(String poziv_na_broj_zaduzenja) {
		this.poziv_na_broj_zaduzenja = poziv_na_broj_zaduzenja;
	}

	public String getHitno() {
		return hitno;
	}

	public void setHitno(String hitno) {
		this.hitno = hitno;
	}

	public String getIznos() {
		return iznos;
	}

	public void setIznos(String iznos) {
		this.iznos = iznos;
	}

	public Integer getTip_greske() {
		return tip_greske;
	}

	public void setTip_greske(Integer tip_greske) {
		this.tip_greske = tip_greske;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId_dnevnog_stanja_racuna() {
		return id_dnevnog_stanja_racuna;
	}

	public void setId_dnevnog_stanja_racuna(String id_dnevnog_stanja_racuna) {
		this.id_dnevnog_stanja_racuna = id_dnevnog_stanja_racuna;
	}

	public String getId_vrste_placanja() {
		return id_vrste_placanja;
	}

	public void setId_vrste_placanja(String id_vrste_placanja) {
		this.id_vrste_placanja = id_vrste_placanja;
	}

	public String getId_valute() {
		return id_valute;
	}

	public void setId_valute(String id_valute) {
		this.id_valute = id_valute;
	}

	public String getId_naseljenog_mesta() {
		return id_naseljenog_mesta;
	}

	public void setId_naseljenog_mesta(String id_naseljenog_mesta) {
		this.id_naseljenog_mesta = id_naseljenog_mesta;
	}
	
	
	
}
