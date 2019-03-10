package com.cmdf2019.readyforaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import java.util.HashMap;
import java.util.Map;

public class ChecklistPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Checklist checklist = new Checklist();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //for testing
        System.out.println("in onCreate");
        checklist.addItem("Apple");
        checklist.addItem("Bagel");
        checklist.addItem("Milk");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist_page);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ChecklistAdaptor(checklist);
        recyclerView.setAdapter(mAdapter);
    }

    public void goToNextPage(View view) {
        if (allChecked()) {
            Intent startLastPageActivity = new Intent(this, ShoppingCompleted.class);
            startActivity(startLastPageActivity);
        }
    }

    private boolean allChecked() {
//        CheckBox one = (CheckBox) findViewById(R.id.checkBox);
////        return one.isChecked();
        return (checklist.getRemainingCategories().size() == 0);
    }

}
