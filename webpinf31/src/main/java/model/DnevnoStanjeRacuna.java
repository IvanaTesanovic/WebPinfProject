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

	@Column(nullable = true)
	private Date datum_prometa;
	
	@Column(nullable = true)
	private Double promet_u_korist;
	
	@Column(nullable = true)
	private Double prethodno_stanje;
	
	@Column(nullable = true)
	private Double promet_na_teret;
	
	@Column(nullable = true)
	private Double novo_stanje;
	
	/** STRANI KLJUCEVI **/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_racuna")
	private Racun id_racuna;
	

	public DnevnoStanjeRacuna() {}
	

	public DnevnoStanjeRacuna(Date datum_prometa, Double promet_u_korist,
			Double prethodno_stanje, Double promet_na_teret,
			Double novo_stanje, Racun id_racuna) {
		super();
		this.datum_prometa = datum_prometa;
		this.promet_u_korist = promet_u_korist;
		this.prethodno_stanje = prethodno_stanje;
		this.promet_na_teret = promet_na_teret;
		this.novo_stanje = novo_stanje;
		this.id_racuna = id_racuna;
	}




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


	public Double getPromet_na_teret() {
		return promet_na_teret;
	}


	public void setPromet_na_teret(Double promet_na_teret) {
		this.promet_na_teret = promet_na_teret;
	}


	public Double getNovo_stanje() {
		return novo_stanje;
	}


	public void setNovo_stanje(Double novo_stanje) {
		this.novo_stanje = novo_stanje;
	}


	public Racun getId_racuna() {
		return id_racuna;
	}


	public void setId_racuna(Racun id_racuna) {
		this.id_racuna = id_racuna;
	}


	
}
