package com.etk.data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/29/13
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DataSource {
    public List<String> getEntityCandidates();
    public List<String> getAttributes(String entity);
    public List<Class> getType(String entity, String attribute);
    public List<Object> getValues(String entity, String attribute);

}
