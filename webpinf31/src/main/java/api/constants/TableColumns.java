package api.constants;

import java.util.ArrayList;
import java.util.Arrays;

import util.Column;

public final class TableColumns {
	
	public static ArrayList<Column> getColumns(String tableName) {
		ArrayList<Column> columns = new ArrayList<>();
		
		switch(tableName) {
		case "drzave":
			columns.addAll(Arrays.asList(new Column("id", "int"), new Column("naziv", "string")));
			break;
		case "naseljenaMesta":
			columns.addAll(Arrays.asList(new Column("id", "int"), new Column("naziv", "string"), 
					new Column("ptt_oznaka", "string"), new Column("drzava", "string")));
			break;
		case "banke":
			columns.addAll(Arrays.asList(new Column("id", "int"),new Column("id_banke", "int"), new Column("naziv", "string"),
					new Column("pib", "string"), 
					new Column("adresa", "string"), new Column("email", "string"), new Column("telefon", "string"),
					new Column("fax", "string"),new Column("web", "string"), new Column("narodna_banka", "boolean")));
			break;
		
		case "klijenti":
			columns.addAll(Arrays.asList(new Column("id", "int"),new Column("fizicko_lice", "boolean"),new Column("ime", "string"),
					new Column("prezime", "string"),new Column("jmbg", "string"),new Column("naziv", "string"), new Column("pib", "string"),
					 new Column("adresa", "string"),new Column("telefon", "string"),new Column("email", "string"),
					 new Column("fax", "string"), new Column("sajt", "string"),
					new Column("id_delatnosti", "string"), new Column("naziv_delatnosti", "string"),new Column("odgovorno_lice", "string")));
			break;
			
		case "racuni":
			columns.addAll(Arrays.asList(new Column("id","int"), new Column("banka", "int"),new Column("klijent", "int"),new Column("valuta", "int"),
					new Column("broj_racuna","string"),new Column("datum_otvaranja","date"), new Column("vazeci","boolean")));
		break;
		
		case "rtgs":
			columns.addAll(Arrays.asList(new Column("id", "int"),new Column("analitika_izvoda", "int"),new Column("id_poruke", "string"),new Column("swift_banke_duznika", "string"),
					new Column("duznik", "string"), new Column("racun_duznika", "string"), new Column("obracunski_racun_banke_duznika", "string"),
					new Column("swift_banke_poverioca", "string"), new Column("poverilac", "string"), new Column("racun_poverioca", "string"),
					new Column("obracunski_racun_banke_poverioca", "string"),new Column("model_zaduzenja", "string"),new Column("poziv_na_broj_zaduzenja", "string"),
					new Column("model_odobrenja", "string"),new Column("poziv_na_broj_odobrenja", "string"),new Column("svrha_placanja", "string"),
					new Column("datum_naloga", "date"),new Column("id_valute", "string"),new Column("datum_valute", "date"),new Column("ukupan_iznos", "double")));
			break;
		case "kliring":
			columns.addAll(Arrays.asList(new Column("id", "int"), new Column("id_poruke", "string"),new Column("grupa_izvoda", "int"),
					new Column("swift_banke_duznika", "string"), new Column("obracunski_racun_banke_duznika", "string"),
					new Column("obracunski_racun_banke_poverioca", "string"),
					new Column("swift_banke_poverioca", "string"),new Column("datum_naloga", "date"), new Column("id_valute", "string"),new Column("datum_valute", "date"),
					new Column("ukupan_iznos", "double")));
			break;
		case "kursnaLista":
			columns.addAll(Arrays.asList(new Column("id", "int"),new Column("banka","int"), new Column("broj_kursne_liste", "Integer"), new Column("datum", "date"),new Column("datum_primene", "date")));
			break;
			
		case "kursevi":
			columns.addAll(Arrays.asList(new Column("id", "int"),new Column("kursna_lista", "int"),
					new Column("osnovna_valuta", "int"),new Column("valuta", "int"),
					new Column("kupovni_kurs","double"), new Column("prodajni_kurs","double"), new Column("srednji_kurs","double")));
			break;
			
		case "analitikeIzvoda":
			columns.addAll(Arrays.asList(new Column("id","int"), new Column("dnevno_stanja_racuna","int"),new Column("naseljeno_mesto","int"),
					new Column("valuta","int"), new Column("vrste_placanja","int"),
					new Column("duznik","string"),new Column("poverilac","string"),new Column("svrha_placanja","string"),
					new Column("datum_prijema","date"),new Column("datum_valute","date"), new Column("racun_duznika","string"),
					new Column("racun_poverioca","string"), new Column("model_odobrenja","string"), new Column("model_zaduzenja","string"),
					new Column("poziv_na_broj_odobrenja","string"), new Column("poziv_na_broj_zaduzenja","string"),
					new Column("hitno","boolean"), new Column("iznos","double"), new Column("tip_greske","integer"), new Column("status","string")));
			break;
			
		case "dnevnaStanja":
			columns.addAll(Arrays.asList(new Column("id","int"),new Column("racun","int"),new Column("datum_prometa","date"), 
					new Column("novo_stanje","double"), new Column("prethodno_stanje","double"), 
					new Column("promet_na_teret","double"), new Column("promet_u_korist","double")
					));
					
		}
		return columns;
	}

}
