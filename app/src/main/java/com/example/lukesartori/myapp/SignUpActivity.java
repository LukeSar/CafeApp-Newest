package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener { //initialises sign up screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development
    TextView LoginView;
    EditText PasswordText, EmailText, PasswordConfirm; //EditTexts to allow the user to enter information into the signup form
    ImageButton FurtherInfoButton; //ImageButton to allow the user to go back a page to first screen shown
    Button SubmitButton; //initialises button to complete sign up form and show the further information popup
    private PopupWindow popupWindow;    //sets private class for pop up window to contain the extra information
    private LayoutInflater layoutInflater;  //sets private class for a box to contain the pop up window with the information
    private FirebaseAuth mAuth;

    @Override   //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {    //used for starting the activity to start up all the components on the screen by using previously saved
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity
        setContentView(R.layout.activity_signup);    //pairs the UI with the XML used to create it so it can show the user what has been created

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mAuth = FirebaseAuth.getInstance();

        PasswordConfirm = (EditText) findViewById(R.id.PasswordConfirm);
        LoginView = (TextView) findViewById(R.id.LoginView);
        PasswordText = (EditText) findViewById(R.id.PasswordText);  //tool used for the UI to locate the 'Password' TextView on the screen
        //tool used for the UI to locate the 'First Name' TextView on the screen
        EmailText = (EditText) findViewById(R.id.EmailText);    //tool used for the UI to locate the 'Email' Text View on the screen

        findViewById(R.id.SubmitButton).setOnClickListener(this);


        FurtherInfoButton = (ImageButton) findViewById(R.id.FurtherInfoButton);

        FurtherInfoButton.setOnClickListener(new View.OnClickListener() {    //sets a class for the further information button so that when it is clicked an action can be performed
            @Override
            public void onClick(View v) {   //sets a method so when the further info button is clicked a new action can be performed
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE); //retrieves the information to be held in the pop up from XML
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.email_pop, null);  //calls the now retrieved XMl code and puts it into the 'email pop'

                popupWindow = new PopupWindow(container, 950, 350, true);   //initiates the pop up size and sets it to visible
                popupWindow.showAtLocation(FurtherInfoButton, Gravity.TOP, 0, 0); //sets location of the pop up on the screen to center

                container.setOnTouchListener(new View.OnTouchListener() {    //adds a listener to the container of the pop up window so that the listener can react to an event such as being clicked
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) { //sets method so that when the window or screen is touched the pop up is removed
                        popupWindow.dismiss();   //sets pop up to inactive and invisible
                        return true; //sets dismiss to true so the pop up is now inactive
                    }
                });
            }
        });

        LoginView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });


    }


    private void registerUser() {

        String PasswordConfirmation = PasswordConfirm.getText().toString().trim();
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

        if (!PasswordConfirmation.equals(Password)){
            PasswordConfirm.setError("Passwords need to match");
            PasswordConfirm.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MainScreen.class));
                } else {
                    if(task.getException()instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "Already Registered", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SubmitButton:
                registerUser();
                break;

            case R.id.BackButton:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }
    }
}






     /*
     if (UsernameText.getText().toString().trim().length() > 4) {
                    if (PhoneText.getText().toString().trim().length() > 10)
                        if (FirstNameText.getText().toString().trim().length() > 0)
                            if (SurnameText.getText().toString().trim().length() > 0)
                                if (PasswordText.getText().toString().trim().length() > 6)
                                    if (PasswordTextConfirm.getText().toString().trim().length() > 6)
                                        if (EmailText.getText().toString().trim().length() > 4)
      */

/*
        PhoneText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (PhoneText.getText().toString().trim().length() < 10 || PhoneText.getText().toString().trim().length() > 11) {
                    Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                            "Please enter your mobile number", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Accepted", Toast.LENGTH_SHORT).show();
                }
            }
        });


        FirstNameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirstNameText.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                            "Please enter your first name", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getApplicationContext(),
                            "Accepted", Toast.LENGTH_SHORT).show();

                }
            }
        });

        SurnameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SurnameText.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                            "Please enter your surname", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Accepted", Toast.LENGTH_SHORT).show();
                }
            }

        });


        PasswordTextConfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (PasswordTextConfirm.getText().toString().trim().length() < 6)
                    Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                            "Please enter the same Password", Toast.LENGTH_SHORT).show();

                if (!PasswordText.getText().toString().equals(PasswordTextConfirm.getText().toString())) {
                    Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                            "Incorrect", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getApplicationContext(),
                            "Accepted", Toast.LENGTH_SHORT).show();

                }
            }
        });
    */



