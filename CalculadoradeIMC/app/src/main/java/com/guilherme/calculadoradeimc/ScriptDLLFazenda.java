package com.guilherme.calculadoradeimc;

public class ScriptDLLFazenda {
    public static String getCreateTable() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS FAZENDA(");
            sql.append("CODIGO            INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL,");
            sql.append("GERENTEID         INTEGER    NOT NULL DEFAULT 1,");
            sql.append("CAIXAID           INTEGER    NOT NULL DEFAULT 1,");
            sql.append("NOME              VARCHAR (250) NOT NULL DEFAULT (' '),");
            sql.append("PROPRIETARIO      VARCHAR (250) NOT NULL DEFAULT (' '),");
            sql.append("MUNICIPIO         VARCHAR (200) NOT NULL DEFAULT (' '),");
            sql.append("AREA              REAL NOT NULL DEFAULT (0.0),");
            sql.append("TAXA              REAL (50) NOT NULL DEFAULT  (' '),");
            sql.append("FOREIGN KEY (GERENTEID) REFERENCES GERENTE(codigo),");
            sql.append("FOREIGN KEY (CAIXAID) REFERENCES CAIXA(codigo))");
        return sql.toString();
    }
}
