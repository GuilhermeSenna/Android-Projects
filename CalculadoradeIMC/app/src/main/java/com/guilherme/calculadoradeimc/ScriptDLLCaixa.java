package com.guilherme.calculadoradeimc;

public class ScriptDLLCaixa {
    public static String getCreateTable() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS CAIXA(");
        sql.append("CODIGO            INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append("TIPO              VARCHAR (250) NOT NULL DEFAULT (' '))");
        return sql.toString();
    }

    public static String getInsertTableCaixa(){
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO CAIXA(TIPO) VALUES ('Cilindrica')");

        return sql.toString();
    }

}
