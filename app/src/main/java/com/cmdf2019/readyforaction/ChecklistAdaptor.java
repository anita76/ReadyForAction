package com.cmdf2019.readyforaction;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChecklistAdaptor extends RecyclerView.Adapter<ChecklistAdaptor.MyViewHolder> {
    private Map<String, Boolean> result;
    private List<String> list;
    private Checklist checklist;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CheckBox checkbox;
        public MyViewHolder(FrameLayout v) {
            super(v);
            checkbox = v.findViewById(R.id.checkBox);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChecklistAdaptor(Checklist checklist) {
        this.checklist = checklist;
        createMap();
    }

    private void createMap() {
        this.result = new HashMap<>();
        // add not found items
        for (String cat: checklist.getRemainingCategories()) {
            for (String item: checklist.getItemsInCategory(cat)) {
                result.put(item.concat(" (").concat(cat).concat(")"), false);
            }
        }
        //add found items
        for (String item: checklist.getFoundItems()) {
            result.put(item, true);
        }
        this.list = new ArrayList(result.keySet());
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChecklistAdaptor.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        FrameLayout v = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.checklist_item, parent, false);
        CheckBox box = (CheckBox) v.getChildAt(0);
        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Here");
                onCheckboxClicked(v);
            }
        });
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public void onCheckboxClicked(View view) {
        CheckBox box = (CheckBox) view;
        boolean checked = box.isChecked();
        if (checked) {
            String item_name = box.getText().toString();
            String[] parts = item_name.split(" \\(");
            checklist.checkoffItem(parts[0]);
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.checkbox.setText(list.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }

}
