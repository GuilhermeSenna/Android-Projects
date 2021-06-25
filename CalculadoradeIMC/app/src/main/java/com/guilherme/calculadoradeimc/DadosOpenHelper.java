package com.guilherme.calculadoradeimc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DadosOpenHelper extends SQLiteOpenHelper {
    public DadosOpenHelper(@Nullable Context context) {
        super(context, "Agrosafra.bd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL(ScriptDLLGerente.getCreateTablePermissao());  // Cria tabela Permissao
       sqLiteDatabase.execSQL(ScriptDLLGerente.getInsertTablePermissao1()); // Insere primeira permissao Admnistrador
       sqLiteDatabase.execSQL(ScriptDLLGerente.getInsertTablePermissao2()); // Insere segunda permsisao funcionário
       sqLiteDatabase.execSQL(ScriptDLLGerente.getCreateTable());           // Cria tabela Gerente
       sqLiteDatabase.execSQL(ScriptDLLCaixa.getCreateTable());             // Cria tabela Caixa
       sqLiteDatabase.execSQL(ScriptDLLCaixa.getInsertTableCaixa());        // Insere valor teste na tabela caixa
       sqLiteDatabase.execSQL(ScriptDLLFazenda.getCreateTable());           // Cria tabela Fazenda
       sqLiteDatabase.execSQL(ScriptDLLRoca.getCreateTable());              // Cria tabela Roça
       sqLiteDatabase.execSQL(ScriptDLLUsuario.getCreateTable());           // Cria tabela usuário
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
