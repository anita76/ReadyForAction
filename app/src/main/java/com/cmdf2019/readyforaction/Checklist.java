package com.cmdf2019.readyforaction;

import android.content.res.AssetManager;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Checklist {
    // KEY = CATEGORY, VALUE = LIST OF ITEMS
    public Map<String, List<String>> grocery_map;
    // reference: https://toughnickel.com/frugal-living/How-to-Create-a-Standardized-Grocery-Shopping-List
    // KEY = ITEM NAME, VALUE = CATEGORY
    public Map<String, String> database;
    // a list of items that have been found
    public List<String> hasFound;


    public Checklist() {
        grocery_map = new HashMap<>();
        database = new HashMap<>();
        hasFound = new ArrayList<>();

        // load the grocery spreadsheet into TreeMap database object
//        System.out.println("Working Directory = " +
//                System.getProperty("user.dir"));
//        String fullPath = System.getProperty("user.dir")+ "/GroceryDB.csv";
//        System.out.println(fullPath);
//        File file = new File(System.getProperty("user.dir")+ "/GroceryDB.csv");
//        System.out.println(file.getName());
//        System.out.println(file.exists());
//        System.out.println(file.canRead());
//        String dirPath = file.getParentFile().getAbsolutePath();
//        System.out.println(dirPath);
        // /sdcard/Download/GroceryDB.csv
        // System.out.println(Environment.getExternalStorageDirectory().getAbsolutePath());
        // System.getProperty("user.dir") + "sdcard/Download/GroceryDB.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "sdcard/Download/GroceryDB.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                database.put(values[0], values[1]);
            }
        }catch (Exception e) {
            System.out.println("Error while reading database");
            e.printStackTrace();
        }
        System.out.println("Constructor completed");
    }

    public String getCategory(String item) {
        return database.get(item);
    }

    // called each time an item is added by the user to the checklist
    public void addItem(String item_name) {
        String category = database.get(item_name);
        List curr_list;
        System.out.println("beep");
        System.out.println(item_name);
        System.out.println(database.get(item_name));
        System.out.println(category);
        if (grocery_map.containsKey(category)) {
            curr_list = grocery_map.get(category);
        }else {
            curr_list = new ArrayList();
        }
        curr_list.add(item_name);
        grocery_map.put(category, curr_list);
    }

    // returns the remaining items in the given category
    public List<String> getItemsInCategory(String category) {
        return grocery_map.get(category);
    }

    // returns categories
    public Set<String> getRemainingCategories() {
        Set<String> remaining_categories = new HashSet<>();
        for (String cat: grocery_map.keySet()) {
            if (!isCategoryEmpty(cat)) {
                remaining_categories.add(cat);
            }
        }
        return remaining_categories;
    }

    // returns true if every item in the category is found
    private boolean isCategoryEmpty(String category) {
        List<String> items = getItemsInCategory(category);
        return (items.size() == 0);
    }

    // check off an item as found
    public void checkoffItem(String item_name) {
        List<String> items = getItemsInCategory(getCategory(item_name));
        for (String item: items) {
            if (item.equals(item_name)) {
                hasFound.add(item_name);
                items.remove(item_name);
                return;
            }
        }
    }

    public List<String> getFoundItems() {
        return hasFound;
    }


}
