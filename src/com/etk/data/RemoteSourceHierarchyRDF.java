package com.etk.data;

import java.util.ArrayList;
import java.util.List;



import com.etk.data.query.Expression;
import com.etk.data.query.Operator;
import com.etk.data.query.OperatorMapping;
import com.etk.data.query.Properties;
import com.etk.data.query.SelectionClause;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.reasoner.rulesys.builtins.Regex;

public class RemoteSourceHierarchyRDF implements DataSource{
	String service;
	String queryStringTemplate;
	String defaultDataSetName;
	
	public RemoteSourceHierarchyRDF( String service ){
		this.service = service;
		this.defaultDataSetName = null;
		queryStringTemplate = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
					  		  "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " + 
					  		  "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> ";
	}
	
	public RemoteSourceHierarchyRDF( String service, String defaultDataSetName ){
		this(service);
		this.defaultDataSetName = defaultDataSetName;
	}
	
	
	@Override
	public List<Object> getEntityCandidates(Properties queryProperties) {
		String queryString = queryStringTemplate;
		queryString += "SELECT DISTINCT (count(?o) as ?num) ?o ";
		if(defaultDataSetName != null){
			queryString += "FROM <" + defaultDataSetName + "> ";
		}
		queryString += "WHERE { ";
		
  	    if( queryProperties.getEntitySuperClass() != null ){
  	    	queryString += "?o rdfs:subClassOf{" + queryProperties.getDepthFrom() + "," + 
  	    				   queryProperties.getDepthTo() + "} " +
  	    				   "<" + queryProperties.getEntitySuperClass() + ">. }";
  	    }
  	    else{
  	    	queryString += "?s rdfs:subClassOf ?o. " +
					   	   "FILTER NOT EXISTS { ?o rdfs:subClassOf ?o2 }. }";
  	    }  	   
		
		//Add order by and sort by
		queryString += " GROUP BY ?o ORDER BY DESC(?num)";
		
		if( queryProperties.getLimit() != 0 ){
			queryString += " LIMIT " + Integer.toString( queryProperties.getLimit() );
		}
		if( queryProperties.getOffset() != 0 ){
			queryString += " OFFSET " + Integer.toString( queryProperties.getOffset() );
		}
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
    	QueryExecution queryExecution = QueryExecutionFactory.createServiceRequest(
    											service, query );
    	ResultSet resultSet = queryExecution.execSelect();
    	
		return entityCandidatesFromRS(resultSet, queryProperties.isLabel());
	}
	
	
	private List<Object> entityCandidatesFromRS(ResultSet resultSet, boolean label){
		List<Object> entityCandidates = new ArrayList<Object>();
		
		QuerySolution qs;
		while( resultSet.hasNext() ){
 			qs = resultSet.next();
			entityCandidates.add( new EntityCandidate(qs.get("o").toString()) );
		}
		return entityCandidates;
	}

	@Override
	public List<Object> getAttributes(String entity, Properties queryProperties) {
		String queryString = queryStringTemplate;
		queryString += "Select (count(?p) as ?num) ?p ";
		if(defaultDataSetName != null){
			queryString += "FROM <" + defaultDataSetName + "> ";
		}
		queryString += " WHERE { ?s rdf:type/rdfs:subClassOf* <" + entity + ">." +
				   	   " ?s ?p ?o." + 
				       " ?p a rdf:Property.}";
		
		//Add group by and order by
		queryString += "group by ?p order by desc(?num) ";
		
		if( queryProperties.getLimit() != 0 ){
			queryString += " LIMIT " + Integer.toString( queryProperties.getLimit() );
		}
		if( queryProperties.getOffset() != 0 ){
			queryString += " OFFSET " + Integer.toString( queryProperties.getOffset() );
		}	
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
    	QueryExecution queryExecution = QueryExecutionFactory.createServiceRequest(
    											service, query );
    	ResultSet resultSet = queryExecution.execSelect();

		return atributesFromRS(resultSet, queryProperties.isLabel());
	}
	
	private List<Object> atributesFromRS(ResultSet resultSet, boolean label){
		List<Object> atributeCandidates = new ArrayList<Object>();
		
		QuerySolution qs;
		while( resultSet.hasNext() ){
			qs = resultSet.next();
 			
			atributeCandidates.add( new AttributeCandidate(qs.get("p").toString()) );
		}
		return atributeCandidates;
	}

