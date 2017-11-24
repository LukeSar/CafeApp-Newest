package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class BreakfastMenu extends AppCompatActivity {   //initialises the breakfast menu screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development

    ImageButton BackButton;
    Button BaconButton, ScrambledEggButton, PoachedEggButton, ToastButton, CapuccinoButton, TeaButton;


    @Override    //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {    //used for starting the activity to start up all the components on the screen by using previously saved
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity
        setContentView(R.layout.activity_breakfast);    //pairs the UI with the XML used to create it so it can show the user what has been created


        BackButton = (ImageButton) findViewById(R.id.BackButton);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BreakfastMenu.this, MainScreen.class));
            }
        });

        BaconButton = (Button) findViewById(R.id.BaconButton);

        BaconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaconButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        ScrambledEggButton = (Button) findViewById(R.id.ScrambledEggButton);

        ScrambledEggButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrambledEggButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();

            }
        });


        PoachedEggButton = (Button) findViewById(R.id.PoachedEggButton);

        PoachedEggButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PoachedEggButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        ToastButton = (Button) findViewById(R.id.ToastButton);

        ToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        CapuccinoButton = (Button) findViewById(R.id.CapuccinoButton);

        CapuccinoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CapuccinoButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        TeaButton = (Button) findViewById(R.id.TeaButton);

        TeaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeaButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


