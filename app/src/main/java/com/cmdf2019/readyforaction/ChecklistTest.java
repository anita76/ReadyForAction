package com.cmdf2019.readyforaction;

import java.util.List;
import java.util.Set;

public class ChecklistTest {

    public static void main(String[] args) {
        Checklist checklist = new Checklist();
        checklist.addItem("Apple");
        checklist.addItem("Bagel");
        Set<String> categories = checklist.getRemainingCategories();
        for (String category: categories) {
            System.out.println("In category: " + category);
            List<String> items = checklist.getItemsInCategory(category);
            for (String item: items) {
                System.out.println("Item: " + item);
            }
        }

    }
}
