package org.example.SolutionKataTDD;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SmartRefrigerator {

    private List<FoodItem> items = new ArrayList<>();

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void addItem (String name , LocalDateTime expirationDate){
        items.add(new FoodItem(name,expirationDate));
    }

    public List<FoodItem> getItems (){
        return items;
    }

    public void open (){
        for (FoodItem f : items){
            if (f.isSealed()){
                f.setExpirationDate(f.getExpirationDateTime().minusHours(1));
            }else{
                f.setExpirationDate(f.getExpirationDateTime().minusHours(5));
            }
        }
    }
}
