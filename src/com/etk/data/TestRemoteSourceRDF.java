package com.etk.data;

import java.util.List;

public class TestRemoteSourceRDF {
	public static void main(String args[]){
		DataSource ds = new RemoteSourceRDF("http://dbpedia.org/sparql");
		
		List<Object> ec = ds.getEntityCandidates(50, 500);
		EntityCandidate eCan;
		
		for( Object one : ec){
			eCan = (EntityCandidate) one;
			
			System.out.println(eCan.getUri() + " - " + eCan.getLabel());
		}
	}
}
