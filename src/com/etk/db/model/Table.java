package com.etk.db.model;

import com.etk.db.exceptions.RelsemDBException;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/30/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Table implements RowCollection {

    Map<String,Integer> attributePositions;

    List<Row> rows;

    public Table(String[] attributes,Collection<Row> rows) {   //test purposes
        attributePositions = new HashMap<String,Integer>();
        for(int i = 0 ; i < attributes.length ; i++) {
            attributePositions.put(attributes[i].toUpperCase(),i);
        }
        this.rows = new ArrayList<Row>(rows);
    }


    @Override
    public Collection<Row> getRows() {
       return rows;
    }

    @Override
    public Set<String> getAttributes() {
        return attributePositions.keySet();
    }


    @Override
    public Class getType(String attribute) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getAttributeIndex(String attribute) {
        return attributePositions.get(attribute.toUpperCase());
    }

    @Override
    public String toString() {
        return attributePositions.toString();
    }

}
