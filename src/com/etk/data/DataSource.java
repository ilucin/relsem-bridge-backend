package com.etk.data;

import com.etk.manager.schema.Attribute;
import com.etk.manager.schema.Type;
import com.etk.manager.schema.mappings.AttributeMapping;
import com.etk.manager.schema.mappings.EntityMapping;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/29/13
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DataSource {
    public List<EntityMapping> getEntityCandidates();
    public List<AttributeMapping> getAttributes(EntityMapping entity);
    public Type getType(String entity, String attribute);
    public List<Object> getValues(EntityMapping entity, AttributeMapping attribute);

}
