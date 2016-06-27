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
		case "banke":
			columns.addAll(Arrays.asList(new Column("id", "int"), new Column("naziv", "string"), new Column("pib", "string")));
			break;
		}
		return columns;
	}

}
