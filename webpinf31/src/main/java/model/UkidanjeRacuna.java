package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ukidanje")
public class UkidanjeRacuna extends AbstractEntity {
	
	@Column(name = "datum_ukidanja")
	private Date datumUkidanja;
	
	@Column(name = "prenesena_sredstva")
	private String sredstva;
	
	/** da li staviti 1na1 za ukidanje i racun? 
	 * dodati getere i setere **/
	
	public UkidanjeRacuna() {}

	public Date getDatumUkidanja() {
		return datumUkidanja;
	}

	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}

	public String getSredstva() {
		return sredstva;
	}

	public void setSredstva(String sredstva) {
		this.sredstva = sredstva;
	}

}
