package com.cmdf2019.readyforaction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Checklist {
    // KEY = CATEGORY, VALUE = LIST OF ITEMS
    public Map<String, List<Item>> grocery_map;
    // reference: https://toughnickel.com/frugal-living/How-to-Create-a-Standardized-Grocery-Shopping-List
    // KEY = ITEM NAME, VALUE = CATEGORY
    public Map<String, String> database;
    // a list of items that have been found
    public List<String> hasFound;


    public Checklist() {
        grocery_map = new TreeMap<>();
        database = new TreeMap<>();
        hasFound = new ArrayList<>();

        // load the grocery spreadsheet into TreeMap database object
        try (BufferedReader br = new BufferedReader(new FileReader("GroceryDB.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                database.put(values[0], values[1]);
            }
        }catch (Exception e) {
            System.out.println("Error while reading database");
        }
    }

    // called each time an item is added by the user to the checklist
    public void addItem(String item_name) {
        String category = database.get(item_name);
        List curr_list;
        if (grocery_map.containsKey(category)) {
            curr_list = grocery_map.get(category);
        }else {
            curr_list = new ArrayList();
        }
        curr_list.add(new Item(item_name));
        grocery_map.put(category, curr_list);
    }

    // returns the item in the given category
    public List<Item> getItemsInCategory(String category) {
        return grocery_map.get(category);
    }

    // returns all remaining categories
    public Set<String> getCategories() {
        return grocery_map.keySet();
    }

    public boolean isCategoryEmpty(String category) {
        List<Item> items = getItemsInCategory(category);
        int count = 0;
        for (Item item: items) {
            // if item is not found, then category is not empty -> return false
            if (!item.isFound())
                return false;
        }
        // all items found, return true
        return true;
    }


    // includes both item name and whether it has been found or not
    public class Item {

        boolean found;
        String item_name;

        public Item(String name) {
            this.found = false;
            this.item_name = name;
        }

        public void markAsFound() {
            found = true;
        }

        public boolean isFound() {
            return found;
        }


    }


}
