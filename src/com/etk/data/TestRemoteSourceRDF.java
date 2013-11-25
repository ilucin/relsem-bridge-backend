package com.etk.data;

import java.util.List;

public class TestRemoteSourceRDF {
	public static void main(String args[]){
DataSource ds = new RemoteSourceRDF("http://dbpedia.org/sparql");
		
		List<Object> ec = ds.getEntityCandidates(50, 500, false);
		EntityCandidate eCan;
		System.out.println("*************************************Entities Test******************************************************");
		for( Object one : ec){
			eCan = (EntityCandidate) one;
			
			System.out.println(eCan.getUri() + " - " + eCan.getLabel());
		}
		
		System.out.println("*************************************Attributes Test******************************************************");
		List<Object> ac = ds.getAttributes("http://dbpedia.org/ontology/BodyOfWater", 50, 0, true);
		AttributeCandidate aCan;
		for( Object one : ac){
			aCan = (AttributeCandidate) one;
			
			System.out.println(aCan.getUri() + " - " + aCan.getLabel());
		}
		
		
		System.out.println("*************************************Values Test******************************************************");
		String strs[] = {"http://dbpedia.org/ontology/Canal/maximumBoatBeam", "http://dbpedia.org/ontology/Canal/maximumBoatLength"};
		List<Object> vc = ds.getValues("http://dbpedia.org/ontology/BodyOfWater", strs, 500, 0);
		ValueCandidate vCan;
		for( Object one : vc){
			vCan = (ValueCandidate) one;
			
			
			System.out.println(vCan.getSubject() + " - " + 
			vCan.getValues().get(0).split("\\^")[0] + " *** " + 
			vCan.getValues().get(1).split("\\^")[0]);
		}
	}
}
