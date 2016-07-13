package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ukidanje")
public class UkidanjeRacuna extends AbstractEntity {
	
	@Column(nullable = true)
	private Date datum_ukidanja;
	
	@Column(nullable = true)
	private String sredstva;
	
	/** STRANI KLJUCEVI **/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_racuna")
	private Racun id_racuna;
	
	public UkidanjeRacuna() {}

	public UkidanjeRacuna(Date datum_ukidanja, String sredstva, Racun id_racuna) {
		super();
		this.datum_ukidanja = datum_ukidanja;
		this.sredstva = sredstva;
		this.id_racuna = id_racuna;
	}

	public Racun getId_racuna() {
		return id_racuna;
	}

	public void setId_racuna(Racun id_racuna) {
		this.id_racuna = id_racuna;
	}

	public Date getDatum_ukidanja() {
		return datum_ukidanja;
	}


	public void setDatum_ukidanja(Date datum_ukidanja) {
		this.datum_ukidanja = datum_ukidanja;
	}


	public String getSredstva() {
		return sredstva;
	}

	public void setSredstva(String sredstva) {
		this.sredstva = sredstva;
	}

}
