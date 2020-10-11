package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.exception.exception;

public class ConnexionActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView connectB, connectSuccess;
    private Jugador jugador;
    private TCPSingleton tcp;
    private boolean connected,connectedPass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_activity);
        connectB = findViewById(R.id.connectB);
        connectSuccess = findViewById(R.id.connectSuccess);
        tcp = TCPSingleton.getInstance();
        jugador = new Jugador("Jugador1", "score");
        connectB.setOnClickListener(this);
        connectSuccess.setOnClickListener(this);
        connected = false;
        connectedPass=false;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.connectB:
//                tcp.start();
                connected = true;
                runOnUiThread(
                        ()-> {
                            pintarConexion();
                        }
                );


                Log.e("si", "conectado" + connected);
                break;
            case R.id.connectSuccess:

                    Intent i = new Intent(this, GuitarPage.class);
                    startActivity(i);
                    break;

        }
    }


    public void pintarConexion() {
        if (connected == true) {
            try {
                connectSuccess.setVisibility(View.VISIBLE);
                throw new exception("no se conecto");
            } catch (exception e) {
                Log.e("no", "conecto");

            }
        }


    }
}