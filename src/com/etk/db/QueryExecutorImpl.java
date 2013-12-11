package com.etk.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etk.data.DataSource;
import com.etk.data.ValueCandidate;
import com.etk.data.query.Properties;
import com.etk.db.exceptions.RelsemDBException;
import com.etk.db.model.RowCollection;
import com.etk.db.model.Table;
import com.etk.db.query.QueryResult;
import com.etk.manager.schema.Attribute;
import com.etk.manager.schema.Schema;
import com.etk.manager.schema.UserTable;
import com.etk.parser.SelectObject;

public class QueryExecutorImpl implements DBMSExecutor {
	
	private Schema schema;
	private DataSource dataSource;
	
	
	
	

	@Override
	public List<QueryResult> executeQuery(SelectObject sqlQuery)
			throws RelsemDBException {
		
		if(!validateQuery(sqlQuery)) {
			//return empty, raise exception, whatever
			System.out.println("Query validation failed!");
			return new ArrayList<QueryResult>();
		}
		
		//create a map requested tables
		List<String> reqTables = sqlQuery.getTableNames();
		
		//liste attributa za danu tablicu
		Map<String,List<Attribute>> reqProjection = new HashMap<String,List<Attribute>>();
		
		Map<String,List<Object>> tableSelects = new HashMap<>();  //valueCandidates for table and projection  
		
		
		//fill reqProjection 
		//for each requested table, load all domain attributes and fill into reqProject 
		for(String rTable : reqTables) {
			UserTable t = schema.getTable(rTable);
			Map<String,Attribute> tAttributes = t.getAttributes();
			reqProjection.put(t.getTableName(), new ArrayList<Attribute>());
			for(String aName : tAttributes.keySet()) {
				Attribute a = tAttributes.get(aName);
				reqProjection.get(t.getTableName()).add(a);
			}
		}
		
		
		for(String table : reqProjection.keySet()) {
			List<Attribute> reqAttributes = reqProjection.get(table);
			
			String[] attrUris = new String[reqAttributes.size()];
			for(int i=0;i<reqAttributes.size();i++) {
				attrUris[i] = reqAttributes.get(i).getUri();
			}
			String entityUri = schema.getTable(table).getEntityUri();
			Properties qProp = new Properties(20, 0, false);
			
			tableSelects.put(table, this.dataSource.getValues(entityUri, attrUris, qProp) );
			
		}
		
		//convert lists of valueCandidates to rowCollections and join
		Map<String, RowCollection> dataCollections = new HashMap<String, RowCollection>();
		
		for(String table : tableSelects.keySet()) {
			RowCollection rc ;
			
			List<Object> valueCandidates = tableSelects.get(table);
			for(Object vC : valueCandidates) {
				ValueCandidate val = (ValueCandidate) vC;
				//val is a map with attribute uris as keys
				//create rows with attributes ordered as in domaintTable
				
				
			}
		}
		
		
		
		return null;
	} 
	
	public boolean validateQuery(SelectObject sqlQuery) {
		Collection<UserTable> tables = schema.getTables();
		List<String> queryTables = sqlQuery.getTableNames();
		
		for(String qTable : queryTables) {
			if(!schema.hasTable(qTable)) {
//				throw new RelsemDBException("Table \""+qTable+"\" does not exist within user schema!"");
				System.out.println("Table \""+qTable+"\" does not exist within user schema!");
				return false;
			}
		}
		
		//TODO fix vaidation based on tables of requested attributes
//		for(String qAttr : sqlQuery.getColumnNames()) {
//		}
		
		
		
		return true;
	}

}
