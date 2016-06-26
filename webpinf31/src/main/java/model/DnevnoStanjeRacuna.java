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
@Table(name = "dnevno_stanje_racuna")
public class DnevnoStanjeRacuna extends AbstractEntity {

	@Column(name = "datum_prometa")
	private Date datumprometa;
	
	@Column(name = "dsr_ukorist")
	private Double uKorist;
	
	@Column(name = "dsr_prethodno")
	private Double prethodno;
	
	@Column(name = "dsr_nateret")
	private Double naTeret;
	
	@Column(name = "dsr_novo_stanje")
	private Double novoStanje;
	
	/** STRANI KLJUCEVI **/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_racuna")
	private Racun racun;
	
	//mappedBy je naziv tog polja u child tabeli
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dsr")
	private List<AnalitikaIzvoda> analitikeIzvoda;
	
	public DnevnoStanjeRacuna() {}

	public Date getDatumprometa() {
		return datumprometa;
	}

	public void setDatumprometa(Date datumprometa) {
		this.datumprometa = datumprometa;
	}

	public Double getuKorist() {
		return uKorist;
	}

	public void setuKorist(Double uKorist) {
		this.uKorist = uKorist;
	}

	public Double getPrethodno() {
		return prethodno;
	}

	public void setPrethodno(Double prethodno) {
		this.prethodno = prethodno;
	}

	public Double getNaTeret() {
		return naTeret;
	}

	public void setNaTeret(Double naTeret) {
		this.naTeret = naTeret;
	}

	public Double getNovoStanje() {
		return novoStanje;
	}

	public void setNovoStanje(Double novoStanje) {
		this.novoStanje = novoStanje;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	
}
