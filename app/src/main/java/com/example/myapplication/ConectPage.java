package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ConectPage extends AppCompatActivity implements View.OnClickListener {

    ImageView connectB,connectSuccess;
    Jugador jugador;
    TCPSingleton tcp;
    Boolean connected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conect_page);
        connectB=findViewById(R.id.connectB);
        connectSuccess=findViewById(R.id.connectSuccess);
        tcp = TCPSingleton.getInstance();

        jugador=new Jugador("Jugador1","score");
        connectB.setOnClickListener(this);
        connectSuccess.setOnClickListener(this);
        connected=false;


new Thread(
        ()-> {
            try {
                Thread.sleep(200);
                pintarConexion();

            }catch (InterruptedException l) {
                l.printStackTrace();
            }



        }
        ).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.connectB:
                   connected=true;
                connectSuccess.setVisibility(View.VISIBLE);
                    Log.e("si","si"+connected);

//                tcp.start();
                break;
            case R.id.connectSuccess:
                if(connected==true) {
                    Intent i = new Intent(this, GuitarPage.class);
                    startActivity(i);
                    break;
                }
        }
    }

    public void pintarConexion(){
        if(connected==true) {
            runOnUiThread(
                    ()-> {
                        connectSuccess.setVisibility(View.VISIBLE);
                    }
            );

        }

        }



}