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
	
	@Column(name = "klir_id_poruke")
	private String idPoruke;
	
	@Column(name = "klir_swift_duznika")
	private String swiftBankeDuznika;
	
	@Column(name = "klir_obracunski_duznika")
	private String obracunskiBankeDuznika;
	
	@Column(name = "klir_swift_poverioca")
	private String swiftBankePoverioca;
	
	@Column(name = "klir_obracunski_poverioca")
	private String obracunskiBankePoverioca;
	
	@Column(name = "klir_datum_naloga")
	private Date datumNaloga;
	
	@Column(name = "klir_sifra_valute")
	private String sifraValute;
	
	@Column(name = "klir_datum_valute")
	private Date datumValute;
	
	@Column(name = "klir_ukupan_iznos")
	private Double ukupanIznos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "klir_gi_id")
	private GrupaIzvoda grupaIzvoda;
	
	public Kliring() {}

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

	public String getObracunskiBankePoverioca() {
		return obracunskiBankePoverioca;
	}

	public void setObracunskiBankePoverioca(String obracunskiBankePoverioca) {
		this.obracunskiBankePoverioca = obracunskiBankePoverioca;
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

	public GrupaIzvoda getGrupaIzvoda() {
		return grupaIzvoda;
	}

	public void setGrupaIzvoda(GrupaIzvoda grupaIzvoda) {
		this.grupaIzvoda = grupaIzvoda;
	}
	
}
