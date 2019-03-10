package com.cmdf2019.readyforaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShoppingCompleted extends AppCompatActivity {
    OwlPrompt prompt = new OwlPrompt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_completed);
    }

    public void goToHomePage(View view){
        Intent homePageActivity = new Intent(this, HomePageActivity.class);
        startActivity(homePageActivity);
    }

    public void goToNextStep(View view){
        Intent homePageActivity = new Intent(this, HomePageActivity.class);
        startActivity(homePageActivity);
    }

    public void nextPrompt(View view) {
        System.out.println(prompt.getCurrPrompt());
        ((TextView)findViewById(R.id.editText)).setText(prompt.getCurrPrompt());
    }
}
