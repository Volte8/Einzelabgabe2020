package com.example.einzelabgabe2020;

import android.os.AsyncTask;
import android.os.Handler;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void sendMessage(final String messager, final TextView view) {

        final Handler handler = new Handler();

        // Thrad Erstellen
        Thread thread = new Thread(new Runnable() {


            @Override
            public void run() {

                try {

                    // Socket erstellen
                    Socket socket = new Socket("se2-isys.aau.at", 53212);

                    // An Server Senden
                    OutputStream out = socket.getOutputStream();
                    PrintWriter output = new PrintWriter(out);
                    output.println(messager);
                    output.flush();

                    // Vom Server lesen
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final String st = input.readLine();

                    // Nachricht Anzeigen
                    handler.post(new Runnable() {

                        final String Antwort = "";

                        @Override
                        public void run() {

                            String s = messager;
                            if (st.trim().length() != 0)
                                view.setText(s + "\nFrom Server : " + st);

                        }


                    });

                    // Verbindun Schliesen
                    output.close();
                    out.close();
                    socket.close();



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread Starten
        thread.start();
    }


}







