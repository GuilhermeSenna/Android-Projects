package com.guilherme.calculadoradeimc;

public class ScriptDLLGerente {
    public static String getCreateTable(){
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS GERENTE(");
            sql.append("CODIGO    INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL,");
            sql.append("NOME      VARCHAR (250) NOT NULL DEFAULT (' '),");
            sql.append("EMAIL     VARCHAR (200) NOT NULL DEFAULT (' '),");
            sql.append("PASSWORD  VARCHAR (50) NOT NULL DEFAULT  (' '),");
            sql.append("PERMISSAOID  INTEGER DEFAULT 1, ");
            sql.append("FOREIGN KEY(PERMISSAOID) REFERENCES PERMISSAO(CODIGO) )");

        return sql.toString();
    }

    public static String getCreateTablePermissao(){
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS PERMISSAO(");
        sql.append("CODIGO    INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append("NOME      VARCHAR (250) NOT NULL UNIQUE DEFAULT (' ') )");

        return sql.toString();
    }

    public static String getInsertTablePermissao1(){
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO PERMISSAO(NOME) VALUES ('Administrador')");

        return sql.toString();
    }

    public static String getInsertTablePermissao2(){
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO PERMISSAO(NOME) VALUES ('Funcionario')");

        return sql.toString();
    }
}
