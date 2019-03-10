package com.cmdf2019.readyforaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.util.Log;

public class action extends AppCompatActivity implements View.OnClickListener {
    Button helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        helpButton = findViewById(R.id.help_button);
        helpButton.setOnClickListener(this);

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
                System.out.println("Got here");
                sendText();
        }
    }

    // send a text message to contact on button click
    // text include n=info like what role and step user is on
    public void sendText()
    {
        System.out.println("Sending a text message");
        // Do something in response to button click
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String("7782237111"));
        smsIntent.putExtra("sms_body"  , "Test SMS for ReadyForAction");

        try {
            startActivity(smsIntent);
            finish();
            System.out.println("Finished sending a text message");
        } catch (android.content.ActivityNotFoundException ex) {
            System.out.println("Error sending a text message");
        }
    }

}
