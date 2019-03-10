package com.cmdf2019.readyforaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class action extends AppCompatActivity implements View.OnClickListener {
    Button helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

//        helpButton = (Button) findViewById(R.id.help_button);
//        helpButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//            }
//        });
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.help_button:
                sendText();
        }
    }

    // send a text message to contact on button click
    // text include n=info like what role and step user is on
    public void sendText()
    {
        // Do something in response to button click
    }

}
