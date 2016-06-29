package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ukidanje")
public class UkidanjeRacuna extends AbstractEntity {
	
	@Column(nullable = true)
	private Date datum_ukidanja;
	
	@Column(nullable = true)
	private String sredstva;
	
	/** da li staviti 1na1 za ukidanje i racun? 
	 * dodati getere i setere **/
	
	public UkidanjeRacuna() {}

	public UkidanjeRacuna(Date datum_ukidanja, String sredstva) {
		super();
		this.datum_ukidanja = datum_ukidanja;
		this.sredstva = sredstva;
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
