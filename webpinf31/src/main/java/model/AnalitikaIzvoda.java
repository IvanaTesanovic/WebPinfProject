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
	private String duznik_nalogodavac;
	
	@Column(nullable = false)
	private String poverilac_primalac;
	
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
	private String poziv_broj_odobrenja;
	
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
	@JoinColumn(name = "ai_id_dsr")
	private DnevnoStanjeRacuna dsr;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ai_id_vpl")
	private VrstePlacanja vpl;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ai_id_valute")
	private Valuta valuta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ai_id_nm")
	private NaseljenoMesto naseljenoMesto;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "analitikaIzvoda")
	private List<RTGS> rtgsovi;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "analitikaIzvoda")
	private List<RTGS> grupeIzvoda;
	
	public AnalitikaIzvoda() {}

	

	public String getDuznik_nalogodavac() {
		return duznik_nalogodavac;
	}



	public void setDuznik_nalogodavac(String duznik_nalogodavac) {
		this.duznik_nalogodavac = duznik_nalogodavac;
	}



	public String getPoverilac_primalac() {
		return poverilac_primalac;
	}



	public void setPoverilac_primalac(String poverilac_primalac) {
		this.poverilac_primalac = poverilac_primalac;
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

	public String getPoziv_broj_odobrenja() {
		return poziv_broj_odobrenja;
	}

	public void setPoziv_broj_odobrenja(String poziv_broj_odobrenja) {
		this.poziv_broj_odobrenja = poziv_broj_odobrenja;
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

	public DnevnoStanjeRacuna getDsr() {
		return dsr;
	}

	public void setDsr(DnevnoStanjeRacuna dsr) {
		this.dsr = dsr;
	}

	public VrstePlacanja getVpl() {
		return vpl;
	}

	public void setVpl(VrstePlacanja vpl) {
		this.vpl = vpl;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	public List<RTGS> getRtgsovi() {
		return rtgsovi;
	}

	public void setRtgsovi(List<RTGS> rtgsovi) {
		this.rtgsovi = rtgsovi;
	}

	public List<RTGS> getGrupeIzvoda() {
		return grupeIzvoda;
	}

	public void setGrupeIzvoda(List<RTGS> grupeIzvoda) {
		this.grupeIzvoda = grupeIzvoda;
	}

	
}
