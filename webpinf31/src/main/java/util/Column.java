package util;

public class Column {
	
	private String naziv;
	private String tip;
	
	public Column() {}

	public Column(String naziv, String tip) {
		super();
		this.naziv = naziv;
		this.tip = tip;
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
