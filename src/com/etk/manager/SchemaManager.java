package com.etk.manager;

import com.etk.manager.schema.Schema;
import com.etk.manager.schema.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mladen on 11/9/13.
 */
public class SchemaManager {
    private Map<User,Schema> schemas = new HashMap<User,Schema>();


    public boolean validateQuery(String queryDescription, Schema schema) { //someinternal query tree...

        return true;
    }

    public void createSchema(User user) {
        schemas.put(user,new Schema(user));
    }

    public Schema getSchema(User user) {
        return schemas.get(user);
    }

}
