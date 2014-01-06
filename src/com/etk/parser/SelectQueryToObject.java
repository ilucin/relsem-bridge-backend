package com.etk.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Georgy
 * Date: 18.11.13
 * Time: 18:29
 * To change this template use File | Settings | File Templates.
 */
public class SelectQueryToObject extends SELECTBaseListener {

    private SelectObject selectObject;

    public SelectQueryToObject(InputStream parseString) throws Exception {
        selectObject = new SelectObject();


        if ( parseString!= null ) {
            ANTLRInputStream input = new ANTLRInputStream(parseString);
            SELECTLexer lexer = new SELECTLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SELECTParser parser = new SELECTParser(tokens);
            parser.setBuildParseTree(true);
            ParseTree tree = parser.selectStmnt();

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this, tree);
        }

    }

    @Override public void exitColumnInTable(@NotNull SELECTParser.ColumnInTableContext ctx) {
        String tableName = ctx.tableName().getText();
        String columnName = ctx.columnName().getText();
        ProjectionCell projectionCell = new ProjectionCell(tableName, columnName);
        selectObject.addPrefColNames(projectionCell);
    }

    @Override public void exitFreeColumn(@NotNull SELECTParser.FreeColumnContext ctx) {
        String freeColumnName = ctx.columnName().getText();
        selectObject.addNoPrefColName(freeColumnName);
    }
   /* public void exitDerivedColumn(@NotNull SELECTParser.DerivedColumnContext ctx) {
        selectObject.addFreeColumnName(ctx.columnName().getText());
    }
    */
    public void enterTablePrimary(@NotNull SELECTParser.TablePrimaryContext ctx) {
        selectObject.addTableName(ctx.tableName().getText());
    }

    public SelectObject getSelectObject(){
        return this.selectObject;
    }


}
