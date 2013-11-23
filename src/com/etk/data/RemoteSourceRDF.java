package com.etk.data;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class RemoteSourceRDF implements DataSource{
	String service;
	String queryString;
	
	public RemoteSourceRDF( String service ){
		this.service = service;
		
		queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
					  "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> ";
	}
	
	@Override
	public List<Object> getEntityCandidates(int limit, int offset) {
		queryString += "SELECT DISTINCT ?o WHERE { ?s a ?o }" + 
					   " ORDER BY ?o";
		
		if( limit != 0 ){
			queryString += " LIMIT " + Integer.toString( limit );
		}
		if( offset != 0 ){
			queryString += " OFFSET " + Integer.toString( offset );
		}
				
		Query query = QueryFactory.create(queryString);
    	QueryExecution queryExecution = QueryExecutionFactory.createServiceRequest(
    											service, query );
    	ResultSet resultSet = queryExecution.execSelect();
    	
		return entityCandidatesFromRS(resultSet);
	}
	
	private List<Object> entityCandidatesFromRS(ResultSet resultSet){
		List<Object> entityCandidates = new ArrayList<Object>();
		
		QuerySolution qs;
 		while( resultSet.hasNext() ){
 			qs = resultSet.next();
			entityCandidates.add( new EntityCandidate(qs.get("o").toString()) );
		}
		
		
		return entityCandidates;
	}

	@Override
	public List<String> getAttributes(String entity){
		String filter[];
		//if( entity.startsWith("http") ){
			//String filter[] = entity.
		//}
		
		queryString += "select distinct ?p where { ?s ?p ?o." +
					   "?o rdf:type <" + entity + ">." +
					   "FILTER(STRSTARTS(STR(?p), 'http://dbpedia.org/'))." +
					   "}";

		return null;
	}

	@Override
	public List<Class> getType(String entity, String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getValues(String entity, String attribute) {
		// TODO Auto-generated method stub
		return null;
	}
}
