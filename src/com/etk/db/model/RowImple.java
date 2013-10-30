package com.etk.db.model;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/30/13
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class RowImple implements Row {
    private Object[] values;

    public RowImple(Object[] values) {
        this.values = values;
    }


    @Override
    public Object getValue(int index) {
        return values[index];
    }

    @Override
    public int getLength() {
        return values.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<values.length; i++) {
            sb.append(values[i].toString() +"  ");
        }
        return sb.toString();
    }
}
