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
	@JoinColumn(name = "id_grupe_izvoda")
	private AnalitikaIzvoda analitika_izvoda;

	
	public GrupaIzvoda() {}


	public AnalitikaIzvoda getAnalitika_izvoda() {
		return analitika_izvoda;
	}


	public void setAnalitika_izvoda(AnalitikaIzvoda analitika_izvoda) {
		this.analitika_izvoda = analitika_izvoda;
	}

	
	
}
