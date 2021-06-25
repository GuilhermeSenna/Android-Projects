package com.guilherme.calculadoradeimc;

public class ScriptDLLRoca {
    public static String getCreateTable() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS ROCA( ");
            sql.append("CODIGO                 INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL, ");
            sql.append("NOME                   VARCHAR (250) NOT NULL DEFAULT (' '), ");
            sql.append("FAZENDAID              INTEGER    NOT NULL DEFAULT 1, ");
            sql.append("AREA                   REAL NOT NULL DEFAULT (0.0), ");
            sql.append("PLANTASTOTAL           INTEGER NOT NULL, ");
            sql.append("PLANTASAMOSTRADAS      INTEGER NOT NULL, ");
            sql.append("METAPRODUCAO           REAL NOT NULL, ");
            sql.append("FOREIGN KEY (FAZENDAID) REFERENCES FAZENDA(codigo)) ");
        return sql.toString();
    }
}
