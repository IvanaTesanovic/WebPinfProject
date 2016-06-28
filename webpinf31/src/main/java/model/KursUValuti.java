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
	@JoinColumn(name = "kursna_lista")
	private KursnaLista kursna_lista;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "valuta")
	private Valuta valuta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "osnovna_valuta")
	private Valuta osnovna_valuta;
	
	public KursUValuti() {}


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


/*	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
	*/
	
}
