package com.etk.data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import com.etk.data.query.Expression;
import com.etk.data.query.Operator;
import com.etk.data.query.Properties;
import com.etk.data.query.SelectionClause;

public class TestRemoteSourceRDF {
	public static void main(String args[]) {

		DataSource ds = new RemoteSourceHierarchyRDF(
				"http://dbpedia.org/sparql", "http://dbpedia.org");
		Properties prop = new Properties();
		
		prop.setEntitySuperClass("http://schema.org/Festival");
		List<Object> ec = ds.getEntityCandidates(prop);
		EntityCandidate eCan;
		for (Object one : ec) {
			eCan = (EntityCandidate) one;

			System.out.println(eCan.getUri() + " - " + eCan.getLabel());
		}

		prop.setLimit(50);
		List<Object> ac = ds.getAttributes("http://schema.org/Festival", prop);
		AttributeCandidate aCan;
		for (Object one : ac) {
			aCan = (AttributeCandidate) one;

			System.out.println(aCan.getUri() + " - " + aCan.getLabel());
		}

		List<SelectionClause> clauses = new ArrayList<SelectionClause>();
		clauses.add(new SelectionClause(
				"http://dbpedia.org/property/yearsActive", Operator.GT, 1,
				false));
		clauses.add(new SelectionClause(
				"http://dbpedia.org/property/musicFestivalName", Operator.LIKE,
				"%Electric%", false));
		Expression exp = new Expression(Operator.AND, clauses);
		String strs[] = { "http://dbpedia.org/property/musicFestivalName",
				"http://dbpedia.org/property/yearsActive" };
		List<Object> vc = ds.getValues("http://schema.org/Festival", strs,
				prop, exp);
		ValueCandidate vCan;
		for (Object one : vc) {
			vCan = (ValueCandidate) one;

			System.out.println(vCan.getSubject()
					+ " - "
					+ vCan.getValues().get(
							"http://dbpedia.org/property/musicFestivalName")
					+ " *** "
					+ vCan.getValues().get(
							"http://dbpedia.org/property/yearsActive"));
		}

	}
}
