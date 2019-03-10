package com.cmdf2019.readyforaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void goToProfilePage(View view){
        Intent profilePageActivity = new Intent(this, ProfilePage.class);
        startActivity(profilePageActivity);
    }

    public void goToCustomer1(View view){
        Intent goToCustomer1Activity = new Intent(this, RPCustomer1.class);
        startActivity(goToCustomer1Activity);
    }

}
