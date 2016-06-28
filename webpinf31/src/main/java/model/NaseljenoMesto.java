package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "naseljeno_mesto")
public class NaseljenoMesto extends AbstractEntity {
	
	@Column(nullable = true)
	private String naziv;
	
	@Column(nullable = true)
	private String ptt_oznaka;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_drzave")
	private Drzava id_drzave; 

	public NaseljenoMesto() {}

	public NaseljenoMesto(String naziv, String ptt_oznaka, Drzava id_drzave) {
		super();
		this.naziv = naziv;
		this.ptt_oznaka = ptt_oznaka;
		this.id_drzave = id_drzave;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPtt_oznaka() {
		return ptt_oznaka;
	}

	public void setPtt_oznaka(String ptt_oznaka) {
		this.ptt_oznaka = ptt_oznaka;
	}

	public Drzava getId_drzave() {
		return id_drzave;
	}

	public void setId_drzave(Drzava id_drzave) {
		this.id_drzave = id_drzave;
	}


}
