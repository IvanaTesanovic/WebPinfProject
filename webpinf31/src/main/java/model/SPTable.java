package model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sp_table")
public class SPTable extends AbstractEntity {
	
	@Column
	private String id_poruke;
	
	@Column
	private String duznik;
	
	@Column
	private String poverilac;
	
	@Column
	private String svrha_placanja;
	
	@Column
	private Date datum_valute;
	
	@Column
	private String broj_racuna_duznika;
	@Column
	private String model_zaduzenja;
	@Column
	private String pnb_zaduzenja;
	
	@Column
	private String broj_racuna_poverioca;
	@Column
	private String model_odobrenja;
	@Column
	private String pnb_odobrenja;
	
	@Column
	private Boolean hitno;
	
	@Column
	private String oznaka_valute;
	
	@Column
	private BigDecimal iznos;
	
	@Column
	private Boolean ok;
	
	public SPTable() {}

	public String getId_poruke() {
		return id_poruke;
	}

	public void setId_poruke(String id_poruke) {
		this.id_poruke = id_poruke;
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

	public Date getDatum_valute() {
		return datum_valute;
	}

	public void setDatum_valute(Date datum_valute) {
		this.datum_valute = datum_valute;
	}

	public String getModel_zaduzenja() {
		return model_zaduzenja;
	}

	public void setModel_zaduzenja(String model_zaduzenja) {
		this.model_zaduzenja = model_zaduzenja;
	}

	public String getPnb_zaduzenja() {
		return pnb_zaduzenja;
	}

	public void setPnb_zaduzenja(String pnb_zaduzenja) {
		this.pnb_zaduzenja = pnb_zaduzenja;
	}

	public String getModel_odobrenja() {
		return model_odobrenja;
	}

	public void setModel_odobrenja(String model_odobrenja) {
		this.model_odobrenja = model_odobrenja;
	}

	public String getPnb_odobrenja() {
		return pnb_odobrenja;
	}

	public void setPnb_odobrenja(String pnb_odobrenja) {
		this.pnb_odobrenja = pnb_odobrenja;
	}

	public Boolean getHitno() {
		return hitno;
	}

	public void setHitno(Boolean hitno) {
		this.hitno = hitno;
	}

	public String getOznaka_valute() {
		return oznaka_valute;
	}

	public void setOznaka_valute(String oznaka_valute) {
		this.oznaka_valute = oznaka_valute;
	}

	public SPTable(String id_poruke, String duznik, String poverilac, String svrha_placanja, Date datum_valute,
			String broj_racuna_duznika, String model_zaduzenja, String pnb_zaduzenja, String broj_racuna_poverioca,
			String model_odobrenja, String pnb_odobrenja, Boolean hitno, String oznaka_valute, BigDecimal iznos,
			Boolean ok) {
		super();
		this.id_poruke = id_poruke;
		this.duznik = duznik;
		this.poverilac = poverilac;
		this.svrha_placanja = svrha_placanja;
		this.datum_valute = datum_valute;
		this.broj_racuna_duznika = broj_racuna_duznika;
		this.model_zaduzenja = model_zaduzenja;
		this.pnb_zaduzenja = pnb_zaduzenja;
		this.broj_racuna_poverioca = broj_racuna_poverioca;
		this.model_odobrenja = model_odobrenja;
		this.pnb_odobrenja = pnb_odobrenja;
		this.hitno = hitno;
		this.oznaka_valute = oznaka_valute;
		this.iznos = iznos;
		this.ok = ok;
	}



	public String getBroj_racuna_duznika() {
		return broj_racuna_duznika;
	}

	public void setBroj_racuna_duznika(String broj_racuna_duznika) {
		this.broj_racuna_duznika = broj_racuna_duznika;
	}

	public String getBroj_racuna_poverioca() {
		return broj_racuna_poverioca;
	}

	public void setBroj_racuna_poverioca(String broj_racuna_poverioca) {
		this.broj_racuna_poverioca = broj_racuna_poverioca;
	}

	public BigDecimal getIznos() {
		return iznos;
	}

	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	
}
