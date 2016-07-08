package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class KursnaListaDTO {

	private String id;
	private String datum;
	private String broj_kursne_liste;
	private String datum_primene;
	private String id_banke;

	public KursnaListaDTO() {}

	public KursnaListaDTO(String id, String datum, String broj_kursne_liste, String datum_primene, String id_banke) {
		super();
		this.id = id;
		this.datum = datum;
		this.broj_kursne_liste = broj_kursne_liste;
		this.datum_primene = datum_primene;
		this.id_banke = id_banke;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getBroj_kursne_liste() {
		return broj_kursne_liste;
	}

	public void setBroj_kursne_liste(String broj_kursne_liste) {
		this.broj_kursne_liste = broj_kursne_liste;
	}

	public String getDatum_primene() {
		return datum_primene;
	}

	public void setDatum_primene(String datum_primene) {
		this.datum_primene = datum_primene;
	}

	public String getId_banke() {
		return id_banke;
	}

	public void setId_banke(String id_banke) {
		this.id_banke = id_banke;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}