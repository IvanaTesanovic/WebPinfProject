package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.AbstractEntity;

@Entity
@Table(name = "drzava")
public class Drzava extends AbstractEntity {
	
	@Column(nullable = true)
	private String naziv;

	public Drzava() {}
	
	public Drzava(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
