package com.guilherme.calculadoradeimc;

public class ScriptDLLUsuario {
    public static String getCreateTable() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS USUARIO(");
        sql.append("CODIGO            INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append("GERENTEID         INTEGER    NOT NULL DEFAULT 1,");
        sql.append("NOME              VARCHAR (250) NOT NULL DEFAULT (' '),");
        sql.append("FOREIGN KEY (GERENTEID) REFERENCES GERENTE(CODIGO))");
        return sql.toString();
    }
}