	@Override
	public String getType(String entity, String attribute) {
		String type = "string";
		String attributes[] = {attribute};
		Properties queryProperties = new Properties();
		queryProperties.setLimit(1);
		
		List<Object> values = getValues(entity, attributes, queryProperties, null);
		ValueCandidate vCan = (ValueCandidate) values.get(0);
		String toTest = vCan.getValues().get(attribute);
		
		try{
			Integer.parseInt(toTest);
			type = "integer";
		}
		catch(Exception e){
			//Do nothing
		}
		
		try{
			Double.parseDouble(toTest);
			type = "real";
		}
		catch(Exception e){
			//Do nothing
		}
		
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public List<Object> getValues(String entity, String attributes[], Properties queryProperties, Expression whereExpression) {
		String queryString = queryStringTemplate;
		queryString += "Select distinct ?s " + repeateString("?o", attributes.length) + 
					   " WHERE { ?s rdf:type/rdfs:subClassOf* <" + entity + ">.";
		
		for(int i = 0; i < attributes.length; i++){
			queryString += "?s" + " <" + attributes[i] + "> " + "?o" + i + ".";
		}
		
		if(whereExpression != null){
			String operatorOuter = OperatorMapping.getOperator(whereExpression.getOperator());
			String operatorInner;
			
			List<SelectionClause> clauses = whereExpression.getClauses();
			
			String toAppend = "FILTER( ";
			for(SelectionClause one : clauses){
				if( one.isNegated() ){
					toAppend += "!";
				}
				toAppend += "( ";
				
				if( one.getOperator() != Operator.LIKE ){
					operatorInner = OperatorMapping.getOperator(one.getOperator());
					toAppend += "xsd:double(" + variableForAttribute(attributes, one.getAttribute()) + 
							    ")" + operatorInner + one.getValue() + ") ";
				}
				else{
					toAppend += "regex(" + variableForAttribute(attributes, one.getAttribute()) +
								"," + regexFromLike(one.getValue().toString())  + "))";
					
				}
				
				toAppend += operatorOuter;
			}
			toAppend = toAppend.substring(0, toAppend.length() - operatorOuter.length()) + ")";
			System.out.println(toAppend);
			queryString += toAppend;
		}
					   

		queryString += "}";
		/* For now I will disable order by, because it is very slow
		if( limit != 0 && offset != 0 ){
			queryString += " ORDER BY ?o ";
		}
		*/
		
		
		if( queryProperties.getLimit() != 0 ){
			queryString += " LIMIT " + Integer.toString( queryProperties.getLimit() );
		}
		if( queryProperties.getOffset() != 0 ){
			queryString += " OFFSET " + Integer.toString( queryProperties.getOffset() );
		}		
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
    	QueryExecution queryExecution = QueryExecutionFactory.createServiceRequest(
    											service, query );
    	ResultSet resultSet = queryExecution.execSelect();

		return valuesFromRS(resultSet, attributes);
	}
	
	private String regexFromLike(String sqlString){
		String tmp = sqlString;
		
		tmp = tmp.replaceAll("%", ".*");
		tmp = tmp.replaceAll("_", ".");
		
		return "'^" + tmp + "$'";
	}
	
	private String variableForAttribute(String attributes[], String attribute){
		int index = java.util.Arrays.asList(attributes).indexOf(attribute);
		return "?o" + index;
	}
	
	private List<Object> valuesFromRS(ResultSet resultSet, String attributes[] ){
		List<Object> valueCandidates = new ArrayList<Object>();
		int numOfAttributes = attributes.length;
		
		QuerySolution qs;
		ValueCandidate valueCandidate;
		RDFNode node;
		while( resultSet.hasNext() ){
			qs = resultSet.next();
			valueCandidate = new ValueCandidate(qs.get("s").toString());
			
			for(int i = 0; i < numOfAttributes; i++){
				node = qs.get(String.format("?oo%d", i));
				valueCandidate.addOneValue(node.toString(), attributes[i]);
			}
			
			valueCandidates.add(valueCandidate);
		}
 		
		
		return valueCandidates;
	}
	
	private String repeateString(String s, int n){
		String out = " ";
		
		for(int i = 0; i < n; i++){
			out += "(str(" + s + i + ") AS " + s + 'o' + i + ") ";
		}
		
		return out;
	}
	
	public List<String> getAvailableEndpoints(){
		return null;
	}

	
}
