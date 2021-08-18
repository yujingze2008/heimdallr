package com.gitee.fun2code.jsql;

import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.List;

public class SQLParserTest {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/yujingze/IdeaProjects/heimdallr/heimdallr-test/src/main/java/com/gitee/fun2code/jsql/TABLE_RISK_DWS_TAB2.sql");
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuffer sql = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            sql.append(line);
            sql.append("\n");
        }
        br.close();
        //System.out.println(sql);
        //Select model = (Select) CCJSqlParserUtil.parse(sql.toString());
        //CreateTable model = (CreateTable) CCJSqlParserUtil.parse(sql.toString());
        /*Drop model = (Drop) CCJSqlParserUtil.parse(sql.toString());
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();

        List tables = tablesNamesFinder.getTableList(model);
        System.out.println(tables.size());*/

        CCJSqlParserManager parserManager = new CCJSqlParserManager();

        CreateTable createTable = (CreateTable) parserManager.parse(new StringReader(sql.toString()));
        //System.out.println(createTable.getTable().getName());

        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        List tables = tablesNamesFinder.getTableList(createTable);

        System.out.println(tables.get(0));
    }

}
