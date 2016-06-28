package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kurs_u_valuti")
public class KursUValuti extends AbstractEntity {

	@Column(nullable = true)
	private Double kupovni_kurs;
	
	@Column(nullable = true)
	private Double srednji_kurs;
	
	@Column(nullable = true)
	private Double prodajni_kurs;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_kursne_liste")
	private KursnaLista id_kursne_liste;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_valute")
	private Valuta id_valute;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_osnovne_valute")
	private Valuta id_osnovne_valute;
	
	public KursUValuti() {}

	
	public KursUValuti(Double kupovni_kurs, Double srednji_kurs,
			Double prodajni_kurs, KursnaLista id_kursne_liste,
			Valuta id_valute, Valuta id_osnovne_valute) {
		super();
		this.kupovni_kurs = kupovni_kurs;
		this.srednji_kurs = srednji_kurs;
		this.prodajni_kurs = prodajni_kurs;
		this.id_kursne_liste = id_kursne_liste;
		this.id_valute = id_valute;
		this.id_osnovne_valute = id_osnovne_valute;
	}


	public Double getKupovni_kurs() {
		return kupovni_kurs;
	}

	public void setKupovni_kurs(Double kupovni_kurs) {
		this.kupovni_kurs = kupovni_kurs;
	}

	public Double getSrednji_kurs() {
		return srednji_kurs;
	}

	public void setSrednji_kurs(Double srednji_kurs) {
		this.srednji_kurs = srednji_kurs;
	}

	public Double getProdajni_kurs() {
		return prodajni_kurs;
	}

	public void setProdajni_kurs(Double prodajni_kurs) {
		this.prodajni_kurs = prodajni_kurs;
	}


	public KursnaLista getId_kursne_liste() {
		return id_kursne_liste;
	}


	public void setId_kursne_liste(KursnaLista id_kursne_liste) {
		this.id_kursne_liste = id_kursne_liste;
	}


	public Valuta getId_valute() {
		return id_valute;
	}


	public void setId_valute(Valuta id_valute) {
		this.id_valute = id_valute;
	}


	public Valuta getId_osnovne_valute() {
		return id_osnovne_valute;
	}


	public void setId_osnovne_valute(Valuta id_osnovne_valute) {
		this.id_osnovne_valute = id_osnovne_valute;
	}


	
}
