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
    private Map<String, UserTable> tables;

    public Schema(User owner) {
        this.owner = owner;
        this.tables = new HashMap<String, UserTable>();
    }

    public Collection<UserTable> getTables() {
        return tables.values();
    }

    public void addTable(UserTable table) {
        this.tables.put(table.getTableName(),table);
    }

    public void removeTable(String table) {
        this.tables.remove(table);
    }

    public UserTable getTable(String name) {
        return tables.get(name);
    }

}
