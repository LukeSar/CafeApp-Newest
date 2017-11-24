package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {   //initialises main screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development

    EditText EmailText,UserNameText;    //initialises two edit texts for email and username so that the user can enter details into it
    Button LoginButton,SignUpButton;    //initialises 2 buttons for the app, login and sign up so that the user can click them to be taken to a new screen

    @Override    //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {  //used for starting the activity to start up all the components on the screen by using previously saved data
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity
        setContentView(R.layout.activity_main);    //pairs the UI with the XML used to create it so it can show the user what has been created

        EmailText = (EditText) findViewById(R.id.EmailText);    //tool used for the UI to locate the text field for the users email on the screen
        LoginButton = (Button) findViewById(R.id.LoginButton);  //tool used for the UI to locate the login button on the screen
        UserNameText = (EditText)  findViewById(R.id.UserNameText); //tool used for the UI to locate the text field for the username on the screen


        LoginButton.setOnClickListener(new View.OnClickListener() {  //sets a class for the login button so that when it is clicked an action can be performed
            @Override
            public void onClick(View view) {    //sets method so when the view or login button has been clicked a new action can be performed

                if (EmailText.getText().toString().contains("@") &&  //sets if condition so that the email field contains any object such as a character it can be accepted
                        EmailText.getText().toString().contains(".co.uk")  ||   //sets another condition so that if email field has .co.uk it can be accepted
                        EmailText.getText().toString().contains(".com") &&  //sets another condition so that if email field contains .com it can be accepted
                                UserNameText.getText().toString().equals("admin")){ //sets an 'and' condition so that the password admin must be entered to be allowed to login
                    Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                            "Redirecting...", Toast.LENGTH_SHORT).show();   //if all above is accepted toast tool displays 'redirecting' message to the user

                    startActivity(new Intent(MainActivity.this, MainScreen.class)); //loads new screen for the user to be taken to after logging in


                } else {    //sets new condition for if the fields above are not met
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();    //if fields are not met toast displays message saying 'wrong credentials'
                }
            }
        });


        SignUpButton = (Button) findViewById(R.id.SignUpButton);    //tool used for the UI to locate the text field for the users sign up field on the screen

        SignUpButton.setOnClickListener(new View.OnClickListener(){     //sets a class for the sign up button so that when it is clicked an action can be performed
        @Override
            public void onClick(View signUp){   //sets method so when the view or sign up button has been clicked a new action can be performed
               startActivity(new Intent(MainActivity.this, SignUpActivity.class));   //starts a new activity where 'intent' is used as an object to bridge the two screens
            }
        });


    }
}

























