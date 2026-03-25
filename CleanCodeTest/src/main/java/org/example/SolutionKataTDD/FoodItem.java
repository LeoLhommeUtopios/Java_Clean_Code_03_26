package org.example.SolutionKataTDD;

import java.time.LocalDateTime;

public class FoodItem {

    private String nameItem;
    private LocalDateTime expirationDate;
    private LocalDateTime addDate;
    private boolean isSealed;

    public FoodItem(String nameItem, LocalDateTime expirationDate) {
        this.nameItem = nameItem;
        this.expirationDate = expirationDate;
        addDate = LocalDateTime.now();
        isSealed = true;
    }

    public String getNameItem(){
        return nameItem;
    }
    public LocalDateTime getExpirationDateTime(){
        return expirationDate;
    }

    public boolean isSealed (){
        return isSealed;
    }

    public void setExpirationDate(LocalDateTime expirationDate){
        this.expirationDate = expirationDate;
    }

    public void unSeal (){
        isSealed = false;
    }

}
