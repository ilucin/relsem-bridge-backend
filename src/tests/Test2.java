package tests;

import com.etk.db.DBMSExecutor;
import com.etk.db.QueryExecutorImpl;
import com.etk.db.exceptions.RelsemDBException;
import com.etk.db.query.QueryResult;
import com.etk.manager.User;
import com.etk.manager.schema.Attribute;
import com.etk.manager.schema.Schema;
import com.etk.manager.schema.UserTable;
import com.etk.parser.SelectObject;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectObject so = new SelectObject();
		SelectObject so2 = new SelectObject();
		
		
		User user = new User("marko");
		Schema schema = new Schema(user);
		
		
//		"http://dbpedia.org/property/host"
//		http://dbpedia.org/property/awards
		UserTable table = new UserTable("festival", "http://schema.org/Festival", "festival", "id");
		Attribute a1 = new Attribute.Builder()
							.setName("host")
							.setType("string")
							.setUri("http://dbpedia.org/property/host")
							.setNotNull(false)
							.setDefaultValue("nema")
							.build();
		Attribute a2 = new Attribute.Builder()
							.setName("awards")
							.setType("string")
							.setUri("http://dbpedia.org/property/awards")
							.setNotNull(false)
							.setDefaultValue("nema")
							.build();
		
		UserTable table2 = new UserTable("award", "http://dbpedia.org/ontology/Award", "award", "id");
		Attribute b1 = new Attribute.Builder()
							.setName("name")
							.setType("string")
							.setUri("http://dbpedia.org/property/name")
							.setNotNull(false)
							.setDefaultValue("nema")
							.build();
		Attribute b2 = new Attribute.Builder()
							.setName("year")
							.setType("string")
							.setUri("http://dbpedia.org/property/year")
							.setNotNull(false)
							.setDefaultValue("nema")
							.build();
		
		
		
		table.addAttribute(a1);
		table.addAttribute(a2);
		
		table2.addAttribute(b1);
		table2.addAttribute(b2);
		
		
		schema.addTable(table);
		schema.addTable(table2);
		
		so.addFreeColumnName("id");
		so.addFreeColumnName("host");
		so.addFreeColumnName("awards");
//		so.addFreeColumnName("year");
		so.addTableName("festival");
//		so.addTableName("award");
		
		so2.addFreeColumnName("id");
		so2.addFreeColumnName("year");
		so2.addFreeColumnName("name");
		so2.addTableName("award");
		
		DBMSExecutor qExec = new QueryExecutorImpl(schema);
		QueryResult qr = null;
		try {
			qr = qExec.executeQuery(so).get(0);
		} catch (RelsemDBException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("done");
	}

}
