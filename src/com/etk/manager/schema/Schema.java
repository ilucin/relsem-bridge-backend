package com.etk.manager.schema;

import com.etk.manager.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mladen on 11/9/13.
 */
public class Schema {
    private User owner;
    private Map<String, Table> tables;

    public Schema(User owner) {
        this.owner = owner;
        this.tables = new HashMap<String, Table>();
    }


    public void addTable(Table table) {
        this.tables.put(table.getName(),table);
    }


}
