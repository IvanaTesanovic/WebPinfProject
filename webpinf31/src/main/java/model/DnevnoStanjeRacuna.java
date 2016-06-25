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

	@Column(nullable = false)
	private Date datum_prometa;
	
	@Column(nullable = false)
	private Double promet_u_korist;
	
	@Column(nullable = false)
	private Double prethodno_stanje;
	
	@Column(nullable = false)
	private Double promet_na_Teret;
	
	@Column(nullable = false)
	private Double novo_stanje;
	
	/** STRANI KLJUCEVI **/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_racuna")
	private Racun racun;
	
	//mappedBy je naziv tog polja u child tabeli
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dsr")
	private List<AnalitikaIzvoda> analitikeIzvoda;
	
	public DnevnoStanjeRacuna() {}



	public Date getDatum_prometa() {
		return datum_prometa;
	}



	public void setDatum_prometa(Date datum_prometa) {
		this.datum_prometa = datum_prometa;
	}



	public Double getPromet_u_korist() {
		return promet_u_korist;
	}



	public void setPromet_u_korist(Double promet_u_korist) {
		this.promet_u_korist = promet_u_korist;
	}



	public Double getPrethodno_stanje() {
		return prethodno_stanje;
	}



	public void setPrethodno_stanje(Double prethodno_stanje) {
		this.prethodno_stanje = prethodno_stanje;
	}



	public Double getPromet_na_Teret() {
		return promet_na_Teret;
	}



	public void setPromet_na_Teret(Double promet_na_Teret) {
		this.promet_na_Teret = promet_na_Teret;
	}



	public Double getNovo_stanje() {
		return novo_stanje;
	}



	public void setNovo_stanje(Double novo_stanje) {
		this.novo_stanje = novo_stanje;
	}



	public List<AnalitikaIzvoda> getAnalitikeIzvoda() {
		return analitikeIzvoda;
	}



	public void setAnalitikeIzvoda(List<AnalitikaIzvoda> analitikeIzvoda) {
		this.analitikeIzvoda = analitikeIzvoda;
	}



	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	
}
