package com.etk.data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class TestRemoteSourceRDF {
	public static void main(String args[]){
DataSource ds = new RemoteSourceRDF("http://dbpedia.org/sparql");
		
		List<Object> ec = ds.getEntityCandidates(50, 500, false);
		EntityCandidate eCan;
		System.out.println("*************************************Entities Test******************************************************");
		for( Object one : ec){
			eCan = (EntityCandidate) one;
			
			try {
				System.out.println(URLDecoder.decode(eCan.getUri(), "utf-8") + " - " + eCan.getLabel());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("*************************************Attributes Test******************************************************");
		List<Object> ac = ds.getAttributes("http://dbpedia.org/ontology/BodyOfWater", 50, 0, true);
		AttributeCandidate aCan;
		for( Object one : ac){
			aCan = (AttributeCandidate) one;
			
			try {
				System.out.println(URLDecoder.decode(aCan.getUri(), "utf-8") + " - " + 
								   aCan.getLabel());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("*************************************Values Test******************************************************");
		String strs[] = {"http://dbpedia.org/ontology/city", "http://dbpedia.org/ontology/country"};
		List<Object> vc = ds.getValues("http://dbpedia.org/ontology/BodyOfWater", strs, 150, 0);
		ValueCandidate vCan;
		
		for( Object one : vc){
			vCan = (ValueCandidate) one;
			
			try {
				System.out.println(URLDecoder.decode(vCan.getSubject() , "utf-8") + " - " + 
				URLDecoder.decode(vCan.getValues().get("http://dbpedia.org/ontology/city").split("\\^")[0], "utf-8") + " *** " + 
				URLDecoder.decode(vCan.getValues().get("http://dbpedia.org/ontology/country").split("\\^")[0], "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
