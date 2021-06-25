package com.guilherme.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editprecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editprecoAlcool = findViewById(R.id.editALcool);
        editPrecoGasolina = findViewById(R.id.editGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        Double precoAlcool = Double.parseDouble(editprecoAlcool.getText().toString());
        Double precoGasolina = Double.parseDouble(editPrecoGasolina.getText().toString());


        /* Faz calcu0lo ( precoAlcool/ precoGasolina)
            Se o resultado >= 0.7 melhor utilizar gasolina
            Senão melhor utilizar alcool
         */
        Double resultado = precoAlcool/precoGasolina;

        if(resultado >= 0.7){
            textResultado.setText("Melhor utilizar gasolina");
        }else{
            textResultado.setText("Melhor utilizar Alcool");
        }
    }
}