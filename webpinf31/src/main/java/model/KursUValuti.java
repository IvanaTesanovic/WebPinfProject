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
	
	@Column(name = "kupovni")
	private Double kupovni;
	
	@Column(name = "srednji")
	private Double srednji;
	
	@Column(name = "prodajni")
	private Double prodajni;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_kursne_liste")
	private KursnaLista kursnaLista;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_valute")
	private Valuta valuta;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_osnovne_valute")
	private Valuta osnovnaValuta;*/
	
	public KursUValuti() {}

	public Double getKupovni() {
		return kupovni;
	}

	public void setKupovni(Double kupovni) {
		this.kupovni = kupovni;
	}

	public Double getSrednji() {
		return srednji;
	}

	public void setSrednji(Double srednji) {
		this.srednji = srednji;
	}

	public Double getProdajni() {
		return prodajni;
	}

	public void setProdajni(Double prodajni) {
		this.prodajni = prodajni;
	}

	public KursnaLista getKursnaLista() {
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
	
}
