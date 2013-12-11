package com.etk.manager.schema;

import com.etk.manager.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

    public Collection<Table> getTables() {
        return tables.values();
    }

    public void addTable(Table table) {
        this.tables.put(table.getTableName(),table);
    }

    public void removeTable(String table) {
        this.tables.remove(table);
    }

    public Table getTable(String name) {
        return tables.get(name);
    }

}
