package com.etk.manager.schema;

import com.etk.manager.schema.mappings.EntityMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mladen on 11/9/13.
 */
public class Table {

    private String tableName; //mapping how?
    Map<String,Attribute> attributes;
    private String entityUri;
    private String entityLabel;

    public Table(String name, String entityUri, String entityLabel) {
        this.tableName = name;
        this.entityUri = entityUri;
        this.entityLabel = entityLabel;
        this.attributes = new HashMap<String,Attribute>();
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.put(attribute.getName(),attribute);
    }

    public String getTableName() {
        return tableName;
    }

    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    public String getEntityUri() {
        return entityUri;
    }

    public String getEntityLabel() {
        return entityLabel;
    }
}
