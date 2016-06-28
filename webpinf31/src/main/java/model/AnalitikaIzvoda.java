package model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "analitika_izvoda")
public class AnalitikaIzvoda extends AbstractEntity {

	@Column(nullable = false)
	private String duznik;
	
	@Column(nullable = false)
	private String poverilac;
	
	@Column(nullable = false)
	private String svrha_placanja;
	
	@Column(nullable = false)
	private Date datum_prijema;
	
	@Column(nullable = false)
	private Date datum_valute;
	
	@Column(nullable = true)
	private String racun_duznika;
	
	@Column(nullable = true)
	private String racun_poverioca;
	
	@Column(nullable = true)
	private String model_odobrenja;
	
	@Column(nullable = true)
	private String model_zaduzenja;
	
	@Column(nullable = true)
	private String poziv_na_broj_odobrenja;
	
	@Column(nullable = true)
	private String poziv_na_broj_zaduzenja;
	
	@Column(nullable = false)
	private Boolean hitno;
	
	@Column(nullable = false)
	private Double iznos;
	
	@Column(nullable = false)
	private Integer tip_greske;
	
	@Column(nullable = true)
	private String status;
	
	/** STRANI KLJUCEVI **/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dnevnog_stanja_racuna")
	private DnevnoStanjeRacuna id_dnevnog_stanja_racuna;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vrste_placanja")
	private VrstePlacanja id_vrste_placanja;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_valute")
	private Valuta id_valute;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_naseljenog_mesta")
	private NaseljenoMesto id_naseljenog_mesta;
	
	
	public AnalitikaIzvoda() {}
	
	
	
	public AnalitikaIzvoda(String duznik, String poverilac,
			String svrha_placanja, Date datum_prijema, Date datum_valute,
			String racun_duznika, String racun_poverioca,
			String model_odobrenja, String model_zaduzenja,
			String poziv_na_broj_odobrenja, String poziv_na_broj_zaduzenja,
			Boolean hitno, Double iznos, Integer tip_greske, String status,
			DnevnoStanjeRacuna id_dnevnog_stanja_racuna,
			VrstePlacanja id_vrste_placanja, Valuta id_valute,
			NaseljenoMesto id_naseljenog_mesta) {
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


	public Date getDatum_prijema() {
		return datum_prijema;
	}


	public void setDatum_prijema(Date datum_prijema) {
		this.datum_prijema = datum_prijema;
	}


	public Date getDatum_valute() {
		return datum_valute;
	}


	public void setDatum_valute(Date datum_valute) {
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


	public Boolean getHitno() {
		return hitno;
	}


	public void setHitno(Boolean hitno) {
		this.hitno = hitno;
	}


	public Double getIznos() {
		return iznos;
	}


	public void setIznos(Double iznos) {
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

	public DnevnoStanjeRacuna getId_dnevnog_stanja_racuna() {
		return id_dnevnog_stanja_racuna;
	}

	public void setId_dnevnog_stanja_racuna(
			DnevnoStanjeRacuna id_dnevnog_stanja_racuna) {
		this.id_dnevnog_stanja_racuna = id_dnevnog_stanja_racuna;
	}

	public VrstePlacanja getId_vrste_placanja() {
		return id_vrste_placanja;
	}

	public void setId_vrste_placanja(VrstePlacanja id_vrste_placanja) {
		this.id_vrste_placanja = id_vrste_placanja;
	}

	public Valuta getId_valute() {
		return id_valute;
	}

	public void setId_valute(Valuta id_valute) {
		this.id_valute = id_valute;
	}

	public NaseljenoMesto getId_naseljenog_mesta() {
		return id_naseljenog_mesta;
	}

	public void setId_naseljenog_mesta(NaseljenoMesto id_naseljenog_mesta) {
		this.id_naseljenog_mesta = id_naseljenog_mesta;
	}

	
}
