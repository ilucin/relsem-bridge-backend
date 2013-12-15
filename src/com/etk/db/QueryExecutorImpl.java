package com.etk.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etk.data.DataSource;
import com.etk.data.RemoteSourceRDF;
import com.etk.data.ValueCandidate;
import com.etk.data.query.Properties;
import com.etk.db.exceptions.RelsemDBException;
import com.etk.db.model.RowCollection;
import com.etk.db.model.Table;
import com.etk.db.query.QueryResult;
import com.etk.manager.schema.Attribute;
import com.etk.manager.schema.Schema;
import com.etk.manager.schema.UserTable;
import com.etk.parser.ProjectionCell;
import com.etk.parser.SelectObject;

public class QueryExecutorImpl implements DBMSExecutor {
	
	private Schema schema;
	private DataSource dataSource;
	
	
	public QueryExecutorImpl(Schema schema) {
		this.schema = schema;
		this.dataSource = new RemoteSourceRDF("http://dbpedia.org/sparql");
	}
	

	@Override
	public List<QueryResult> executeQuery(SelectObject sqlQuery)
			throws RelsemDBException {
		
		if(!validateQuery(sqlQuery)) {
			//return empty, raise exception, whatever
			//check attribute ambiguity
			//whether tables are prefixed
			
			System.out.println("Query validation failed!");
			return new ArrayList<QueryResult>();
		}
		
		//both from projectionCells and free attributes WITHOUT ID
		Map<String,List<Attribute>> attributes = new HashMap<String,List<Attribute>>();
		Map<String,Boolean> idRequested = new HashMap<String,Boolean>();
		Map<String,List<ValueCandidate>> values = new HashMap<String,List<ValueCandidate>>();
		
		
		for(String rTable : sqlQuery.getTableNames()) {
			UserTable uTable = schema.getTable(rTable.toLowerCase());
			Map<String,Attribute> tAttributes = uTable.getAttributes();
			
			List<Attribute> rAttributes = new ArrayList<Attribute>();
			
			String tableName = uTable.getTableName();
			String tableId = uTable.getIdAttribute();
			boolean requested = false;
			
			
			//if there exists projectionCell for given table, add it to attributes for that table
			if(sqlQuery.getPrefColNames() != null) {
				for(ProjectionCell pc : sqlQuery.getPrefColNames()) {
					String prefix = pc.getPrefix().toLowerCase();
					if(prefix.equals(tableName)) {
						if(pc.getColumnName().equalsIgnoreCase(tableId)) {  // if its the table id, dont add to attributes
							requested = true;
						} else {
							rAttributes.add(tAttributes.get(pc.getColumnName().toLowerCase()));
						}
					}
				}
			}
			
			//if given table has any of the requeset attributes, add the to attributes for that table
			if(sqlQuery.getNoPrefColNames() != null) {
				for(String rAttr : sqlQuery.getNoPrefColNames()) {
					if(tAttributes.containsKey(rAttr.toLowerCase())) {
						rAttributes.add(tAttributes.get(rAttr.toLowerCase()));
					} else if (rAttr.equalsIgnoreCase(tableId)) {
						requested = true;
					}
				}
			}
			
		
			
			idRequested.put(tableName, requested);
			attributes.put(tableName, rAttributes);
			
			values.put(tableName, getValues(attributes.get(tableName),idRequested.get(tableName),uTable.getEntityUri()));
			
		}
		
		
		
		
		
		return null;
	} 
	
	private List<ValueCandidate> getValues(List<Attribute> attributes,
			Boolean idReq, String entityUri) {
		
		String[] attrUris = new String[attributes.size()];
		for(int i=0;i<attributes.size();i++) {
			attrUris[i] = attributes.get(i).getUri();
		}
		Properties qProp = new Properties(20, 0, false);
		List<ValueCandidate> vcs = new ArrayList<>();
		for(Object o : this.dataSource.getValues(entityUri, attrUris, qProp)) {
			vcs.add((ValueCandidate)o);
		}
		
		return vcs;
		
	}


	public boolean validateQuery(SelectObject sqlQuery) {
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


//List<String> reqTables = sqlQuery.getTableNames();
//
//List<String> reqAttributes = sqlQuery.getNoPrefColNames();
//List<ProjectionCell> reqProjectionCells = sqlQuery.getPrefColNames();
//
////liste attributa za danu tablicu
//Map<String,List<Attribute>> tableAttributesMap = new HashMap<String,List<Attribute>>();
//Map<String,List<Object>> tableSelects = new HashMap<>();  //valueCandidates for table and projection 
//Map<String,Boolean> reqId = new HashMap<String,Boolean>();
//

//
//
//
//
////fill reqProjection 
//		//for each requested table, load all domain attributes and fill into reqProject 
//		for(String rTable : reqTables) {
//			UserTable t = schema.getTable(rTable);
//			Map<String,Attribute> tAttributes = t.getAttributes();
//			tableAttributesMap.put(t.getTableName(), new ArrayList<Attribute>());
//			//this loop should go throguh request attributes, not table ones
//			
//			//for all table attributes, pass it on if it is requested by query
//			for(String aName : tAttributes.keySet()) {
//				Attribute a = tAttributes.get(aName);
//				if(reqAttributes.contains(a.getName())) {
//					tableAttributesMap.get(t.getTableName()).add(a);
//				}
//				//check the projection cells too
//				
//			}
//			//pass only the table attributes requested as projectionCells
//			for(ProjectionCell pc : reqProjectionCells) {
//				if(pc.getPrefix().toLowerCase().equals(t.getTableName())) {
//					tableAttributesMap.get(t.getTableName()).add(tAttributes.get(pc.getColumnName())); //UGH?!
//				}
//			}
//			
//		}
//		
//		
//		
//		for(String table : tableAttributesMap.keySet()) {
//			List<Attribute> tableAttributes = tableAttributesMap.get(table);
//			
//			String[] attrUris = new String[tableAttributes.size()];
//			for(int i=0;i<tableAttributes.size();i++) {
//				attrUris[i] = tableAttributes.get(i).getUri();
//			}
//			String entityUri = schema.getTable(table).getEntityUri();
//			Properties qProp = new Properties(20, 0, false);
//			
//			tableSelects.put(table, this.dataSource.getValues(entityUri, attrUris, qProp) );
//			
//		}
//		
//		//convert lists of valueCandidates to rowCollections and join
//		Map<String, RowCollection> dataCollections = new HashMap<String, RowCollection>();
//		
//		for(String table : tableSelects.keySet()) {
//			RowCollection rc ;
//			
//			List<Object> valueCandidates = tableSelects.get(table);
//			for(Object vC : valueCandidates) {
//				ValueCandidate val = (ValueCandidate) vC;
//				System.out.println(val.getValues());
//				//val is a map with attribute uris as keys
//				//create rows with attributes ordered as in domaintTable
//				
//				
//			}
//		}
