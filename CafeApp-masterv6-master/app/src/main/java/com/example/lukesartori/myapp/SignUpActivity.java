package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;


public class SignUpActivity extends AppCompatActivity { //initialises sign up screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development

    EditText FirstNameText, SurnameText, PasswordText, PasswordTextConfirm, UsernameText, EmailText, PhoneText; //EditTexts to allow the user to enter information into the signup form
    ImageButton BackButton, FurtherInfoButton; //ImageButton to allow the user to go back a page to first screen shown
    Button DoneButton; //initialises button to complete sign up form and show the further information popup
    private PopupWindow popupWindow;    //sets private class for pop up window to contain the extra information
    private LayoutInflater layoutInflater;  //sets private class for a box to contain the pop up window with the information


    @Override   //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {    //used for starting the activity to start up all the components on the screen by using previously saved
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity
        setContentView(R.layout.activity_signup);    //pairs the UI with the XML used to create it so it can show the user what has been created

        PasswordText = (EditText) findViewById(R.id.PasswordText);  //tool used for the UI to locate the 'Password' TextView on the screen
        FirstNameText = (EditText) findViewById(R.id.FirstNameText);    //tool used for the UI to locate the 'First Name' TextView on the screen
        EmailText = (EditText) findViewById(R.id.EmailText);    //tool used for the UI to locate the 'Email' Text View on the screen
        DoneButton = (Button) findViewById(R.id.DoneButton);    //tool used for the UI to locate the 'done' button on the screen
        //tool used for the UI to locate the 'further info' button on the screen
        UsernameText = (EditText) findViewById(R.id.UsernameText);  //tool used for the UI to locate the 'Username' Text View on the screen
        PasswordTextConfirm = (EditText) findViewById(R.id.PasswordTextConfirm);    //tool used for the UI to locate the 'Password Confirmation' Text View on the screen
        BackButton = (ImageButton) findViewById(R.id.BackButton);   //tool used for the UI to locate the 'Back' button on the screen
        SurnameText = (EditText) findViewById(R.id.SurnameText);    //tool used for the UI to locate the 'Surname' Text View on the screen
        PhoneText = (EditText) findViewById(R.id.PhoneText);    //tool used for the UI to locate the 'Phone Number' TextView on the screen
        FurtherInfoButton = (ImageButton) findViewById(R.id.FurtherInfoButton);


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

        PhoneText.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                         public void onClick(View v) {
                                             if (PhoneText.getText().toString().trim().length() <10  || PhoneText.getText().toString().trim().length() >11) {
                                                 Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                                                         "Please enter your mobile number", Toast.LENGTH_SHORT).show();

                                             } else {
                                                 Toast.makeText(getApplicationContext(),
                                                         "Accepted", Toast.LENGTH_SHORT).show();
                                             }
                                         }
                                     });




       PasswordText.setOnClickListener(new View.OnClickListener() {

                                            @Override
                                           public void onClick(View v) {
                                               if (PasswordText.getText().toString().trim().length() < 6)
                                                   Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                                                           "Please set a valid Password", Toast.LENGTH_SHORT).show();

                                                    if (!PasswordText.getText().toString().matches(".*\\d.*")){
                                                        Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                                                                "Please set a valid Password", Toast.LENGTH_SHORT).show();




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


       UsernameText.setOnClickListener(new View.OnClickListener() {

                                            @Override
                                           public void onClick(View v) {
                                               if (UsernameText.getText().toString().trim().length() < 6 ){
                                                        Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                                                           "Please enter a valid username", Toast.LENGTH_SHORT).show();
                                               }else {
                                                   Toast.makeText(getApplicationContext(),
                                                           "Accepted", Toast.LENGTH_SHORT).show();

                                               }
                                       }
                                       });



        EmailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EmailText.getText().toString().trim().length() < 4){
                        Toast.makeText(getApplicationContext(), //toast tool used to make a temporary message for the user
                            "Please enter a valid Email", Toast.LENGTH_SHORT).show();
                            }else{
                            Toast.makeText(getApplicationContext(),
                            "Accepted", Toast.LENGTH_SHORT).show();
                            }
                    }
                 });



        DoneButton.setOnClickListener(new View.OnClickListener() {  //sets a class for the done button so that when it is clicked an action can be performed
            @Override
            public void onClick(View v) {   //sets method so when the view or done button has been clicked a new action can be performed

                if (UsernameText.getText().toString().trim().length() >4){
                    if (PhoneText.getText().toString().trim().length() >10)
                        if (FirstNameText.getText().toString().trim().length() > 0)
                            if (SurnameText.getText().toString().trim().length() > 0)
                                if (PasswordText.getText().toString().trim().length() > 6)
                                    if (PasswordTextConfirm.getText().toString().trim().length() >6)
                                        if (EmailText.getText().toString().trim().length() >4)
                                            Toast.makeText(getApplicationContext(),
                                                "SignUp Accepted", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                        }else{
                                        Toast.makeText(getApplicationContext(),
                                         "SignUp Rejected", Toast.LENGTH_SHORT).show();
                                    }
                                }
                             });




        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });








        FurtherInfoButton.setOnClickListener(new View.OnClickListener(){    //sets a class for the further information button so that when it is clicked an action can be performed
           @Override
            public void onClick(View v) {   //sets a method so when the further info button is clicked a new action can be performed
               layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE); //retrieves the information to be held in the pop up from XML
               ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.email_pop, null);  //calls the now retrieved XMl code and puts it into the 'email pop'

               popupWindow = new PopupWindow(container, 950, 1120, true);   //initiates the pop up size and sets it to visible
               popupWindow.showAtLocation(FurtherInfoButton, Gravity.CENTER, 0, 0); //sets location of the pop up on the screen to center

               container.setOnTouchListener(new View.OnTouchListener() {    //adds a listener to the container of the pop up window so that the listener can react to an event such as being clicked
                   @Override
                   public boolean onTouch(View view, MotionEvent motionEvent) { //sets method so that when the window or screen is touched the pop up is removed
                       popupWindow.dismiss();   //sets pop up to inactive and invisible
                       return true; //sets dismiss to true so the pop up is now inactive
                   }
               });
           }
        });

    }
}



     /*   EmailText.addTextChangedListener(new TextWatcher() {
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            public void afterTextChanged(Editable s) {

                if (emailPattern.matches(emailPattern) && s.length() > 0)
                {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"invalid email address",Toast.LENGTH_SHORT).show();

                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });
*/


