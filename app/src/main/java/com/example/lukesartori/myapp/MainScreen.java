package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;


public class MainScreen extends AppCompatActivity { //initialises main screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development
    ImageButton CheckoutCart;
    Button BreakfastButton;
    Button LunchButton,  LogoutButton; //initialises 2 buttons for the app, breakfast and lunch
     //initialises a clickable image to navigate back a page

    @Override //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {    //used for starting the activity to start up all the components on the screen by using previously saved data
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity

        setContentView(R.layout.activity_mainscreen);   //pairs the UI with the XML used to create it so it can show the user what has been created

        BreakfastButton = (Button) findViewById(R.id.BreakfastButton); //tool used for the UI to locate breakfast button on the screen

        BreakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, BreakfastMenu.class));
            }
        });



        LunchButton = (Button) findViewById(R.id.LunchButton);  //tool used for the UI to locate lunch button on the screen

        LunchButton.setOnClickListener(new View.OnClickListener() {  //sets a class for the lunch button so that when it is clicked an action can be performed
            @Override
            public void onClick(View v) {   //sets method so when the view or lunch button has been clicked a new action can be performed
                startActivity(new Intent(MainScreen.this, LunchMenu.class));    //starts a new activity where 'intent' is used as an object to bridge the two screens

            }
        });



        CheckoutCart =(ImageButton) findViewById(R.id.CheckoutCart);

        CheckoutCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, Checkout.class));
            }
        });




        LogoutButton = (Button) findViewById(R.id.LogoutButton);

        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, MainActivity.class));


            }
        });

    }
}







