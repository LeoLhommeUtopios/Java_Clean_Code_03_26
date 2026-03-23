package org.example;

import java.util.List;

public class Order {
    public List<Item> getItems (){
        return null;
    }

    public double getTotal (){
        return getItems().stream().mapToDouble(Item::getPrice).sum();
    }

    public String getAddress (){
        return null;
    }
}
