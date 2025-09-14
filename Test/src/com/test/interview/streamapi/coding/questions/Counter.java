package com.test.interview.streamapi.coding.questions;

public class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
    
    private String getItemName(String itemName) { 
        //Some logic
        if(itemName.equals("computer")) {
        return itemName;
        }
       return "laptop"; 
 }
}