package com.etk.parser;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Georgy
 * Date: 18.11.13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class SelectObject implements ParserInterface {
    private ArrayList<String> noPrefColNames;
    private ArrayList<ProjectionCell> prefColNames;
    private ArrayList<String> tableNames;

    public SelectObject(){

    }

    public void addFreeColumnName(String noPrefColName){
        if(noPrefColNames == null){
            noPrefColNames = new ArrayList<String>();
        }
        this.noPrefColNames.add(noPrefColName);
    }

    public ArrayList<String> getNoPrefColNames(){
        return this.noPrefColNames;
    }

    public void addPrefColNames(ProjectionCell prefColName) {
        if(prefColNames == null){
            prefColNames = new ArrayList<ProjectionCell>();
        }
        this.prefColNames.add(prefColName);
    }

    public ArrayList<ProjectionCell> getPrefColNames() {
        return prefColNames;
    }

    public void addTableName(String tableName){
        if(tableNames == null){
            tableNames = new ArrayList<String>();
        }
        this.tableNames.add(tableName);
    }

    public ArrayList<String> getTableNames(){
        return this.tableNames;
    }


}
