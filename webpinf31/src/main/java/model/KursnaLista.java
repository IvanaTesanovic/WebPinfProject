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
@Table(name = "kursna_lista")
public class KursnaLista extends AbstractEntity {

	@Column(nullable = true)
	private Date datum;
	
	@Column(nullable = true)
	private Integer broj_kursne_liste;
	
	@Column(nullable = true)
	private Date datum_primene;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_banke")
	private Banka id_banke;

	
	public KursnaLista() {}

	
	public KursnaLista(Date datum, Integer broj_kursne_liste,
			Date datum_primene, Banka id_banke) {
		super();
		this.datum = datum;
		this.broj_kursne_liste = broj_kursne_liste;
		this.datum_primene = datum_primene;
		this.id_banke = id_banke;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public Integer getBroj_kursne_liste() {
		return broj_kursne_liste;
	}

	public void setBroj_kursne_liste(Integer broj_kursne_liste) {
		this.broj_kursne_liste = broj_kursne_liste;
	}

	public Date getDatum_primene() {
		return datum_primene;
	}

	public void setDatum_primene(Date datum_primene) {
		this.datum_primene = datum_primene;
	}


	public Banka getId_banke() {
		return id_banke;
	}


	public void setId_banke(Banka id_banke) {
		this.id_banke = id_banke;
	}

}
