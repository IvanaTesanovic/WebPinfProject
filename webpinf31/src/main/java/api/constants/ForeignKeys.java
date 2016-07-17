package api.constants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ForeignKeys {
	public static ArrayList<String> getForeignKeys(String tableName){
		ArrayList<String> foreignKeys =  new ArrayList<String>();
		
		switch(tableName){
		
			case "analitikeIzvoda":
				foreignKeys.addAll(Arrays.asList("Grupa izvoda", "RTGS"));
			break;
				
			case "banke":
				foreignKeys.addAll(Arrays.asList("Kursna lista", "Racun"));
				break;
				
			case "dnevnaStanja":
				foreignKeys.add("Analitika izvoda");
			break;
			
			case "klijenti":
				foreignKeys.add("Racun");
			break;
			
			case "kursnaLista":
				foreignKeys.add("Kurs u valuti");
			break;
			
			case "valute":
				foreignKeys.addAll(Arrays.asList("Analitika izvoda","Kurs u valuti", "Banka", "Drzava", "Racun"));
				break;
			
			case "racuni":
				foreignKeys.addAll(Arrays.asList("Dnevno stanje racuna"));
				break;
			
			case "naseljenaMesta":
				foreignKeys.add("Analitika izvoda");
				break;
				
			case "drzave":
				foreignKeys.addAll(Arrays.asList("Naseljeno mesto")); 
				break;
		}
		
		
		return foreignKeys;
		
	}

}
