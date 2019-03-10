package com.cmdf2019.readyforaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfilePage extends AppCompatActivity {
    public String userFirstName;
    public String userLastName;
    public String emergencyContactFirstName;
    public String emergencyContactLastName;
    public String phoneNumber;

    public EditText userFirstNameET;
    public EditText userLastNameET;
    public EditText emergencyContactFirstNameET;
    public EditText emergencyContactLastNameET;
    public EditText phoneNumberET;


    public Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

            userFirstNameET = (EditText) findViewById(R.id.firstNameET);
            userLastNameET = (EditText) findViewById(R.id.LastNameET);
            emergencyContactFirstNameET = (EditText) findViewById(R.id.EmergencyFirstNameET);
            emergencyContactLastNameET = (EditText) findViewById(R.id.EmergencyLastNameET);
            phoneNumberET = (EditText) findViewById(R.id.EmergencyPhoneNumberET);
            save = (Button) findViewById(R.id.save);



            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ProfilePage.this);
            userFirstNameET.setText(prefs.getString("userFirstName", ""));
            userLastNameET.setText(prefs.getString("userLastName", ""));
            emergencyContactFirstNameET.setText(prefs.getString("emergencyContactFirstName", ""));
            emergencyContactLastNameET.setText(prefs.getString("emergencyContactLastName", ""));
            phoneNumberET.setText(prefs.getString("phoneNumber", ""));

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userFirstName = userFirstNameET.getText().toString();
                    userLastName = userLastNameET.getText().toString();
                    emergencyContactFirstName = emergencyContactFirstNameET.getText().toString();
                    emergencyContactLastName = emergencyContactLastNameET.getText().toString();
                    phoneNumber = phoneNumberET.getText().toString();

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ProfilePage.this);
                    SharedPreferences.Editor editor = prefs.edit();

                    editor.putString("userFirstName", userFirstName);
                    editor.putString("userLastName", userLastName);
                    editor.putString("emergencyContactFirstName", emergencyContactFirstName);
                    editor.putString("emergencyContactLastName", emergencyContactLastName);
                    editor.putString("phoneNumber", phoneNumber);
                    editor.apply();

                }
            });
    }

    public void goToHomePage(View view){
        Intent homePageActivity = new Intent(this, HomePageActivity.class);
        startActivity(homePageActivity);
    }
}
