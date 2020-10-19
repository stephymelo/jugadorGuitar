package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.exception.exception;
import com.google.gson.Gson;

public class ConnexionActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView connectB, connectSuccess;
    private Jugador jugador;
    private String json;
    private TCPSingleton tcp;
    private boolean connected,connectedPass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_activity);
        connectB = findViewById(R.id.connectB);
        connectSuccess = findViewById(R.id.connectSuccess);


        jugador = new Jugador("Jugador1", 0);
        connectB.setOnClickListener(this);
        connectSuccess.setOnClickListener(this);
        connected = false;
        connectedPass=false;



    }

    @Override
    public void onClick(View view) {
        Gson gson= new Gson();
        json=gson.toJson(jugador);

        switch (view.getId()) {
            case R.id.connectB:
                tcp = TCPSingleton.getInstance();
                tcp.setCliente(this);
                tcp.start();
                connected = true;
                runOnUiThread(
                        ()-> {
                            pintarConexion();
                        }
                );

                break;
            case R.id.connectSuccess:
                    tcp.enviar(json);
                    Intent i = new Intent(this, GuitarPage.class);
                    startActivity(i);
                    break;

        }
    }


    public void pintarConexion() {
        if (connected) {
            try {
                connectSuccess.setVisibility(View.VISIBLE);
                throw new exception("no se conecto");
            } catch (exception e) {
                Log.e("no", "conecto");

            }
        }


    }
}