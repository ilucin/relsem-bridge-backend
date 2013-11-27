package com.etk.parser;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Georgy
 * Date: 18.11.13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class SelectObject {
    ArrayList<String> columnNames;
    ArrayList<String> tableNames;

    public SelectObject(){

    }

    public void addColumnName(String columnName){
        if(columnNames == null){
            columnNames = new ArrayList<String>();
        }
        this.columnNames.add(columnName);
    }

    public ArrayList<String> getColumnNames(){
        return this.columnNames;
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
