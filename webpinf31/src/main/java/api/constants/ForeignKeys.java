package api.constants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ForeignKeys {
	public static ArrayList<String> getForeignKeys(String tableName){
		ArrayList<String> foreignKeys =  new ArrayList<String>();
		
		switch(tableName){
		
		
			case "analitikeIzvoda":
				foreignKeys.addAll(Arrays.asList("Dnevna stanja racuna", "Vrsta placanja", "Valuta", "Naseljeno mesto"));
			break;
				
			case "dnevnaStanja":
				foreignKeys.add("Racun");
			break;
			
			case "kliring":
				foreignKeys.add("Grupa izvoda");
			break;
			
			case "kursnaLista":
				foreignKeys.add("Banka");
			break;
				
			case "kursevi":
				foreignKeys.add("Kursna lista");
			break;
			
			case "racuni":
				foreignKeys.addAll(Arrays.asList("Drzava", "Banka", "Klijenti"));
				break;
			
			case "naseljenaMesta":
				foreignKeys.add("Drzava");
				break;
				
			case "drzave":
				return null;
				
		}
		
		
		return foreignKeys;
		
	}

}
