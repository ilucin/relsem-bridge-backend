package com.etk.parser;

/**
 * Created with IntelliJ IDEA.
 * User: Georgy
 * Date: 10.11.13
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class SELECTMain {

    public static void main(String[] args) throws Exception {
       SelectQueryToObject selectQueryToObject = new SelectQueryToObject(args);
       SelectObject selectObject = selectQueryToObject.getSelectObject();
       for(String columnName : selectObject.getColumnNames()){
           System.out.println("Column: " + columnName);
       }

       for(String tableName : selectObject.getTableNames()){
           System.out.println("Table: " + tableName);
       }
    }
}
