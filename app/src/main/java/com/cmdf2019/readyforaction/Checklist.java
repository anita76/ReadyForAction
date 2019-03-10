package com.cmdf2019.readyforaction;

import java.io.BufferedReader;
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


    public Checklist(Map<String, String> database) {
        grocery_map = new HashMap<>();
        this.database = database;
        hasFound = new ArrayList<>();
    }

    public String getCategory(String item) {
        return database.get(item);
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
