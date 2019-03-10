package com.cmdf2019.readyforaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class ChecklistPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Map<String, String> database;

    Checklist checklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //for testing
        // load the grocery spreadsheet into TreeMap database object
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.grocery_db)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                database.put(values[0], values[1]);
            }
        }catch (Exception e) {
            System.out.println("Error while reading database");
        }

        checklist = new Checklist(database);

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


}
