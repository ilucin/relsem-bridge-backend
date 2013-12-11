package com.etk.db.model;

import java.util.Collection;
import java.util.Set;

/**
 * Created by mladen on 12/4/13.
 */
public class ProjectedRowCollection implements RowCollection{
    public ProjectedRowCollection(RowCollection collection,String[] attributes) {

    }

    @Override
    public Collection<Row> getRows() {
        return null;
    }

    @Override
    public Set<String> getAttributes() {
        return null;
    }

    @Override
    public Class getType(String attribute) {
        return null;
    }

    @Override
    public int getAttributeIndex(String attribute) {
        return 0;
    }
}