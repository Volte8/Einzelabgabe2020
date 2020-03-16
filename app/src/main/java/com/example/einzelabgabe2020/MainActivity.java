package com.example.einzelabgabe2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView matrn;
    Button btn;
    TextView txtAusgabe;
    TextView txtNummer;
    Button btnBerechnung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matrn = (TextView) findViewById(R.id.matrn);
        btn = (Button) findViewById(R.id.btn);
        txtAusgabe = (TextView) findViewById(R.id.txtAusgabe);
        txtNummer = (EditText) findViewById(R.id.txtNummer);
        btnBerechnung=(Button) findViewById(R.id.btnBerechnung);




        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

              try{
                  //Eingabe ermitteln

                  String Eingabe= txtNummer.getText().toString();

                  //Antwort vom Server anzeigen
                  Client.sendMessage(Eingabe,txtAusgabe);


              }catch (Exception e){
                  txtAusgabe.setText(e.getMessage()+" Fehler");
              }


            }

        });

        btnBerechnung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Eingabe ermitteln
                String Eingabe= txtNummer.getText().toString();

                //Funktion berechnen 0 Neuer Button
                String Teiler= Funktion.GgT(Eingabe);
                txtAusgabe.setText(Teiler);

            }
        });


    }

    public static class Funktion{
        public static String GgT(String eingabe)
        {
            List<Integer> myList = new ArrayList<Integer>();
            List<Integer> SortedList = new ArrayList<Integer>();
            ArrayList<Integer> Duplicates = new ArrayList<Integer>();

            // Array Erstellen
            for (int i = 0; i < eingabe.length() ; i++) {

                int z = Character.getNumericValue(eingabe.charAt(i));
                myList.add(z);
            }

            // Index Ermitteln
            for (int i = 0; i < myList.size(); i++) {
                for (int j = i + 1 ; j < myList.size(); j++) {

                    if (myList.get(i) > 1 && myList.get(i) % 2 != 1 && myList.get(i).equals(myList.get(j))) {

                        // Indexes Speichern
                        Duplicates.add(myList.indexOf(myList.get(i)));
                        Duplicates.add(myList.lastIndexOf(myList.get(i)));

                    }

                }
            }

            // Ausgabebe
            String output = "";
            for (int i = 0; i < Duplicates.size(); i++) {


                output += myList.get(Duplicates.get(i)) + " Index: " + Duplicates.get(i) + "\n";

            }



            return output;


        }

    }


        }





