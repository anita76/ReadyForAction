package com.cmdf2019.readyforaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RestaurantRP1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_rp1);
    }

    public void goToNextStep(View view){
        Intent homePageActivity = new Intent(this, DummyShoppingList.class);
        startActivity(homePageActivity);
    }

    public void goToHomePage(View view){
        Intent homePageActivity = new Intent(this, HomePageActivity.class);
        startActivity(homePageActivity);
    }
}
