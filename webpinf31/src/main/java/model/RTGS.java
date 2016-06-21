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
	
	@Column(name = "rtgs_id_poruke")
	private String idPoruke;
	
	@Column(name = "rtgs_swift_duznika")
	private String swiftBankeDuznika;
	
	@Column(name = "rtgs_duznik")
	private String duznik;
	
	@Column(name = "rtgs_racun_duznika")
	private String racunDuznika;
	
	@Column(name = "rtgs_obracunski_duznika")
	private String obracunskiBankeDuznika;
	
	@Column(name = "rtgs_swift_poverioca")
	private String swiftBankePoverioca;
	
	@Column(name = "rtgs_poverilac")
	private String poverilac;
	
	@Column(name = "rtgs_racun_poverioca")
	private String racunPoverioca;
	
	@Column(name = "rtgs_obracunski_poverioca")
	private String obracunskiBankePoverioca;

	@Column(name = "rtgs_model_zaduzenja")
	private String modelZaduzenja;
	
	@Column(name = "rtgs_poziv_zaduzenja")
	private String pozivZaduzenja;
	
	@Column(name = "rtgs_model_odobrenja")
	private String modelOdobrenja;
	
	@Column(name = "rtgs_poziv_odobrenja")
	private String pozivOdobrenja;
	
	@Column(name = "rtgs_svrha_placanja")
	private String svrhaPlacanja;
	
	@Column(name = "rtgs_datum_naloga")
	private Date datumNaloga;
	
	@Column(name = "rtgs_sifra_valute")
	private String sifraValute;
	
	@Column(name = "rtgs_datum_valute")
	private Date datumValute;
	
	@Column(name = "rtgs_ukupan_iznos")
	private Double ukupanIznos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rtgs_ai_id")
	private AnalitikaIzvoda analitikaIzvoda;
	
	public RTGS() {}

	public String getIdPoruke() {
		return idPoruke;
	}

	public void setIdPoruke(String idPoruke) {
		this.idPoruke = idPoruke;
	}

	public String getSwiftBankeDuznika() {
		return swiftBankeDuznika;
	}

	public void setSwiftBankeDuznika(String swiftBankeDuznika) {
		this.swiftBankeDuznika = swiftBankeDuznika;
	}

	public String getDuznik() {
		return duznik;
	}

	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}

	public String getRacunDuznika() {
		return racunDuznika;
	}

	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}

	public String getObracunskiBankeDuznika() {
		return obracunskiBankeDuznika;
	}

	public void setObracunskiBankeDuznika(String obracunskiBankeDuznika) {
		this.obracunskiBankeDuznika = obracunskiBankeDuznika;
	}

	public String getSwiftBankePoverioca() {
		return swiftBankePoverioca;
	}

	public void setSwiftBankePoverioca(String swiftBankePoverioca) {
		this.swiftBankePoverioca = swiftBankePoverioca;
	}

	public String getPoverilac() {
		return poverilac;
	}

	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}

	public String getRacunPoverioca() {
		return racunPoverioca;
	}

	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}

	public String getObracunskiBankePoverioca() {
		return obracunskiBankePoverioca;
	}

	public void setObracunskiBankePoverioca(String obracunskiBankePoverioca) {
		this.obracunskiBankePoverioca = obracunskiBankePoverioca;
	}

	public String getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(String modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public String getPozivZaduzenja() {
		return pozivZaduzenja;
	}

	public void setPozivZaduzenja(String pozivZaduzenja) {
		this.pozivZaduzenja = pozivZaduzenja;
	}

	public String getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(String modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public String getPozivOdobrenja() {
		return pozivOdobrenja;
	}

	public void setPozivOdobrenja(String pozivOdobrenja) {
		this.pozivOdobrenja = pozivOdobrenja;
	}

	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public Date getDatumNaloga() {
		return datumNaloga;
	}

	public void setDatumNaloga(Date datumNaloga) {
		this.datumNaloga = datumNaloga;
	}

	public String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public Double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(Double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}
}
