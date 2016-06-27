package dto;

public class AkcijaDTO {
	
	public String rezim;
	public String nazivTabele;
	
	public AkcijaDTO() {}
	
	public AkcijaDTO(String rezim, String nazivTabele) {
		super();
		this.rezim = rezim;
		this.nazivTabele = nazivTabele;
	}

	public String getRezim() {
		return rezim;
	}

	public void setRezim(String rezim) {
		this.rezim = rezim;
	}

	public String getNazivTabele() {
		return nazivTabele;
	}

	public void setNazivTabele(String nazivTabele) {
		this.nazivTabele = nazivTabele;
	}
	
}
