package com.etk.data;

import java.util.List;

import com.etk.data.query.Properties;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;

public class RemoteSourceRDF extends AbstractRemoteSourceRDF{
	public RemoteSourceRDF(String service, String defaultDataSetName) {
		super(service, defaultDataSetName);
	}
	
	public RemoteSourceRDF(String service) {
		this(service, null);
	}
	
	@Override
	public List<Object> getEntityCandidates(Properties queryProperties) {
		String queryString = queryStringTemplate;
		
		queryString += "SELECT DISTINCT (count(?" + entityVariable + ") as ?num) ?" +
					    entityVariable + " ";
		if(defaultDataSetName != null){
			queryString += "FROM <" + defaultDataSetName + "> ";
		}
		queryString += "WHERE { ?s a ?" + entityVariable + ". }";
		
		//Add order by and sort by
				queryString += " GROUP BY ?" + entityVariable + " ORDER BY DESC(?num)";
		
		if( queryProperties.getLimit() != 0 ){
			queryString += " LIMIT " + Integer.toString( queryProperties.getLimit() );
		}
		if( queryProperties.getOffset() != 0 ){
			queryString += " OFFSET " + Integer.toString( queryProperties.getOffset() );
		}
				
		Query query = QueryFactory.create(queryString, Syntax.syntaxARQ);
    	QueryExecution queryExecution = QueryExecutionFactory.createServiceRequest(
    											service, query );
    	ResultSet resultSet = queryExecution.execSelect();
    	
		return entityCandidatesFromRS(resultSet);
	}
}