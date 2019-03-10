package com.cmdf2019.readyforaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DummyShoppingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_shopping_list);
    }

    public void goToHomePage(View view){
        Intent homePageActivity = new Intent(this, HomePageActivity.class);
        startActivity(homePageActivity);
    }

    public void goToNextStep(View view){
        Intent homePageActivity = new Intent(this, CustomerRP2.class);
        startActivity(homePageActivity);
    }
}
