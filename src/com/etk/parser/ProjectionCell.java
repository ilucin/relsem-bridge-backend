package com.etk.parser;

/**
 * Created with IntelliJ IDEA.
 * User: Georgy
 * Date: 08.12.13
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public class ProjectionCell {
    private String prefix;
    private String columnName;

    public ProjectionCell(String prefix, String columnName){
        this.prefix = prefix;
        this.columnName = columnName;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getColumnName() {
        return columnName;
    }

}
