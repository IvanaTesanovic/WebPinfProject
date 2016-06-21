package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupa_izvoda")
public class GrupaIzvoda extends AbstractEntity {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gi_ai_id")
	private AnalitikaIzvoda analitikaIzvoda;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "grupaIzvoda")
	private List<Kliring> klirinzi;
	
	public GrupaIzvoda() {}

	public AnalitikaIzvoda getAnalitikaIzvoda() {
		return analitikaIzvoda;
	}

	public void setAnalitikaIzvoda(AnalitikaIzvoda analitikaIzvoda) {
		this.analitikaIzvoda = analitikaIzvoda;
	}

	public List<Kliring> getKlirinzi() {
		return klirinzi;
	}

	public void setKlirinzi(List<Kliring> klirinzi) {
		this.klirinzi = klirinzi;
	}
	
}
