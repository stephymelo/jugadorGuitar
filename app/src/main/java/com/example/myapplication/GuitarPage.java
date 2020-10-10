package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class GuitarPage extends AppCompatActivity {
    ImageView blueB,greenB,orangeB,blueBOn,greenBOn,orangeBOn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar_page);
        blueB=findViewById(R.id.blueB);
        greenB=findViewById(R.id.greenB);
        orangeB=findViewById(R.id.orangeB);
        blueBOn=findViewById(R.id.blueBON);
        greenBOn=findViewById(R.id.greenBON);
        orangeBOn=findViewById(R.id.orangeBON);


        blueB.setOnTouchListener(
                (view,event)->{

                    switch(event.getAction()){

                        case MotionEvent.ACTION_DOWN:
                            blueB.setVisibility(View.INVISIBLE);
                            Log.e("touch","touch");
                            break;
                        case MotionEvent.ACTION_UP:
                            blueB.setVisibility(View.VISIBLE);

                            Log.e("up","up");
                            break;
                    }



                    return false;
                }
        );

        greenB.setOnTouchListener(
                (view,event)->{

            switch(event.getAction()){
                case MotionEvent.ACTION_UP:
                    greenBOn.setVisibility(View.INVISIBLE);
                    break;
                case MotionEvent.ACTION_DOWN:
                    greenBOn.setVisibility(View.VISIBLE);

                    break;
            }



            return false;
        });
        orangeB.setOnTouchListener(
                (view,event)->{

            switch(event.getAction()){
                case MotionEvent.ACTION_UP:
                    orangeBOn.setVisibility(View.INVISIBLE);

                    break;
                case MotionEvent.ACTION_DOWN:
                    orangeBOn.setVisibility(View.VISIBLE);
                    break;
            }



            return false;
        });


    }



}