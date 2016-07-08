package dto;


import model.Drzava;

public class NaseljenoMestoDTO {
	
	public String id;
	public String naziv;
	public String ptt_oznaka;
	public String id_drzave;
	
	public NaseljenoMestoDTO() { }
	
	public NaseljenoMestoDTO(String id, String naziv, String ptt_oznaka, String id_drzave) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.ptt_oznaka = ptt_oznaka;
		this.id_drzave = id_drzave;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPtt_oznaka() {
		return ptt_oznaka;
	}

	public void setPtt_oznaka(String ptt_oznaka) {
		this.ptt_oznaka = ptt_oznaka;
	}

	public String getId_drzave() {
		return id_drzave;
	}

	public void setId_drzave(String id_drzave) {
		this.id_drzave = id_drzave;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
