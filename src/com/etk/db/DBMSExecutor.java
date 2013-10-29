package com.etk.db;

import com.etk.db.query.QueryResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mladen
 * Date: 10/29/13
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DBMSExecutor {
    public List<QueryResult> executeQuery(String sqlQuery);

}
