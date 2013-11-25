package com.etk.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Georgy
 * Date: 10.11.13
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class SELECTMain {
	
	
    public static void parse(InputStream is) throws Exception {
//        String inputFile = null;
//        if ( args.length>0 ) inputFile = args[0];
//        InputStream is = System.in;
//        if ( inputFile!=null ) {
//            is = new FileInputStream(inputFile);
//        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        SELECTLexer lexer = new SELECTLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SELECTParser parser = new SELECTParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.selectStmnt();

      /*  ParseTreeWalker walker = new ParseTreeWalker();
        XMLEmitter converter = new XMLEmitter();
        walker.walk(converter, tree);
        System.out.println(converter.getXML(tree));
    */
    }


    
}
