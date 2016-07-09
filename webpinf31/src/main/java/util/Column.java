package util;

import java.util.List;

public class Column {
	
	private String naziv;
	private String tip;
	private List<String> fks;
	
	public Column() {}
	
	public Column(String naziv, String tip) {
		super();
		this.naziv = naziv;
		this.tip = tip;
	}

	public Column(String naziv, String tip, List<String> fks) {
		super();
		this.naziv = naziv;
		this.tip = tip;
		this.fks = fks;
	}

	public List<String> getFks() {
		return fks;
	}

	public void setFks(List<String> fks) {
		this.fks = fks;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
}
