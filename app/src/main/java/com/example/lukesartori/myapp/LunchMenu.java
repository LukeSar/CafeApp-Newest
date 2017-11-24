package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Luke on 12/03/2017.
 */

public class LunchMenu extends AppCompatActivity {  //initialises lunch menu screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development

    ImageButton BackButton;
    Button GrilledChickenButton, EscalopeChickenButton, KebabButton, FishCakeButton, SaladBoxButton, CiabattaButton, PastaButton  ;




    @Override   //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {    //used for starting the activity to start up all the components on the screen by using previously saved data
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity
        setContentView(R.layout.activity_lunch);    //pairs the UI with the XML used to create it so it can show the user what has been created


        BackButton = (ImageButton) findViewById(R.id.BackButton);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LunchMenu.this, MainScreen.class));
            }
        });

        GrilledChickenButton = (Button) findViewById(R.id.GrilledChickenButton);

        GrilledChickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GrilledChickenButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        EscalopeChickenButton = (Button) findViewById(R.id.EscalopeChickenButton);

        EscalopeChickenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                EscalopeChickenButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        KebabButton = (Button) findViewById(R.id.KebabButton);

        KebabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KebabButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        FishCakeButton = (Button) findViewById(R.id.FishCakeButton);

        FishCakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FishCakeButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        SaladBoxButton = (Button) findViewById(R.id.SaladBoxButton);

        SaladBoxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaladBoxButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        CiabattaButton = (Button) findViewById(R.id.CiabattaButton);

        CiabattaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CiabattaButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        PastaButton = (Button) findViewById(R.id.PastaButton);

        PastaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PastaButton.setTextColor(Color.parseColor("#008000"));
                Toast.makeText(getApplicationContext(),
                        "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
