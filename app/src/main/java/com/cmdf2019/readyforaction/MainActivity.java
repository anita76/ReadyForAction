package com.cmdf2019.readyforaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextPage = (Button) findViewById(R.id.next_button);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActionPage();
            }
        });
    }

    private void goToActionPage() {
        Intent intent = new Intent(this, action.class);
        startActivity(intent);
    }
}
