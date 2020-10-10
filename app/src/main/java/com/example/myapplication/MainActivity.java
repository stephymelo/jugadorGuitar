package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView bg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg=findViewById(R.id.bg1);
        bg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent(this,ConectPage.class);
        Log.e("si","si");
        startActivity(i);

    }
}