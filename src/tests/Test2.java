package tests;

import com.etk.db.DBMSExecutor;
import com.etk.db.QueryExecutorImpl;
import com.etk.db.exceptions.RelsemDBException;
import com.etk.manager.User;
import com.etk.manager.schema.Attribute;
import com.etk.manager.schema.Schema;
import com.etk.manager.schema.UserTable;
import com.etk.parser.SelectObject;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectObject so = new SelectObject();
		
		
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
		table.addAttribute(a1);
		table.addAttribute(a2);
		
		schema.addTable(table);
		
		so.addFreeColumnName("id");
		so.addFreeColumnName("host");
		so.addFreeColumnName("awards");
		so.addTableName("festival");
		
		DBMSExecutor qExec = new QueryExecutorImpl(schema);
		
		try {
			qExec.executeQuery(so);
		} catch (RelsemDBException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
