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
@Table(name = "racun")
public class Racun extends AbstractEntity {
	
	@Column(name = "broj_racuna")
	private String brojRacuna;
	
	@Column(name = "datum_otvaranja_racuna")
	private Date datumOtvaranja;
	
	@Column(name = "vazeci")
	private Boolean vazeci;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_banke")
	private Banka banka;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_valute")
	private Valuta valuta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_klijenta")
	private Klijent klijent;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "racun")
	private List<DnevnoStanjeRacuna> dnevnaStanjaRacuna;
	
	public Racun() {}
	
	public List<DnevnoStanjeRacuna> getDnevnaStanjaRacuna() {
		return dnevnaStanjaRacuna;
	}

	public void setDnevnaStanjaRacuna(List<DnevnoStanjeRacuna> dnevnaStanjaRacuna) {
		this.dnevnaStanjaRacuna = dnevnaStanjaRacuna;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public Boolean getVazeci() {
		return vazeci;
	}

	public void setVazeci(Boolean vazeci) {
		this.vazeci = vazeci;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	
}
