package com.example.einzelabgabe2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    TextView txtAusgabe;
    TextView txtNummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt= (TextView) findViewById(R.id.txt);
        btn= (Button)findViewById(R.id.btn);
        txtAusgabe= (TextView) findViewById(R.id.txtAusgabe);
        txtNummer= (TextView) findViewById(R.id.txtNummer);
    }
}
