package dto;

public class RacunDTO {
	
	private String id;
	private String broj_racuna;
	private String datum_otvaranja;
	private String vazeci;
	private String id_banke;
	private String id_valute;
	private String id_klijenta;
	
	public RacunDTO() {}

	public RacunDTO(String id, String broj_racuna, String datum_otvaranja, String vazeci, String id_banke,
			String id_valute, String id_klijenta) {
		super();
		this.id = id;
		this.broj_racuna = broj_racuna;
		this.datum_otvaranja = datum_otvaranja;
		this.vazeci = vazeci;
		this.id_banke = id_banke;
		this.id_valute = id_valute;
		this.id_klijenta = id_klijenta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBroj_racuna() {
		return broj_racuna;
	}

	public void setBroj_racuna(String broj_racuna) {
		this.broj_racuna = broj_racuna;
	}

	public String getDatum_otvaranja() {
		return datum_otvaranja;
	}

	public void setDatum_otvaranja(String datum_otvaranja) {
		this.datum_otvaranja = datum_otvaranja;
	}

	public String getVazeci() {
		return vazeci;
	}

	public void setVazeci(String vazeci) {
		this.vazeci = vazeci;
	}

	public String getId_banke() {
		return id_banke;
	}

	public void setId_banke(String id_banke) {
		this.id_banke = id_banke;
	}

	public String getId_valute() {
		return id_valute;
	}

	public void setId_valute(String id_valute) {
		this.id_valute = id_valute;
	}

	public String getId_klijenta() {
		return id_klijenta;
	}

	public void setId_klijenta(String id_klijenta) {
		this.id_klijenta = id_klijenta;
	}
	
}
