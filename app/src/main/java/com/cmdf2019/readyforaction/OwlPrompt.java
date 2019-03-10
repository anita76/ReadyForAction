package com.cmdf2019.readyforaction;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class OwlPrompt {
    public int index;
    private Map<Integer, String> textPrompt = new HashMap<>();

    public OwlPrompt() {
        index = 0;
        createMap();
    }

    public void createMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("Prompt.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                textPrompt.put(Integer.parseInt(values[0]), values[1]);
            }
        }catch (Exception e) {
            System.out.println("Error while reading database");
            e.printStackTrace(System.out);
        }
    }

    public String getCurrPrompt() {
        return textPrompt.get(index);
    }

    public void moveToNextStep() {
        index++;
    }
}
