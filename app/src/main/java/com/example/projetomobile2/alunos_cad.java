package com.example.projetomobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class alunos_cad extends AppCompatActivity {

    EditText nomeAluno, classeAluno, ano;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos_cad);

        nomeAluno = findViewById(R.id.nomeAluno);
        classeAluno = findViewById(R.id.classeAluno);
        ano = findViewById(R.id.ano);
        cadastrar = findViewById(R.id.cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(alunos_cad.this);
                myDB.addAlunos(nomeAluno.getText().toString().trim(), classeAluno.getText().toString().trim(), Integer.valueOf(ano.getText().toString().trim()));


            }
        });


    }
}