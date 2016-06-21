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
	
	@Column(name = "kl_datum")
	private Date datum;
	
	@Column(name = "kl_broj")
	private Integer broj;
	
	@Column(name = "kl_datpr")
	private Date datumPrimene;
	
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

	public Integer getBroj() {
		return broj;
	}

	public void setBroj(Integer broj) {
		this.broj = broj;
	}

	public Date getDatumPrimene() {
		return datumPrimene;
	}

	public void setDatumPrimene(Date datumPrimene) {
		this.datumPrimene = datumPrimene;
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
