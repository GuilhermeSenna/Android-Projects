package com.guilherme.calculadoradeimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.guilherme.calculadoradeimc.DadosOpenHelper;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso;
    private EditText editAltura;
    private TextView textResultado;

    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    private GerenteRepositorio gerenteRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResultado = findViewById(R.id.textResultado);

        criarConexao();

    }

    private void criarConexao(){
        try{

            dadosOpenHelper = new DadosOpenHelper(this);

            conexao = dadosOpenHelper.getWritableDatabase();

            gerenteRepositorio = new GerenteRepositorio(conexao);

            Context context = getApplicationContext();
            CharSequence text = "teste";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(MainActivity.this, text, duration);
            toast.show();

        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("Ok", null);
            dlg.show();
        }
    }

    public void calcularImc(View view){
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());

        double imc = peso/(altura*altura);

        /*IMC = peso/altura*altura */

        if(imc >= 18.5 && imc < 25){
            textResultado.setText("Peso Normal, IMC = "+imc);
        }else if(imc >= 25 && imc < 30){
            textResultado.setText("Acima do peso, IMC = "+imc);
        }else if(imc >= 30 && imc < 35){
            textResultado.setText("Obesidade I, IMC = "+imc);
        }else if(imc >= 35 && imc < 40){
            textResultado.setText("Obesidade II, IMC = "+imc);
        }else if(imc >= 40){
            textResultado.setText("Obesidade III (morbida), IMC= "+imc);
        }else{
            textResultado.setText("IMC fora do normal.");
        }
    }
}