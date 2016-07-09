package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grupa_izvoda")
public class GrupaIzvoda extends AbstractEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_analitike_izvoda")
	private AnalitikaIzvoda id_analitike_izvoda;
	
	public GrupaIzvoda() {}


	public GrupaIzvoda(AnalitikaIzvoda id_analitike_izvoda) {
		super();
		this.id_analitike_izvoda = id_analitike_izvoda;
	}

	public AnalitikaIzvoda getId_analitike_izvoda() {
		return id_analitike_izvoda;
	}


	public void setId_analitike_izvoda(AnalitikaIzvoda id_analitike_izvoda) {
		this.id_analitike_izvoda = id_analitike_izvoda;
	}

	
	
}
