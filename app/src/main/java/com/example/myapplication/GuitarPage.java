package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

public class GuitarPage extends AppCompatActivity {
    private ImageView blueB, greenB, orangeB, blueBOn, greenBOn, orangeBOn;
    private VerifNota tapNota;
    private String json;
    private TCPSingleton tcp;
    private boolean isGreen, isOrange, isBlue;
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar_page);
        blueB = findViewById(R.id.blueB);
        greenB = findViewById(R.id.greenB);
        orangeB = findViewById(R.id.orangeB);
        blueBOn = findViewById(R.id.blueBON);
        greenBOn = findViewById(R.id.greenBON);
        orangeBOn = findViewById(R.id.orangeBON);
        tcp = TCPSingleton.getInstance();
        gson=new Gson();


        tapNota = new VerifNota(isBlue,isGreen,isOrange);
        isGreen = false;
        isOrange = false;
        isBlue = false;


        blueB.setOnTouchListener(
                (view, event) -> {

                    switch (event.getAction()) {

                        case MotionEvent.ACTION_DOWN:
                            blueB.setVisibility(View.INVISIBLE);
                            break;
                        case MotionEvent.ACTION_UP:
                            blueB.setVisibility(View.VISIBLE);
                            break;
                    }


                    return true;
                }
        );

        greenB.setOnTouchListener(
                (view, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_UP:
                            greenB.setVisibility(View.VISIBLE);
                            break;
                        case MotionEvent.ACTION_DOWN:
                            greenB.setVisibility(View.INVISIBLE);

                            break;
                    }

                    return true;
                });


        orangeB.setOnTouchListener(
                (view, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_UP:
                            orangeB.setVisibility(View.VISIBLE);

                            break;
                        case MotionEvent.ACTION_DOWN:
                            orangeB.setVisibility(View.INVISIBLE);

                            break;
                    }


                    return true;
                });


    }


}