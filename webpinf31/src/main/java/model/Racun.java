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
	
	
	@Column(nullable = true)
	private String broj_racuna;
	
	@Column(nullable = true)
	private Date datum_otvaranja;
	
	@Column(nullable = true)
	private Boolean vazeci;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_banke")
	private Banka id_banke;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_valute")
	private Valuta id_valute;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_klijenta")
	private Klijent id_klijenta;
	
	
	public Racun() {}

	public Racun(String broj_racuna, Date datum_otvaranja, Boolean vazeci,
			Banka id_banke, Valuta id_valute, Klijent id_klijenta) {
		super();
		this.broj_racuna = broj_racuna;
		this.datum_otvaranja = datum_otvaranja;
		this.vazeci = vazeci;
		this.id_banke = id_banke;
		this.id_valute = id_valute;
		this.id_klijenta = id_klijenta;
	}



	public String getBroj_racuna() {
		return broj_racuna;
	}


	public void setBroj_racuna(String broj_racuna) {
		this.broj_racuna = broj_racuna;
	}


	public Date getDatum_otvaranja() {
		return datum_otvaranja;
	}


	public void setDatum_otvaranja(Date datum_otvaranja) {
		this.datum_otvaranja = datum_otvaranja;
	}


	public Boolean getVazeci() {
		return vazeci;
	}


	public void setVazeci(Boolean vazeci) {
		this.vazeci = vazeci;
	}


	public Banka getId_banke() {
		return id_banke;
	}


	public void setId_banke(Banka id_banke) {
		this.id_banke = id_banke;
	}


	public Valuta getId_valute() {
		return id_valute;
	}


	public void setId_valute(Valuta id_valute) {
		this.id_valute = id_valute;
	}


	public Klijent getId_klijenta() {
		return id_klijenta;
	}


	public void setId_klijenta(Klijent id_klijenta) {
		this.id_klijenta = id_klijenta;
	}

	
}
