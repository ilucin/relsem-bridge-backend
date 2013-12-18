package mock;

import com.etk.manager.User;
import com.etk.manager.schema.Attribute;
import com.etk.manager.schema.Schema;
import com.etk.manager.schema.UserTable;

public class MockedSchema extends Schema {
	public MockedSchema(User user) {
		super(user);
		
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
		
		this.addTable(table);
		
		
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
		
		table2.addAttribute(b1);
		table2.addAttribute(b2);
		this.addTable(table2);
		
	}

}
