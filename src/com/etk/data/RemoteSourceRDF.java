package com.etk.data;

import java.util.ArrayList;
import java.util.List;

import com.etk.data.query.Properties;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class RemoteSourceRDF implements DataSource{
	String service;
	String queryStringTemplate;
	
	public RemoteSourceRDF( String service ){
		this.service = service;
		
		queryStringTemplate = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
					  "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> ";
	}
	
	@Override
	public List<Object> getEntityCandidates(Properties queryProperties) {
		String queryString = queryStringTemplate;
		queryString += "SELECT (COUNT(?o) as ?num) ?o WHERE { ?s a ?o. ";

		// Checks should the sparql query ask for a rdfs:label
		// This should be used only if you are sure that there is a predicate
		// rdfs:label in the data source
		if( queryProperties.isLabel() ){
			queryString += "?o rdfs:label ?label. " + 
                           "FILTER (lang(?label) = 'en' || lang(?label) = '') ";
		}
		
		queryString += "}";
		/* For now I will disable order by, because it is very slow
		if( limit != 0 && offset != 0 ){
			queryString += " ORDER BY ?o";
		}
		*/
		
		//Add order by and sort by
		queryString += " GROUP BY ?o ORDER BY DESC(?num)";
		
		if( queryProperties.getLimit() != 0 ){
			queryString += " LIMIT " + Integer.toString( queryProperties.getLimit() );
		}
		if( queryProperties.getOffset() != 0 ){
			queryString += " OFFSET " + Integer.toString( queryProperties.getOffset() );
		}
		
		
		
		System.out.println(queryString);		
		Query query = QueryFactory.create(queryString);
    	QueryExecution queryExecution = QueryExecutionFactory.createServiceRequest(
    											service, query );
    	ResultSet resultSet = queryExecution.execSelect();
    	
		return entityCandidatesFromRS(resultSet, queryProperties.isLabel());
	}
	
	private List<Object> entityCandidatesFromRS(ResultSet resultSet, boolean label){
		List<Object> entityCandidates = new ArrayList<Object>();
		
		QuerySolution qs;
		if( label ){
			while( resultSet.hasNext() ){
	 			qs = resultSet.next();
				entityCandidates.add( new EntityCandidate(qs.get("o").toString(), qs.get("label").toString()) );
			}
		}
		else{
			while( resultSet.hasNext() ){
	 			qs = resultSet.next();
				entityCandidates.add( new EntityCandidate(qs.get("o").toString()) );
			}
		}
 		
		
		
		return entityCandidates;
	}

	@Override
	public List<Object> getAttributes(String entity, Properties queryProperties){
		boolean label = queryProperties.isLabel();
		int offset = queryProperties.getOffset();
		int limit = queryProperties.getLimit();
		
		String queryString = queryStringTemplate;
		queryString += "Select (count(?p) as ?num) ?p WHERE { ?s rdf:type/rdfs:subClassOf* <" + entity + ">." +
					   " ?s ?p ?o." + 
					   "FILTER ( regex(str(?p), 'http://dbpedia.org/property')). ";

		/*This doesn't work for some reason
		 *  " ?p a rdf:Property. " +
		 */
		// Checks should the sparql query ask for a rdfs:label
		// This should be used only if you are sure that there is a predicate
		// rdfs:label in the data source
		if( label ){
			queryString += "?p rdfs:label ?label. " + 
                           "FILTER (lang(?label) = 'en' || lang(?label) = '') ";
		}
		
		queryString += "}";
		/* For now I will disable order by, because it is very slow
		if( limit != 0 && offset != 0 ){
			queryString += " ORDER BY ?o";
		}
		*/
		
		//Add group by and order by
		queryString += "group by ?p order by desc(?num) ";
		
		if( limit != 0 ){
			queryString += " LIMIT " + Integer.toString( limit );
		}
		if( offset != 0 ){
			queryString += " OFFSET " + Integer.toString( offset );
		}	
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString);
    	QueryExecution queryExecution = QueryExecutionFactory.createServiceRequest(
    											service, query );
    	ResultSet resultSet = queryExecution.execSelect();

		return atributesFromRS(resultSet, label);
	}
	
	private List<Object> atributesFromRS(ResultSet resultSet, boolean label){
		List<Object> atributeCandidates = new ArrayList<Object>();
		
		QuerySolution qs;
		if( label ){
			while( resultSet.hasNext() ){
	 			qs = resultSet.next();
				atributeCandidates.add( new AttributeCandidate(qs.get("p").toString(), qs.get("label").toString()) );
			}
		}
		else{
			while( resultSet.hasNext() ){
				qs = resultSet.next();
	 			
				atributeCandidates.add( new AttributeCandidate(qs.get("p").toString()) );
			}
		}
 		
		
		
		return atributeCandidates;
	}

	@Override
	public List<Class> getType(String entity, String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getValues(String entity, String attributes[], Properties queryProperties) {
		String queryString = queryStringTemplate;
		boolean label = queryProperties.isLabel();
		int offset = queryProperties.getOffset();
		int limit = queryProperties.getLimit();
		
		
		queryString += "Select distinct ?s " + repeateString("?o", attributes.length) + 
					   " WHERE { ?s rdf:type/rdfs:subClassOf* <" + entity + ">.";
		
		for(int i = 0; i < attributes.length; i++){
			queryString += "?s" + " <" + attributes[i] + "> " + "?o" + i + ".";
		}
					   

		queryString += "}";
		/* For now I will disable order by, because it is very slow
		if( limit != 0 && offset != 0 ){
			queryString += " ORDER BY ?o ";
		}
		*/
		
		
		if( limit != 0 ){
			queryString += " LIMIT " + Integer.toString( limit );
		}
		if( offset != 0 ){
			queryString += " OFFSET " + Integer.toString( offset );
		}
        System.out.println(queryString);
        Query query = QueryFactory.create(queryString);
    	QueryExecution queryExecution = QueryExecutionFactory.createServiceRequest(
    											service, query );
    	ResultSet resultSet = queryExecution.execSelect();

		return valuesFromRS(resultSet, attributes);
	}
	
	private List<Object> valuesFromRS(ResultSet resultSet, String attributes[] ){
		List<Object> valueCandidates = new ArrayList<Object>();
		int numOfAttributes = attributes.length;
		
		QuerySolution qs;
		ValueCandidate valueCandidate;
		RDFNode node;
		String resourceName;
		while( resultSet.hasNext() ){
			qs = resultSet.next();
			valueCandidate = new ValueCandidate(qs.get("s").toString());
			
			for(int i = 0; i < numOfAttributes; i++){
				node = qs.get(String.format("?o%d", i));
				
				if( node.isResource() ){
					resourceName = node.asResource().getURI();
					valueCandidate.addOneValue(
							resourceName.substring(resourceName.lastIndexOf("/") + 1), 
							attributes[i]);
				}
				else{
					valueCandidate.addOneValue(node.toString(), attributes[i]);
				}
			}
			valueCandidates.add(valueCandidate);
		}
 		
		
		return valueCandidates;
	}
	
	private String repeateString(String s, int n){
		String out = " ";

        for(int i = 0; i < n; i++){
            out += s + i + " ";
        }
		
		return out;
	}
	
	public List<String> getAvailableEndpoints(){
		return null;
	}
}
