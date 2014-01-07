package com.etk.data;

import com.etk.data.query.Expression;
import com.etk.data.query.Properties;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/29/13
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DataSource {
    public List<Object> getEntityCandidates(Properties queryProperties);
    public List<Object> getAttributes(String entity, Properties queryProperties);
    public String getType(String entity, String attribute);
    public List<Object> getValues(String entity, String attributes[], Properties queryProperties, Expression whereExpression);
    public List<String> getAvailableEndpoints();
}
