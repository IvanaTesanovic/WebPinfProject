package dto;

public class DrzavaDTO {
	
	private String id;
	private String naziv;
	public DrzavaDTO(String id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
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
