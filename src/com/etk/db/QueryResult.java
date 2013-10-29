package com.etk.db;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/29/13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface QueryResult {
    public List<String> getAttributes();
    public List<Class>   getAttributeTypes();

    public Object getValue(String attribute);
}
