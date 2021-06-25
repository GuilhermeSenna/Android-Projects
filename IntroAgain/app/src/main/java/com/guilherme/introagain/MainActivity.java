package com.guilherme.introagain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rollButton;
    private TextView resultsTextView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.rollButton);
        resultsTextView = findViewById(R.id.resultsTextView);
        seekBar = findViewById(R.id.seekBar);
    }

    public void random(View view){
        rand = new Random().nextInt(seekBar.progress);
        resultsTextView.text = rand.toString();
    }
}
