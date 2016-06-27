package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vrste_placanja")
public class VrstePlacanja extends AbstractEntity {
	
	@Column(nullable = true)
	private String naziv;
	
	
	
	public VrstePlacanja() {}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
