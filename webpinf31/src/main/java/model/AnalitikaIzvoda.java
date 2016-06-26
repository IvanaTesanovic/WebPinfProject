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

	@Column(name = "ai_duznik")
	private String duznik;
	
	@Column(name = "ai_poverilac")
	private String poverilac;
	
	@Column(name = "ai_svrha_placanja")
	private String svrhaPlacanja;
	
	@Column(name = "ai_datum_prijema")
	private Date datumPrijema;
	
	@Column(name = "ai_datum_valute")
	private Date datumValute;
	
	@Column(name = "ai_racun_duznika")
	private String racunDuznika;
	
	@Column(name = "ai_racun_poverioca")
	private String racunPoverioca;
	
	@Column(name = "ai_model_odobrenja")
	private String modelOdobrenja;
	
	@Column(name = "ai_model_zaduzenja")
	private String modelZaduzenja;
	
	@Column(name = "ai_poziv_odobrenja")
	private String pozivOdobrenja;
	
	@Column(name = "ai_poziv_zaduzenja")
	private String pozivZaduzenja;
	
	@Column(name = "ai_hitno")
	private Boolean hitno;
	
	@Column(name = "ai_iznos")
	private Double iznos;
	
	@Column(name = "ai_tip_greske")
	private Integer tipGreske;
	
	@Column(name = "ai_status")
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

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public Date getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public String getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(String modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(String modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivOdobrenja() {
		return pozivOdobrenja;
	}

	public void setPozivOdobrenja(String pozivOdobrenja) {
		this.pozivOdobrenja = pozivOdobrenja;
	}

	public String getPozivZaduzenja() {
		return pozivZaduzenja;
	}

	public void setPozivZaduzenja(String pozivZaduzenja) {
		this.pozivZaduzenja = pozivZaduzenja;
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

	public Integer getTipGreske() {
		return tipGreske;
	}

	public void setTipGreske(Integer tipGreske) {
		this.tipGreske = tipGreske;
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
	
}
