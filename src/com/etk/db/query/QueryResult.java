package com.etk.db.query;

import java.util.List;

import com.etk.manager.schema.Type;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/29/13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface QueryResult {
    public String[] getAttributes();
    public Type[]   getAttributeTypes();
    public int getSize();
    public List<String[]> getData();
}
