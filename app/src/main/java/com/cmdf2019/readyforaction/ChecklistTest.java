package com.cmdf2019.readyforaction;

import java.util.List;
import java.util.Set;

public class ChecklistTest {

    public static void main(String[] args) {
        Checklist checklist = new Checklist();
        checklist.addItem("Apple");
        checklist.addItem("Bagel");
        Set<String> categories = checklist.getCategories();
        for (String category: categories) {
            System.out.println("In category: " + category);
            List<Checklist.Item> items = checklist.getItemsInCategory(category);
            for (Checklist.Item item: items) {
                System.out.println("Item: " + item.item_name);
                System.out.println("Found? : " + item.isFound());
                System.out.println("After marked as found");
                item.markAsFound();
                System.out.println("Found? : " + item.isFound());
            }
        }

    }
}
