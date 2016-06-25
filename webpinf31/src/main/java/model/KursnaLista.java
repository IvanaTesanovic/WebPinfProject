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
	
	@Column(nullable = false)
	private Date datum;
	
	@Column(nullable = false)
	private Integer broj_kursne_liste;
	
	@Column(nullable = false)
	private Date datum_primene;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_banke")
	private Banka banka;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "kursnaLista")
	private List<KursUValuti> kursevi;
	
	public KursnaLista() {}

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

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public List<KursUValuti> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<KursUValuti> kursevi) {
		this.kursevi = kursevi;
	}
}
