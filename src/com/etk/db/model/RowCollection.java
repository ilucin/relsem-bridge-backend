package com.etk.db.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/30/13
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RowCollection {
    public Collection<Row> getRows();
    public Set<String> getAttributes();
    public Class getType(String attribute);     //do i need it?
    public int getAttributeIndex(String attribute);
}
