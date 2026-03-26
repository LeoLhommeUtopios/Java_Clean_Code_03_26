package org.example.Kata2;

public class ClothingProduct extends Product{
    private boolean isImported;

    public ClothingProduct(double basePrice,boolean isImported) {
        super(basePrice);
        this.isImported = isImported;
    }

    @Override
    public double calculaterPrice() {
        double price = basePrice + basePrice * 0.2;

        if(isImported){
            price += basePrice * 0.05;
        }
        return price;
    }
}
