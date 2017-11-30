package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{   //initialises main screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development

    TextView CreateAccountView;
    EditText EmailText, PasswordText;
    Button LoginButton, HelpButton;    //initialises 2 buttons for the app, login and sign up so that the user can click them to be taken to a new screen

    FirebaseAuth mAuth;


    @Override    //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {  //used for starting the activity to start up all the components on the screen by using previously saved data
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity
        setContentView(R.layout.activity_main);    //pairs the UI with the XML used to create it so it can show the user what has been created

        mAuth = FirebaseAuth.getInstance();

        EmailText = (EditText) findViewById(R.id.EmailText);
        PasswordText = (EditText) findViewById(R.id.PasswordText);

        findViewById(R.id.LoginButton).setOnClickListener(this);

        HelpButton = (Button) findViewById(R.id.HelpButton);

        HelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });


        CreateAccountView = (TextView) findViewById(R.id.CreateAccountView);

        CreateAccountView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });


    }


   private void loginUser(){

        String Email = EmailText.getText().toString().trim();
        String Password = PasswordText.getText().toString().trim();

       if (Email.isEmpty()) {
           EmailText.setError("Email is Required");
           EmailText.requestFocus();
           return;

       }

       if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
           EmailText.setError("Please enter valid email");
           EmailText.requestFocus();
           return;
       }


       if (Password.isEmpty()) {
           PasswordText.setError("Password is Required");
           PasswordText.requestFocus();
           return;


       }

       if (Password.length() < 6) {
           PasswordText.setError("Need 6 letters");
           PasswordText.requestFocus();
           return;
       }




        mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent (MainActivity.this, MainScreen.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Unsuccessful",Toast.LENGTH_LONG).show();
                }
            }
        });



   }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.CreateAccountView:
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                break;

            case R.id.LoginButton:
                loginUser();
                break;
        }
    }
}
























