package com.etk.db.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/30/13
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Row {
    public Object getValue(int index);
    public int getLength();
}
