package com.guilherme.calculadoradeimc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.guilherme.calculadoradeimc.Gerente;

import java.util.ArrayList;
import java.util.List;

public class GerenteRepositorio {

    private SQLiteDatabase conexao;

    public GerenteRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public long inserir(Gerente gerente){
        long i;
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", gerente.nome);
        contentValues.put("EMAIL", gerente.email);
        contentValues.put("PASSWORD", gerente.password);

        i = conexao.insertOrThrow("GERENTE", null, contentValues);
        return i;
}

    public void excluir(int codigo){
        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);

        conexao.delete("AGROSAFRAS", "CODIGO = ?", parametros);
    }

    public void alterar(Gerente gerente){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", gerente.nome);
        contentValues.put("EMAIL", gerente.email);
        contentValues.put("PASSWORD", gerente.password);

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(gerente.codigo);

        conexao.update("AGROSAFRAS", contentValues, "CODIGO = ?", parametros);
    }

    public List<Gerente> buscarTodos(){
        List<Gerente> gerentes = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, NOME, EMAIL, PASSWORD, PERMISSAOID");
        sql.append("    FROM GERENTE");
        Cursor resultado = conexao.rawQuery(sql.toString(), null);

        if(resultado.getCount() > 0){
            resultado.moveToFirst();

            do{
                Gerente ger = new Gerente();

//                ger.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
                ger.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
                ger.nome = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
                ger.email = resultado.getString(resultado.getColumnIndexOrThrow("EMAIL"));
                ger.password = resultado.getString(resultado.getColumnIndexOrThrow("PASSWORD"));
                ger.permissaoID = resultado.getInt(resultado.getColumnIndexOrThrow("PERMISSAOID"));

                gerentes.add(ger);

            }while(resultado.moveToNext());
        }
        resultado.close();
        return gerentes;
    }

    public Gerente buscarGerente(int codigo){

        Gerente gerente = new Gerente();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, NOME, PASSWORD, EMAIL");
        sql.append("    FROM GERENTE");
        sql.append("    WHERE PERMISSAOID = ?");

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);

        Cursor resultado = conexao.rawQuery(sql.toString(), parametros);

        if(resultado.getCount() > 0){
            resultado.moveToFirst();

            gerente.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
            gerente.nome = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
            gerente.email = resultado.getString(resultado.getColumnIndexOrThrow("EMAIL"));
            gerente.password = resultado.getString(resultado.getColumnIndexOrThrow("PASSWORD"));

            return gerente;
        }


        resultado.close();
        return null;
    }
}
