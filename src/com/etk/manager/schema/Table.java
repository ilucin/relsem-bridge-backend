package com.etk.manager.schema;

import com.etk.manager.schema.mappings.EntityMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by mladen on 11/9/13.
 */
public class Table {

    private String tableName; //mapping how?
    Map<String,Attribute> attributes;


    public String getName() {
        return tableName;
    }
}
