package com.guilherme.calculadoradeimc;

public class CriarTabelaPermissao {
    public static String getCreateTableClient(){
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS GERENTE(");
        sql.append("CODIGO    INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append("NOME      VARCHAR (250) NOT NULL DEFAULT (' '),");
        return sql.toString();
    }
}
