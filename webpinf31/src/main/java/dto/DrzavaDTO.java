package dto;

public class DrzavaDTO {
	
	private String id;
	private String sifra;
	private String naziv;
	
	public DrzavaDTO(String id, String sifra, String naziv) {
		super();
		this.id = id;
		this.sifra = sifra;
		this.naziv = naziv;
	}
	
	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public DrzavaDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
