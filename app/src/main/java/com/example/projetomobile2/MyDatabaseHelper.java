package com.example.projetomobile2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "ListaDeAlunos.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "alunos";
    private static final String COLUNA_ID = "id";
    private static final String ALUNO_NOME = "nome_aluno";
    private static final String COLUNA_CLASSE = "classe_aluno";
    private static final String COLUNA_ANO = "ano_letivo";
    private static final String COLUNA_DISCIPLINA = "disciplina";



    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ALUNO_NOME + " TEXT, " +
                        COLUNA_CLASSE + " TEXT, " +
                        COLUNA_ANO + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addAlunos(String nome, String classe, int ano ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ALUNO_NOME, nome);
        cv.put(COLUNA_CLASSE, classe);
        cv.put(COLUNA_ANO, ano);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Falhou", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Cadastrado!", Toast.LENGTH_SHORT).show();
        }

    }




}
